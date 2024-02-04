package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshotCollection;

public interface FindPricingLocationsRestClient {

    public PricingLocationSnapshotCollection findPricingLocations(
            String query,
            long start,
            int limit);

}
