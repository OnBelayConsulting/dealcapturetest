package com.onbelay.dealcapturetest.testharness.adapter;

import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.testharness.snapshot.*;

public interface TestHarnessRestAdapter {

    TransactionResult generateOrganizationsRequest(GenerateOrganizationsRequest request);

    TransactionResult generateCompaniesRequest(GenerateCompaniesRequest request);

    TransactionResult generateCounterpartiesRequest(GenerateCounterpartiesRequest request);

    TransactionResult generatePriceIndices(GeneratePriceIndicesRequest request);

    TransactionResult generateFxIndices(GenerateFxIndicesRequest request);

    TransactionResult generatePricingLocations(GeneratePricingLocationsRequest request);

    TransactionResult generatePhysicalDeals(GeneratePhysicalDealsRequest request);

    TransactionResult generatePrices(GenerateCurvesRequest request);

    TransactionResult generateFxRates(GenerateCurvesRequest request);

    TransactionResult valueFxRiskFactors(String queryText);

    TransactionResult valuePriceRiskFactors(String queryText);

    TransactionResult valuePositions(String queryText);

    TransactionResult generatePositions(GeneratePositionsRequest request);

}
