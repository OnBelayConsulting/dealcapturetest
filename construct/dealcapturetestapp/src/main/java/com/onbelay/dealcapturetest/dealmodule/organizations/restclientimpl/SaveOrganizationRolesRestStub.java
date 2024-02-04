package com.onbelay.dealcapturetest.dealmodule.organizations.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.SaveOrganizationRolesRestClient;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.OrganizationRoleSnapshot;

import java.util.List;

public class SaveOrganizationRolesRestStub implements SaveOrganizationRolesRestClient {
    @Override
    public TransactionResult saveOrganizationRoles(
            Integer organizationId,
            List<OrganizationRoleSnapshot> snapshots) {

        return new TransactionResult(4);
    }
}
