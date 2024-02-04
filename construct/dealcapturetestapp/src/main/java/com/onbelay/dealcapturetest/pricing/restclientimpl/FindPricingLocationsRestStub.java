package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.dealcapturetest.pricing.restclient.FindPricingLocationsRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshot;
import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshotCollection;

import java.util.List;

public class FindPricingLocationsRestStub implements FindPricingLocationsRestClient {
    @Override
    public PricingLocationSnapshotCollection findPricingLocations(
            String query,
            long start,
            int limit) {

        PricingLocationSnapshot snapshot = new PricingLocationSnapshot();
        snapshot.setEntityId(new EntityId(8));
        snapshot.getDetail().setName("testloc");
        snapshot.getDetail().setDescription("testloc");
        snapshot.getDetail().setCountryCode("CA");
        snapshot.getDetail().setStateProvinceCode("BC");
        return new PricingLocationSnapshotCollection(
                0,
                100,
                1,
                List.of(snapshot));

    }
}
