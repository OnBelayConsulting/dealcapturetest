package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.restclient.SaveFxCurvesRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.FxCurveSnapshot;

import java.util.List;

public class SaveFxCurvesRestStub implements SaveFxCurvesRestClient {
    @Override
    public TransactionResult saveFxCurves(Integer priceIndexId, List<FxCurveSnapshot> snapshots) {
        return new TransactionResult();
    }
}
