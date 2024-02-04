package com.onbelay.dealcapturetest.pricing.generatorimpl;

import com.onbelay.dealcapturetest.pricing.generator.FxIndicesGenerator;
import com.onbelay.dealcapturetest.pricing.snapshot.FxIndexSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateFxIndicesRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FxIndicesGeneratorBean implements FxIndicesGenerator {

    @Override
    public List<FxIndexSnapshot> generateFxIndices(GenerateFxIndicesRequest request) {
        FxIndexSnapshot snapshot = new FxIndexSnapshot();
        snapshot.getDetail().setDefaults();
        snapshot.getDetail().setName(request.getIndexName());
        snapshot.getDetail().setFromCurrencyCodeValue(request.getFromCurrencyCode());
        snapshot.getDetail().setToCurrencyCodeValue(request.getToCurrencyCode());
        snapshot.getDetail().setFrequencyValue(request.getFrequencyCode());
        snapshot.getDetail().setDaysOffsetForExpiry(1);
        return List.of(snapshot);
    }

}
