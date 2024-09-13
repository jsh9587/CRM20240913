package company.demo_last_last202409121553.organization.service;

import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import company.demo_last_last202409121553.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<OrganizationEntity> findAll(){
        return organizationRepository.findAll();
    }

    public List<OrganizationEntity> findByParentIdAndDepth(int parent_id, int depth){
        return organizationRepository.findByParentIdAndDepth(parent_id, depth);
    }


}
