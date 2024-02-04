package com.onbelay.dealcapturetest.dealmodule.deal.restclientimpl;

import com.onbelay.dealcapturetest.dealmodule.deal.restclient.SaveDealsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DealRestClientConfig {

    @Value(value ="${dealcapture.host:localhost}")
    private String dealcaptureHost;

    @Value(value ="${dealcapture.port:9000}")
    private String dealcapturePort;

    @Value(value ="${dealcapture.contextname:DealCapture}")
    private String dealcaptureContextName;

    @Value(value ="${dealcapture.useAPI:false}")
    private boolean useAPI;

    @Bean
    public SaveDealsRestClient getCreateDealsRestClient() {
        if (useAPI)
            return new SaveDealsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new SaveDealsRestClientStub();
    }


}
