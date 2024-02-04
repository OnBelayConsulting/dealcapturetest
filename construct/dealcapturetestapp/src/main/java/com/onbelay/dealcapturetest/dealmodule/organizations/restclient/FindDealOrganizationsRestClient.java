package com.onbelay.dealcapturetest.dealmodule.organizations.restclient;

import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.DealOrganizationSnapshotCollection;

public interface FindDealOrganizationsRestClient {

    DealOrganizationSnapshotCollection findOrganizations(
            String query,
            long start,
            int limit);

}
