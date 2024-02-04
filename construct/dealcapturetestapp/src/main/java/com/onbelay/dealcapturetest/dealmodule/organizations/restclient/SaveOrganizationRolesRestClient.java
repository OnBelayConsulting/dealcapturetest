package com.onbelay.dealcapturetest.dealmodule.organizations.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.OrganizationRoleSnapshot;

import java.util.List;

public interface SaveOrganizationRolesRestClient {

    public TransactionResult saveOrganizationRoles(
            Integer organizationId,
            List<OrganizationRoleSnapshot> snapshots);

}
