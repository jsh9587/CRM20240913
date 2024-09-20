package company.demo_last_last202409121553.company.repository;

import company.demo_last_last202409121553.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Integer> {
    public Optional<CompanyEntity> findByBusinessLicense(String businessLicense);
}
