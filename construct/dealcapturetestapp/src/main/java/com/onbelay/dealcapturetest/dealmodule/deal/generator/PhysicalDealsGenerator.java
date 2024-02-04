package com.onbelay.dealcapturetest.dealmodule.deal.generator;

import com.onbelay.dealcapturetest.dealmodule.deal.snapshot.BaseDealSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GeneratePhysicalDealsRequest;

import java.util.List;

public interface PhysicalDealsGenerator {

    public List<BaseDealSnapshot> generateDeals(GeneratePhysicalDealsRequest request);

}
