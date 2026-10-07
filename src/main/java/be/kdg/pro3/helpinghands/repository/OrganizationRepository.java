package be.kdg.pro3.helpinghands.repository;

import be.kdg.pro3.helpinghands.domain.Organization;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
import java.util.List;

public interface OrganizationRepository{
    public void addOrganization(Organization organization);
    public List<Organization> getAllOrganizations();
    boolean existsById(Long id);
}
