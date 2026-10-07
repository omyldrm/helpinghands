package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Organization;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean existsById(Long id) {
        return organizations.stream()
                .anyMatch(o -> Objects.equals(o.getId(), id));
    }
}
