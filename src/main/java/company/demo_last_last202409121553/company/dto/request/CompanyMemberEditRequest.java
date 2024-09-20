package company.demo_last_last202409121553.company.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyMemberEditRequest {
    @NotNull(message = "담당자 아이디 값이 누락 되었습니다")
    private int id;
    @NotEmpty(message = "담당자 이름을 입력해주세요")
    private String name;
    private String title;
    @NotEmpty(message = "담당자 휴대폰번호를 입력해주세요")
    private String hphone;
    @NotEmpty(message = "담당자 이메일을 입력해주세요")
    private String email;
    private String fax;
    private String tel;
    private String address;
}
