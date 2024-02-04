package com.onbelay.dealcapturetest.dealmodule.organizations.generatorimpl;

import com.onbelay.dealcapturetest.dealmodule.organizations.generator.OrganizationRolesGenerator;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.CompanyRoleSnapshot;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.CounterpartyRoleSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCompaniesRequest;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCounterpartiesRequest;
import org.springframework.stereotype.Component;

@Component
public class OrganizationRolesGeneratorBean implements OrganizationRolesGenerator {
    @Override
    public CompanyRoleSnapshot generateCompanyRole(GenerateCompaniesRequest request) {
        CompanyRoleSnapshot snapshot = new CompanyRoleSnapshot();
        snapshot.getDetail().setIsHoldingParent(false);
        return snapshot;
    }

    @Override
    public CounterpartyRoleSnapshot generateCounterpartyRole(GenerateCounterpartiesRequest request) {
        CounterpartyRoleSnapshot snapshot = new CounterpartyRoleSnapshot();
        snapshot.getDetail().setSettlementCurrencyCodeValue(request.getSettlementCurrency());

        return snapshot;
    }
}
