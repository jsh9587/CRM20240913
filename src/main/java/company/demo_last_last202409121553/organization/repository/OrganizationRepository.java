package company.demo_last_last202409121553.organization.repository;

import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity,Integer> {
    public List<OrganizationEntity> findByParentIdAndDepth(Integer parentId, Integer depth);
    public Optional<OrganizationEntity> findById(int id);
}
