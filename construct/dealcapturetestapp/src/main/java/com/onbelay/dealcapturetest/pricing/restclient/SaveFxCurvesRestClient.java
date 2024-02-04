package com.onbelay.dealcapturetest.pricing.restclient;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.snapshot.FxCurveSnapshot;

import java.util.List;

public interface SaveFxCurvesRestClient {

    public TransactionResult saveFxCurves(
            Integer priceIndexId,
            List<FxCurveSnapshot> snapshots);
}
