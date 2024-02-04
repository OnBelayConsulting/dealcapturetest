package com.onbelay.dealcapturetest.dealmodule.organizations.restclientimpl;

import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.FindDealOrganizationsRestClient;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.SaveOrganizationRolesRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DealOrganizationRestClientConfig {

    @Value(value ="${dealcapture.host:localhost}")
    private String dealcaptureHost;

    @Value(value ="${dealcapture.port:9100}")
    private String dealcapturePort;

    @Value(value ="${dealcapture.contextname:Organizations}")
    private String dealcaptureContextName;

    @Value(value ="${dealcapture.useAPI:false}")
    private boolean useAPI;

    @Bean
    public FindDealOrganizationsRestClient getFindOrganizationsRestClient() {
        if (useAPI)
            return new FindDealOrganizationsRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new FindDealOrganizationsRestStub();
    }

    @Bean
    public SaveOrganizationRolesRestClient getSaveOrganizationRolesRestClient() {
        if (useAPI)
            return new SaveOrganizationRolesRestClientImpl(
                    dealcaptureHost,
                    dealcapturePort,
                    dealcaptureContextName);
        else
            return new SaveOrganizationRolesRestStub();
    }

}
