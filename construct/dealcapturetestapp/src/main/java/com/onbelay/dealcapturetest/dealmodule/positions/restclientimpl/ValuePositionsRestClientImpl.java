package com.onbelay.dealcapturetest.dealmodule.positions.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.positions.restclient.ValuePositionsRestClient;
import com.onbelay.dealcapturetest.restclient.client.AbstractRestClient;
import com.onbelay.dealcapturetest.restclient.exception.ApplicationExceptionFactory;
import com.onbelay.dealcapturetest.restclient.exception.ApplicationWebClientException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.util.retry.Retry;

import java.time.Duration;

public class ValuePositionsRestClientImpl extends AbstractRestClient implements ValuePositionsRestClient {
    private static final Logger logger = LogManager.getLogger();

    private static final String URL = "/api/positions/valued";

    private String host;

    private String port;
    private String contextPath;

    @Autowired
    private ApplicationExceptionFactory applicationExceptionFactory;

    @Autowired
    private WebClient webClient;

    public ValuePositionsRestClientImpl
            (String host,
             String port,
             String contextPath) {

        super();
        this.host = host;
        this.port = port;
        this.contextPath = contextPath;
    }

    @Override
    public TransactionResult valuePositions(String queryText) {

        String errorDetected;
        try {
             return this.webClient.post()
                     .uri(uriBuilder -> uriBuilder
                             .scheme("http")
                             .host(host)
                             .port(port)
                             .path(contextPath)
                             .queryParam("query", queryText)
                             .path(URL)
                    .build())
                    .contentType(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(TransactionResult.class)
                     .retryWhen(Retry.backoff(3, Duration.ofSeconds(10))
                                        .filter(checkThrowable)
                                        .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                                                                       applicationExceptionFactory.newApplicationWebClientExceptionTimeout("Risk")))
                    .block();

        } catch (WebClientException r) {
            logger.error("Webclient Rest call failed: {}", r.getMessage());
            throw new ApplicationWebClientException(HttpStatus.BAD_GATEWAY, r.getMessage());
        }
    }

}