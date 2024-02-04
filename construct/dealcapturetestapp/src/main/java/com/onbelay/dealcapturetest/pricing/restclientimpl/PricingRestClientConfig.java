package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.dealcapturetest.pricing.restclient.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PricingRestClientConfig {

    @Value(value ="${dealcapture.host:localhost}")
    private String dealcaptureHost;

    @Value(value ="${dealcapture.port:9101}")
    private String dealcapturePort;

    @Value(value ="${dealcapture.contextname:DealCapture}")
    private String dealcaptureContextName;

    @Value(value ="${dealcapture.useAPI:false}")
    private boolean useAPI;

    @Bean
    public FindPricingLocationsRestClient getFindPricingLocationsRestClient() {
        if (useAPI)
            return new FindPricingLocationsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new FindPricingLocationsRestStub();
    }

    @Bean
    public FindPriceIndicesRestClient getFindPriceIndicesRestClient() {
        if (useAPI)
            return new FindPriceIndicesRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new FindPriceIndicesRestClientStub();
    }

    @Bean
    public FindFxIndicesRestClient getFindFxIndicesRestClient() {
        if (useAPI)
            return new FindFxIndicesRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new FindFxIndicesRestStub();
    }


    @Bean
    public SavePriceIndicesRestClient getSavePriceIndicesRestClient() {
        if (useAPI)
            return new SavePriceIndicesRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new SavePriceIndicesRestStub();
    }

    @Bean
    public SaveFxIndicesRestClient getSaveFxIndicesRestClient() {
        if (useAPI)
            return new SaveFxIndicesRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new SaveFxIndicesRestStub();
    }


    @Bean
    public SavePriceCurvesRestClient getSavePriceCurvesRestClient() {
        if (useAPI)
            return new SavePriceCurvesRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new SavePriceCurvesRestStub();
    }


    @Bean
    public SaveFxCurvesRestClient getSaveFxCurvesRestClient() {
        if (useAPI)
            return new SaveFxCurvesRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new SaveFxCurvesRestStub();
    }

    @Bean
    public SavePricingLocationsRestClient getSavePricingLocationRestClient() {
        if (useAPI)
            return new SavePricingLocationsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new SavePricingLocationsRestStub();
    }

}
