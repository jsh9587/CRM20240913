package company.demo_last_last202409121553.company.service;

import company.demo_last_last202409121553.company.dto.request.CompanyEditRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyMemberEditRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyStoreRequest;
import company.demo_last_last202409121553.company.entity.CompanyEntity;
import company.demo_last_last202409121553.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyEntity> findAll(){
        return companyRepository.findAll();
    }
    public Optional<CompanyEntity> findById(int id){
        return companyRepository.findById(id);
    }
    public boolean store(CompanyStoreRequest request){
        try{
            Optional<CompanyEntity> companyEntity = companyRepository.findByBusinessLicense(request.getBusinessLicense());
            if(companyEntity.isPresent()){
                throw new IllegalArgumentException("이미 등록된 사업자등록번호 입니다");
            }
            CompanyEntity company = new CompanyEntity.Builder()
                    .name(request.getName())
                    .businessLicense(request.getBusinessLicense())
                    .owner(request.getOwner())
                    .address(request.getAddress())
                    .businessType(request.getBusinessType())
                    .businessItem(request.getBusinessItem())
                    .category(request.getCategory())
                    .build();

            companyRepository.save(company);
            return true;
        }  catch (IllegalArgumentException e) {
            throw e; // Rethrow to be caught by the controller
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("예상치 못한 오류가 발생했습니다."); // Rethrow as a runtime exception
        }
    }
    public boolean edit(CompanyEditRequest request) {
        try {
            CompanyEntity existingCompany = companyRepository.findById(request.getId())
                    .orElseThrow(() -> new IllegalArgumentException("등록된 회사가 없습니다."));

            // 기존 엔티티의 ID를 유지하면서 다른 모든 필드를 업데이트
            CompanyEntity updatedCompany = new CompanyEntity.Builder()
                    .id(existingCompany.getId()) // 기존 ID 유지 (중요)
                    .name(request.getName())
                    .owner(request.getOwner())
                    .address(request.getAddress())
                    .businessType(request.getBusinessType())
                    .businessItem(request.getBusinessItem())
                    .category(request.getCategory())
                    .build();

            companyRepository.save(updatedCompany);
            return true;
        } catch (IllegalArgumentException e) {
            throw e; // 컨트롤러에서 잡을 수 있도록 다시 던짐
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("예상치 못한 오류가 발생했습니다."); // 런타임 예외로 다시 던짐
        }
    }



}
