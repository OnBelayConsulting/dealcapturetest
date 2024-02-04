package com.onbelay.dealcapturetest.pricing.generator;

import com.onbelay.dealcapturetest.pricing.snapshot.FxIndexSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateFxIndicesRequest;

import java.util.List;

public interface FxIndicesGenerator {
    List<FxIndexSnapshot> generateFxIndices(GenerateFxIndicesRequest request);
}
