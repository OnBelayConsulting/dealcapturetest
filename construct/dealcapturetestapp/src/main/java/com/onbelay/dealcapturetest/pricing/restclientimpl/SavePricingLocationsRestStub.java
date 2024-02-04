package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.restclient.SavePricingLocationsRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshot;

import java.util.List;

public class SavePricingLocationsRestStub implements SavePricingLocationsRestClient {
    @Override
    public TransactionResult createPricingLocations(List<PricingLocationSnapshot> snapshots) {
        return new TransactionResult();
    }
}
