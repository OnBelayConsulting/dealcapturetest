package com.onbelay.dealcapturetest.dealmodule.organizations.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.FindDealOrganizationsRestClient;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.DealOrganizationSnapshot;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.DealOrganizationSnapshotCollection;

import java.util.List;

public class FindDealOrganizationsRestStub implements FindDealOrganizationsRestClient {

    @Override
    public DealOrganizationSnapshotCollection findOrganizations(
            String query,
            long start,
            int limit) {

        DealOrganizationSnapshot snapshot = new DealOrganizationSnapshot();
        snapshot.setEntityId(new EntityId(5));
        snapshot.getDetail().setShortName("TEst");
        snapshot.getDetail().setLegalName("TEst LLC");
        return new DealOrganizationSnapshotCollection(
                0,
                1,
                1,
                List.of(snapshot));
    }

}
