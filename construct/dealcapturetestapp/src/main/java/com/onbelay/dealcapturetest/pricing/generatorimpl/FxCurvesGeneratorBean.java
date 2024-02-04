package com.onbelay.dealcapturetest.pricing.generatorimpl;

import com.onbelay.dealcapturetest.pricing.generator.FxCurvesGenerator;
import com.onbelay.dealcapturetest.pricing.snapshot.FxCurveSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCurvesRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FxCurvesGeneratorBean implements FxCurvesGenerator {

    @Override
    public List<FxCurveSnapshot> generateFxRates(GenerateCurvesRequest request) {

        ArrayList<FxCurveSnapshot> snapshots = new ArrayList<>();

        LocalDate currentDate = request.getStartDate();
        while (currentDate.isAfter(request.getEndDate()) == false) {
            FxCurveSnapshot snapshot = new FxCurveSnapshot();
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
