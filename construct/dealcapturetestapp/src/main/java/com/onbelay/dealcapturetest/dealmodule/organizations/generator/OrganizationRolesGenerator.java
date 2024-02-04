package com.onbelay.dealcapturetest.dealmodule.organizations.generator;

import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.CompanyRoleSnapshot;
import com.onbelay.dealcapturetest.dealmodule.organizations.snapshot.CounterpartyRoleSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCompaniesRequest;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateCounterpartiesRequest;

public interface OrganizationRolesGenerator {

    CompanyRoleSnapshot generateCompanyRole(GenerateCompaniesRequest request);

    CounterpartyRoleSnapshot generateCounterpartyRole(GenerateCounterpartiesRequest request);

}
