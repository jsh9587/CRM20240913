package company.demo_last_last202409121553.company.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CompanyStoreRequest {
    @NotEmpty(message = "상호명(회사명)을 입력해주세요")
    private String name;
    @NotEmpty(message = "주소를 입력해주세요")
    private String address;
    @NotEmpty(message = "사업자등록번호를 입력해주세요")
    private String businessLicense;
    @NotEmpty(message = "업태를 입력해주세요")
    private String businessType;
    @NotEmpty(message = "종목을 입력해주세요")
    private String businessItem;
    @NotEmpty(message = "분류 카테고리를 선택해주세요")
    private String category;
    @NotEmpty(message = "대표자를 입력해주세요")
    private String owner;
}
