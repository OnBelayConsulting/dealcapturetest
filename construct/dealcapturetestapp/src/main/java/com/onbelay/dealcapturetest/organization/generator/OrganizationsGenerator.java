package com.onbelay.dealcapturetest.organization.generator;

import com.onbelay.dealcapturetest.organization.snapshot.OrganizationSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateOrganizationsRequest;

import java.util.List;

public interface OrganizationsGenerator {

    public List<OrganizationSnapshot> generateOrganizations(GenerateOrganizationsRequest request);

}
