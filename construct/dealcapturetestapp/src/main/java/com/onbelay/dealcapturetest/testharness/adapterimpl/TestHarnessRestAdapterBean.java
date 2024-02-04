package com.onbelay.dealcapturetest.testharness.adapterimpl;

import com.onbelay.core.controller.BaseRestAdapterBean;
import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.core.utils.SubLister;
import com.onbelay.dealcapturetest.dealmodule.deal.generator.PhysicalDealsGenerator;
import com.onbelay.dealcapturetest.dealmodule.deal.restclient.SaveDealsRestClient;
import com.onbelay.dealcapturetest.dealmodule.deal.snapshot.BaseDealSnapshot;
import com.onbelay.dealcapturetest.dealmodule.organizations.generator.OrganizationRolesGenerator;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.FindDealOrganizationsRestClient;
import com.onbelay.dealcapturetest.dealmodule.organizations.restclient.SaveOrganizationRolesRestClient;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.CompanyRoleSnapshot;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.CounterpartyRoleSnapshot;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.DealOrganizationSnapshot;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.DealOrganizationSnapshotCollection;
import com.onbelay.dealcapturetest.dealmodule.positions.restclient.GeneratePositionsRestClient;
import com.onbelay.dealcapturetest.dealmodule.positions.restclient.ValuePositionsRestClient;
import com.onbelay.dealcapturetest.dealmodule.positions.snapshot.EvaluationContextRequest;
import com.onbelay.dealcapturetest.organization.generator.OrganizationsGenerator;
import com.onbelay.dealcapturetest.organization.restclient.SaveOrganizationsRestClient;
import com.onbelay.dealcapturetest.organization.snapshot.OrganizationSnapshot;
import com.onbelay.dealcapturetest.pricing.generator.*;
import com.onbelay.dealcapturetest.pricing.restclient.*;
import com.onbelay.dealcapturetest.pricing.snapshot.*;
import com.onbelay.dealcapturetest.riskfactor.restclient.ValueFxRiskFactorsRestClient;
import com.onbelay.dealcapturetest.riskfactor.restclient.ValuePriceRiskFactorsRestClient;
import com.onbelay.dealcapturetest.testharness.adapter.TestHarnessRestAdapter;
import com.onbelay.dealcapturetest.testharness.snapshot.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestHarnessRestAdapterBean extends BaseRestAdapterBean implements TestHarnessRestAdapter {

    @Autowired
    private OrganizationsGenerator organizationsGenerator;

    @Autowired
    private SaveOrganizationsRestClient saveOrganizationsRestClient;

    @Autowired
    private PricingLocationsGenerator pricingLocationsGenerator;

    @Autowired
    private FindPricingLocationsRestClient findPricingLocationsRestClient;

    @Autowired
    private SavePricingLocationsRestClient savePricingLocationsRestClient;

    @Autowired
    private PriceIndicesGenerator priceIndicesGenerator;

    @Autowired
    private SavePriceIndicesRestClient savePriceIndicesRestClient;

    @Autowired
    private FxIndicesGenerator fxIndicesGenerator;

    @Autowired
    private SaveFxIndicesRestClient saveFxIndicesRestClient;

    @Autowired
    private FindDealOrganizationsRestClient findDealOrganizationsRestClient;

    @Autowired
    private FindPriceIndicesRestClient findPriceIndicesRestClient;

    @Autowired
    private FindFxIndicesRestClient findFxIndicesRestClient;

    @Autowired
    OrganizationRolesGenerator organizationRolesGenerator;

    @Autowired
    private SaveOrganizationRolesRestClient saveOrganizationRolesRestClient;

    @Autowired
    private PhysicalDealsGenerator physicalDealsGenerator;

    @Autowired
    private SaveDealsRestClient saveDealsRestClient;

    @Autowired
    private PriceCurvesGenerator priceCurvesGenerator;

    @Autowired
    private FxCurvesGenerator fxCurvesGenerator;

    @Autowired
    private SavePriceCurvesRestClient savePriceCurvesRestClient;

    @Autowired
    private SaveFxCurvesRestClient saveFxCurvesRestClient;

    @Autowired
    private GeneratePositionsRestClient generatePositionsRestClient;

    @Autowired
    private ValuePositionsRestClient valuePositionsRestClient;

    @Autowired
    private ValueFxRiskFactorsRestClient valueFxRiskFactorsRestClient;

    @Autowired
    private ValuePriceRiskFactorsRestClient valuePriceRiskFactorsRestClient;

    @Override
    public TransactionResult generateOrganizationsRequest(GenerateOrganizationsRequest request) {

        List<OrganizationSnapshot> snapshots = organizationsGenerator.generateOrganizations(request);
        TransactionResult result  = saveOrganizationsRestClient.createOrganization(snapshots);

        return result;
    }

    @Override
    public TransactionResult generateCompaniesRequest(GenerateCompaniesRequest request) {

        DealOrganizationSnapshotCollection collection = findDealOrganizationsRestClient.findOrganizations(
                request.getQuery(),
                0,
                100);
        CompanyRoleSnapshot companyRoleSnapshot = organizationRolesGenerator.generateCompanyRole(request);

        TransactionResult overallResult = new TransactionResult();
        for (DealOrganizationSnapshot organizationSnapshot : collection.getSnapshots()) {
            TransactionResult childResult = saveOrganizationRolesRestClient.saveOrganizationRoles(
                    organizationSnapshot.getEntityId().getId(),
                    List.of(companyRoleSnapshot));
            overallResult.getIds().addAll(childResult.getIds());
        }

        return overallResult;
    }

    @Override
    public TransactionResult generateCounterpartiesRequest(GenerateCounterpartiesRequest request) {

        DealOrganizationSnapshotCollection collection = findDealOrganizationsRestClient.findOrganizations(
                request.getQuery(),
                0,
                100);
        CounterpartyRoleSnapshot roleSnapshot = organizationRolesGenerator.generateCounterpartyRole(request);

        TransactionResult overallResult = new TransactionResult();
        for (DealOrganizationSnapshot organizationSnapshot : collection.getSnapshots()) {
            TransactionResult childResult = saveOrganizationRolesRestClient.saveOrganizationRoles(
                                    organizationSnapshot.getEntityId().getId(),
                                    List.of(roleSnapshot));
            overallResult.getIds().addAll(childResult.getIds());
        }

        return overallResult;
    }

    @Override
    public TransactionResult generatePricingLocations(GeneratePricingLocationsRequest request) {

        List<PricingLocationSnapshot> snapshots = pricingLocationsGenerator.generateLocations(request);

        TransactionResult result = savePricingLocationsRestClient.createPricingLocations(snapshots);

        return result;
    }

    @Override
    public TransactionResult generatePriceIndices(GeneratePriceIndicesRequest request) {
        String locationQuery = "WHERE name eq '" + request.getLocationName() + "'";
        PricingLocationSnapshotCollection collection = findPricingLocationsRestClient.findPricingLocations(
                locationQuery,
                0,
                100);

        if (collection.getSnapshots().isEmpty())
            return new TransactionResult();
        PricingLocationSnapshot locationSnapshot = collection.getSnapshots().get(0);

        List<PriceIndexSnapshot> snapshots = priceIndicesGenerator.generatePriceIndices(
                locationSnapshot.getEntityId(),
                request);

        return savePriceIndicesRestClient.savePriceIndices(snapshots);
    }

    @Override
    public TransactionResult generateFxIndices(GenerateFxIndicesRequest request) {
        List<FxIndexSnapshot> snapshots = fxIndicesGenerator.generateFxIndices(request);
        return saveFxIndicesRestClient.saveFxIndices(snapshots);
    }

    @Override
    public TransactionResult generatePhysicalDeals(GeneratePhysicalDealsRequest request) {
        List<BaseDealSnapshot> deals = physicalDealsGenerator.generateDeals(request);
        SubLister<BaseDealSnapshot> subLister = new SubLister(deals, 100);
        TransactionResult overallResult = new TransactionResult();
        while (subLister.moreElements()) {
            TransactionResult result = saveDealsRestClient.createDeals(subLister.nextList());
            overallResult.getIds().addAll(result.getIds());
        }
        return overallResult;
    }

    @Override
    public TransactionResult generatePrices(GenerateCurvesRequest request) {

        PriceIndexSnapshotCollection collection = findPriceIndicesRestClient.findPriceIndices(
                request.getQuery(),
                0,
                100);

        List<PriceCurveSnapshot> snapshots = priceCurvesGenerator.generatePrices(request);

        for (PriceIndexSnapshot snapshot : collection.getSnapshots()) {
             savePriceCurvesRestClient.savePriceCurves(
                    snapshot.getEntityId().getId(),
                    snapshots);
        }
        return new TransactionResult();
    }

    @Override
    public TransactionResult generateFxRates(GenerateCurvesRequest request) {


        FxIndexSnapshotCollection collection = findFxIndicesRestClient.findFxIndices(
                request.getQuery(),
                0,
                10);

        List<FxCurveSnapshot> snapshots = fxCurvesGenerator.generateFxRates(request);

        for (FxIndexSnapshot snapshot : collection.getSnapshots()) {
            saveFxCurvesRestClient.saveFxCurves(
                    snapshot.getEntityId().getId(),
                    snapshots);
        }
        return new TransactionResult();
    }


    @Override
    public TransactionResult valueFxRiskFactors(String queryText) {
        return valueFxRiskFactorsRestClient.valueRiskFactors(queryText);
    }

    @Override
    public TransactionResult valuePriceRiskFactors(String queryText) {
        return valuePriceRiskFactorsRestClient.valueRiskFactors(queryText);
    }

    @Override
    public TransactionResult valuePositions(String queryText) {
        return valuePositionsRestClient.valuePositions(queryText);
    }

    @Override
    public TransactionResult generatePositions(GeneratePositionsRequest request) {
        EvaluationContextRequest context = new EvaluationContextRequest();
        context.setCurrencyCodeValue(request.getCurrencyCode());
        context.setObservedDateTime(request.getObservedDateTime());

        return generatePositionsRestClient.generatePositions(
                request.getQuery(),
                context);
    }
}
