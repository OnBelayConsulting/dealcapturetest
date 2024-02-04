package com.onbelay.dealcapturetest.pricing.generator;

import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GeneratePricingLocationsRequest;

import java.util.List;

public interface PricingLocationsGenerator {

    public List<PricingLocationSnapshot> generateLocations(GeneratePricingLocationsRequest request);

}
