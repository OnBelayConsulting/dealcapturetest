package com.onbelay.dealcapturetest.organization.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.organization.restclient.SaveOrganizationsRestClient;
import com.onbelay.dealcapturetest.organization.snapshot.OrganizationSnapshot;

import java.util.List;

public class SaveOrganizationsRestStub implements SaveOrganizationsRestClient {
    @Override
    public TransactionResult createOrganization(List<OrganizationSnapshot> snapshots) {
        return new TransactionResult();
    }
}
