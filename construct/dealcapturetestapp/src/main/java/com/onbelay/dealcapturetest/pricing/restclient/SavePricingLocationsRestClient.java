package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshot;

import java.util.List;

public interface SavePricingLocationsRestClient {

    TransactionResult createPricingLocations(List<PricingLocationSnapshot> snapshots);

}
