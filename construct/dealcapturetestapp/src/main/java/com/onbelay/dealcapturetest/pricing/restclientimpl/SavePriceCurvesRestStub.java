package com.onbelay.dealcapturetest.pricing.restclientimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.pricing.restclient.SavePriceCurvesRestClient;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceCurveSnapshot;

import java.util.List;

public class SavePriceCurvesRestStub implements SavePriceCurvesRestClient {
    @Override
    public TransactionResult savePriceCurves(
            Integer priceIndexId,
            List<PriceCurveSnapshot> snapshots) {
        return new TransactionResult(4);
    }
}
