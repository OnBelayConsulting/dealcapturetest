package com.onbelay.dealcapturetest.pricing.generator;

import com.onbelay.dealcapturetest.pricing.snapshot.PriceCurveSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCurvesRequest;

import java.util.List;

public interface PriceCurvesGenerator {

    List<PriceCurveSnapshot> generatePrices(GenerateCurvesRequest request);

}
