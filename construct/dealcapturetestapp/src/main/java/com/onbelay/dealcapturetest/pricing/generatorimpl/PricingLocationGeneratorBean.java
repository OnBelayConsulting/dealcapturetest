package com.onbelay.dealcapturetest.pricing.generatorimpl;

import com.onbelay.dealcapturetest.pricing.generator.PricingLocationsGenerator;
import com.onbelay.dealcapturetest.pricing.snapshot.PricingLocationSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GeneratePricingLocationsRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PricingLocationGeneratorBean implements PricingLocationsGenerator {

    @Override
    public List<PricingLocationSnapshot> generateLocations(GeneratePricingLocationsRequest request) {
        ArrayList<PricingLocationSnapshot> snapshots = new ArrayList<>();
        for (int i=0; i < request.getTotal(); i++) {

            String locationName = request.getLocationNamePrefix() + "_" + i;
            PricingLocationSnapshot snapshot = new PricingLocationSnapshot();
            snapshot.getDetail().setCountryCode("CA");
            snapshot.getDetail().setStateProvinceCode("BC");
            snapshot.getDetail().setName(locationName);
            snapshot.getDetail().setDescription(locationName);
            snapshots.add(snapshot);
        }
        return snapshots;
    }
}
