package company.demo_last_last202409121553.company.dto.request;

import company.demo_last_last202409121553.company.entity.CompanyEntity;
import company.demo_last_last202409121553.user.entity.UserEntity;
import jakarta.persistence.Column;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CompanyMemberStoreRequest {
    @NotEmpty(message = "이름을 입력해주세요")
    private String name;
    private String title;
    @NotEmpty(message = "휴대폰번호를 입력해주세요")
    private String hphone;
    @NotEmpty(message = "이메일을 입력해주세요")
    private String email;
    private String address;
    private String tel;
    private String fax;
    @NotNull(message = "담당자가 속한 회사 값은 필수입니다.")  // 추가 유효성 검사
    private CompanyEntity company;
}
