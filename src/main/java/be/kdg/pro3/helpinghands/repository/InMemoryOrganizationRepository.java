package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Organization;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOrganizationRepository implements OrganizationRepository {
    private static final List<Organization> organizations = new ArrayList<>();

    @Override
    public void addOrganization(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizations.stream().toList();
    }
}
