package com.onbelay.dealcapturetest.pricing.generator;

import com.onbelay.dealcapturetest.pricing.snapshot.FxCurveSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCurvesRequest;

import java.util.List;

public interface FxCurvesGenerator {

    List<FxCurveSnapshot> generateFxRates(GenerateCurvesRequest request);

}
