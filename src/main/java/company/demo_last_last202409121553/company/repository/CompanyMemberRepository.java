package company.demo_last_last202409121553.company.repository;

import company.demo_last_last202409121553.company.entity.CompanyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyMemberRepository extends JpaRepository<CompanyMemberEntity,Integer> {
}
