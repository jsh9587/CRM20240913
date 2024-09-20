package company.demo_last_last202409121553.company.service;

import company.demo_last_last202409121553.company.dto.request.CompanyMemberEditRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyMemberStatusEditRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyMemberStoreRequest;
import company.demo_last_last202409121553.company.entity.CompanyEntity;
import company.demo_last_last202409121553.company.entity.CompanyMemberEntity;
import company.demo_last_last202409121553.company.repository.CompanyMemberRepository;
import company.demo_last_last202409121553.company.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyMemberService {

    private final CompanyRepository companyRepository;
    private final CompanyMemberRepository companyMemberRepository;

    public CompanyMemberService(CompanyRepository companyRepository, CompanyMemberRepository companyMemberRepository) {
        this.companyRepository = companyRepository;
        this.companyMemberRepository = companyMemberRepository;
    }

    public CompanyMemberEntity findById(int id) {
        try {
            Optional<CompanyMemberEntity> companyMemberEntity = companyMemberRepository.findById(id);
            if (companyMemberEntity.isPresent()) {
                return companyMemberEntity.get();
            } else {
                throw new IllegalArgumentException("담당자 정보를 찾을수 없습니다.");
            }
        }  catch (IllegalArgumentException e) {
            throw e; // Rethrow to be caught by the controller
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("예상치 못한 오류가 발생했습니다."); // Rethrow as a runtime exception
        }
    }


    public boolean store(CompanyMemberStoreRequest request) {
        try {
            Optional<CompanyEntity> company = companyRepository.findById(request.getCompany().getId());
            System.out.println("Company ID: " + request.getCompany().getId());
            if (company.isEmpty()) {
                throw new IllegalArgumentException("등록된 회사가 없습니다.");
            }
            CompanyMemberEntity companyMember = new CompanyMemberEntity.Builder()
                    .name(request.getName())
                    .title(request.getTitle())
                    .hphone(request.getHphone())
                    .email(request.getEmail())
                    .tel(request.getTel())
                    .company(company.get())
                    .status(0)
                    .fax(request.getFax())
                    .build();
            companyMemberRepository.save(companyMember);
            return true;
        } catch (IllegalArgumentException e) {
            throw e; // Rethrow to be caught by the controller
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("예상치 못한 오류가 발생했습니다."); // Rethrow as a runtime exception
        }
    }
    @Transactional
    public boolean statusEdit(CompanyMemberStatusEditRequest request) {
        try {
            CompanyMemberEntity existingMember = companyMemberRepository.findById(request.getId())
                    .orElseThrow(() -> new IllegalArgumentException("담당자를 찾을 수 없습니다."));

            // 기존 엔티티의 상태만 직접 업데이트
            existingMember.updateStatus(request.getStatus());

            // 변경된 엔티티 저장
            companyMemberRepository.save(existingMember);

            return true;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("예상치 못한 오류가 발생했습니다.");
        }
    }
    public boolean edit(CompanyMemberEditRequest request) {
        try {
            CompanyMemberEntity existingMember = companyMemberRepository.findById(request.getId())
                    .orElseThrow(() -> new IllegalArgumentException("담당자를 찾을 수 없습니다."));

            // 빌더를 사용하여 기존 값과 요청된 새 값을 조합하여 새 인스턴스 생성
            CompanyMemberEntity updatedEntity = new CompanyMemberEntity.Builder()
                    .id(existingMember.getId()) // 기존 ID 유지 (중요)
                    .company(existingMember.getCompany()) // 기존 회사 유지
                    .email(request.getEmail()) // 요청된 새 이메일
                    .name(request.getName()) // 요청된 새 이름
                    .hphone(request.getHphone()) // 요청된 새 핸드폰
                    .status(existingMember.getStatus()) // 기존 상태 유지
                    .fax(request.getFax()) // 요청된 새 팩스
                    .address(request.getAddress()) // 요청된 새 주소
                    .tel(request.getTel()) // 요청된 새 전화번호
                    .title(request.getTitle()) // 요청된 새 직책
                    .build();

            // 업데이트된 엔티티 저장
            companyMemberRepository.save(updatedEntity);
            return true;
        } catch (IllegalArgumentException e) {
            throw e; // 컨트롤러에서 잡을 수 있도록 다시 던짐
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("예상치 못한 오류가 발생했습니다."); // 런타임 예외로 다시 던짐
        }
    }
}
