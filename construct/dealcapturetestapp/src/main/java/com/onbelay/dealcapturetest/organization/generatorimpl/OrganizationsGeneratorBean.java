package com.onbelay.dealcapturetest.organization.generatorimpl;

import com.onbelay.dealcapturetest.organization.generator.OrganizationsGenerator;
import com.onbelay.dealcapturetest.organization.snapshot.OrganizationSnapshot;
import com.onbelay.dealcapturetest.testharness.snapshot.GenerateOrganizationsRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationsGeneratorBean implements OrganizationsGenerator {

    @Override
    public List<OrganizationSnapshot> generateOrganizations(GenerateOrganizationsRequest request) {
        ArrayList<OrganizationSnapshot> snapshots = new ArrayList<>();

        for (int i = 0; i < request.getTotal(); i++) {
            OrganizationSnapshot snapshot = new OrganizationSnapshot();
            String name = request.getOrganizationNamePrefix() + "_" + i;
            snapshot.getDetail().setShortName(name);
            snapshot.getDetail().setLegalName(name + " LLC");
            snapshots.add(snapshot);
        }

        return snapshots;
    }
}
