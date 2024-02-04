package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceCurveSnapshot;

import java.util.List;

public interface SavePriceCurvesRestClient {

    public TransactionResult savePriceCurves(
            Integer priceIndexId,
            List<PriceCurveSnapshot> snapshots);
}
