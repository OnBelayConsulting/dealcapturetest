package com.onbelay.dealcapturetest.pricing.generatorimpl;

import com.onbelay.core.entity.snapshot.EntityId;
import com.onbelay.dealcapturetest.pricing.generator.PriceIndicesGenerator;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceIndexSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GeneratePriceIndicesRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceIndicesGeneratorBean implements PriceIndicesGenerator {
    
    @Override
    public List<PriceIndexSnapshot> generatePriceIndices(
            EntityId pricingLocationId,
            GeneratePriceIndicesRequest request) {

        ArrayList<PriceIndexSnapshot> snapshots = new ArrayList<>();
        for (int i=0; i < request.getTotal(); i++) {
            
            String name = request.getIndexNamePrefix() + "_" + i;
            PriceIndexSnapshot snapshot = new PriceIndexSnapshot();
            snapshot.setPricingLocationId(pricingLocationId);
            snapshot.getDetail().setName(name);
            snapshot.getDetail().setDescription(name);
            snapshot.getDetail().setCurrencyCodeValue(request.getCurrencyCode());
            snapshot.getDetail().setUnitOfMeasureCodeValue(request.getUnitOfMeasureCode());
            snapshot.getDetail().setFrequencyCodeValue("D");
            snapshot.getDetail().setIndexTypeValue("H");
            snapshots.add(snapshot);
        }
        return snapshots;
    }
}
