package com.onbelay.dealcapturetest.organization.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.organization.snapshot.OrganizationSnapshot;

import java.util.List;

public interface SaveOrganizationsRestClient {

    public TransactionResult createOrganization(List<OrganizationSnapshot> snapshots);

}
