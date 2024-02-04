package com.onbelay.dealcapturetest.pricing.generator;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GeneratePriceIndicesRequest;

import java.util.List;

public interface PriceIndicesGenerator {

    public List<PriceIndexSnapshot> generatePriceIndices(
            EntityId pricingLocationId,
            GeneratePriceIndicesRequest request);
}
