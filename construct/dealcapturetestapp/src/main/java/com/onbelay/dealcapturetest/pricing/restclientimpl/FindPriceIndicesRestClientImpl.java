package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.dealcapturetest.pricing.restclient.FindPriceIndicesRestClient;
import com.onbelay.dealcapturetest.pricing.restclient.FindPricingLocationsRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshotCollection;
import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshotCollection;
import com.onbelay.dealcapturetest.restclient.client.AbstractRestClient;
import com.onbelay.dealcapturetest.restclient.exception.ApplicationExceptionFactory;
import com.onbelay.dealcapturetest.restclient.exception.ApplicationWebClientException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.util.retry.Retry;

import java.time.Duration;

public class FindPriceIndicesRestClientImpl extends AbstractRestClient implements FindPriceIndicesRestClient {

    private static final Logger logger = LogManager.getLogger();

    private String host;

    private String port;
    private String contextPath;

    @Autowired
    private ApplicationExceptionFactory applicationExceptionFactory;

    @Autowired
    private WebClient webClient;

    private static final String URL = "/api/priceIndices";

    public FindPriceIndicesRestClientImpl(
            String host,
            String port,
            String contextPath) {
        this.host = host;
        this.port = port;
        this.contextPath = contextPath;
    }

    @Override
    public PriceIndexSnapshotCollection findPriceIndices(
            String query,
            long start,
            int limit) {

        PriceIndexSnapshotCollection snapshot;

        try {
            snapshot = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .scheme("http")
                            .host(host)
                            .port(port)
                            .path(contextPath)
                            .path(URL)
                            .queryParam("query", query)
                            .queryParam("start", start)
                            .queryParam("limit", limit)
                            .build())
                    .retrieve()
                    .bodyToMono(PriceIndexSnapshotCollection.class)
                    .retryWhen(Retry.backoff(3, Duration.ofSeconds(20))
                                       .filter(checkThrowable)
                                       .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                                                                      applicationExceptionFactory.newApplicationWebClientExceptionTimeout("RiskApp")))
                    .block();
        } catch (WebClientException r) {
            logger.error("Webclient Rest call failed: {}", r.getMessage());
            throw new ApplicationWebClientException(HttpStatus.BAD_GATEWAY, "failed");
        }

        return snapshot;
    }
    
}
