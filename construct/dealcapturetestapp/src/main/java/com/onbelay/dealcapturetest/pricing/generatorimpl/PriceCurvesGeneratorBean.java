package com.onbelay.dealcapturetest.pricing.generatorimpl;

import com.onbelay.dealcapturetest.pricing.generator.PriceCurvesGenerator;
import com.onbelay.dealcapturetest.pricing.snapshot.PriceCurveSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCurvesRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PriceCurvesGeneratorBean implements PriceCurvesGenerator {

    @Override
    public List<PriceCurveSnapshot> generatePrices(GenerateCurvesRequest request) {

        ArrayList<PriceCurveSnapshot> snapshots = new ArrayList<>();

        LocalDate currentDate = request.getStartDate();
        while (currentDate.isAfter(request.getEndDate()) == false) {
            PriceCurveSnapshot snapshot = new PriceCurveSnapshot();
            snapshot.getDetail().setCurveDate(currentDate);
            snapshot.getDetail().setObservedDateTime(request.getObservedDateTime());
            snapshot.getDetail().setCurveValue(request.getValue());
            snapshot.getDetail().setFrequencyCodeValue(request.getFrequencyCode());

            snapshots.add(snapshot);
            currentDate = currentDate.plusDays(1);
        }

        return snapshots;
    }
}
