package com.onbelay.dealcapturetest.dealmodule.positions.restclientimpl;

import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.FindDealOrganizationsRestClient;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.SaveOrganizationRolesRestClient;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclientimpl.FindDealOrganizationsRestClientImpl;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclientimpl.FindDealOrganizationsRestStub;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclientimpl.SaveOrganizationRolesRestClientImpl;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclientimpl.SaveOrganizationRolesRestStub;
import com.onbelay.dealcapturetest.dealmodule.positions.restclient.GeneratePositionsRestClient;
import com.onbelay.dealcapturetest.dealmodule.positions.restclient.ValuePositionsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PositionsRestClientConfig {

    @Value(value ="${dealcapture.host:localhost}")
    private String dealcaptureHost;

    @Value(value ="${dealcapture.port:9000}")
    private String dealcapturePort;

    @Value(value ="${dealcapture.contextname:DealCapture}")
    private String dealcaptureContextName;

    @Value(value ="${dealcapture.useAPI:false}")
    private boolean useAPI;

    @Bean
    public GeneratePositionsRestClient getGeneratePositionsRestClient() {
        if (useAPI)
            return new GeneratePositionsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new GeneratePositionsRestClientStub();
    }

    @Bean
    public ValuePositionsRestClient getValuePositionsRestClient() {
        if (useAPI)
            return new ValuePositionsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new ValuePositionsRestClientStub();
    }

}
