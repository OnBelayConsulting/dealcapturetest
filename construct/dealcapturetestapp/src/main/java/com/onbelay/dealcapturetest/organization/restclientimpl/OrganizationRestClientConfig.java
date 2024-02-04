package com.onbelay.dealcapturetest.organization.restclientimpl;

import com.onbelay.dealcapturetest.organization.restclient.SaveOrganizationsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrganizationRestClientConfig {

    @Value(value ="${organizations.host:localhost}")
    private String organizationHost;

    @Value(value ="${organizations.port:9100}")
    private String organizationPort;

    @Value(value ="${organizations.contextname:Organizations}")
    private String organizationContextName;

    @Value(value ="${organizations.useAPI:false}")
    private boolean useAPI;

    @Bean
    public SaveOrganizationsRestClient getCreateOrganizationsRestClient() {
        if (useAPI)
            return new SaveOrganizationsRestClientImpl(
                    organizationHost,
                    organizationPort,
                    organizationContextName);
        else
            return new SaveOrganizationsRestStub();
    }


}
