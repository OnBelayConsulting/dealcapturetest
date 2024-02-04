package com.onbelay.dealcapturetest.riskfactor.restclientimpl;

import com.onbelay.dealcapturetest.riskfactor.restclient.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiskFactorRestClientConfig {

    @Value(value ="${dealcapture.host:localhost}")
    private String dealcaptureHost;

    @Value(value ="${dealcapture.port:9100}")
    private String dealcapturePort;

    @Value(value ="${dealcapture.contextname:DealCapture}")
    private String dealcaptureContextName;

    @Value(value ="${dealcapture.useAPI:false}")
    private boolean useAPI;

    @Bean
    public ValueFxRiskFactorsRestClient getValueFxRiskFactorsRestClient() {
        if (useAPI)
            return new ValueFxRiskFactorsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new ValueRxRiskFactorsRestStub();
    }

    @Bean
    public ValuePriceRiskFactorsRestClient getValuePriceRiskFactorsRestClient() {
        if (useAPI)
            return new ValuePriceRiskFactorsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new ValuePriceRiskFactorsRestStub();
    }

}
