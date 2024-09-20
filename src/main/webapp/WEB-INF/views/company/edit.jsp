<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">회사 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">회사 수정</h6>
        </div>
        <div class="card-body">
            <form id="createForm">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <input type="hidden" id="companyId" value="${company.id}">
                        <label for="name">상호명(회사명)</label>
                        <input type="text" id="name" class="form-control bg-light border-0 small"
                               placeholder="상호명(회사명) 입력해주세요." value="${company.name}">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="businessLicense">사업자등록번호</label>
                        <input type="text" id="businessLicense" class="form-control bg-light border-0 small"
                               placeholder="사업자등록번호를 입력해주세요." value="${company.businessLicense}" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="owner">대표자</label>
                        <input type="text" id="owner" class="form-control bg-light border-0 small"
                               placeholder="대표자를 입력해주세요." value="${company.owner}">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="address">주소</label>
                        <input type="text" id="address" class="form-control bg-light border-0 small"
                               placeholder="주소를 입력해주세요." value="${company.address}">
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="address">업태</label>
                        <input type="text" id="businessType" class="form-control bg-light border-0 small"
                               placeholder="업태를 입력해주세요." value="${company.businessType}">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="address">종목</label>
                        <input type="text" id="businessItem" class="form-control bg-light border-0 small"
                               placeholder="종목을 입력해주세요." value="${company.businessItem}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="category">분류 카테고리</label>
                        <select id="category" class="form-control bg-light border-0 small">
                            <option value="">선택하세요</option>
                            <option value="제약·바이오" <c:if test="${company.category == '제약·바이오'}">selected</c:if>>제약·바이오
                            </option>
                            <option value="도매" <c:if test="${company.category == '도매'}">selected</c:if>>도매</option>
                            <option value="병의원" <c:if test="${company.category == '병의원'}">selected</c:if>>병의원</option>
                            <option value="약국" <c:if test="${company.category == '약국'}">selected</c:if>>약국</option>
                            <option value="공기업·협회" <c:if test="${company.category == '공기업·협회'}">selected</c:if>>공기업·협회
                            </option>
                            <option value="기타" <c:if test="${company.category == '기타'}">selected</c:if>>기타</option>
                        </select>
                    </div>
                    <div class="col-md-6"></div>
                </div>
                <div class="row">
                    <div class="col-md-12 mb-3">
                        <button class="btn btn-primary" id="submitButton" type="button">
                            수정
                        </button>
                        <button class="btn btn-primary" type="button" onclick="history.back();">
                            취소
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- /.container-fluid -->
<script>
    const submitButton = document.querySelector('#submitButton');
    const name = document.querySelector('#name');
    const businessLicense = document.querySelector('#businessLicense');
    const businessType = document.querySelector('#businessType');
    const businessItem = document.querySelector('#businessItem');
    const address = document.querySelector('#address');
    const category = document.querySelector('#category');
    const owner = document.querySelector('#owner');
    const companyId = document.querySelector('#companyId');
    if (submitButton) {
        submitButton.addEventListener('click', function () {
            if (name.value === '') {
                alert('상호명(회사명)을 입력해주세요');
                return false;
            }
            if (businessLicense.value === '') {
                alert('사업자등록번호를 입력해주세요');
                return false;
            }
            if (owner.value === '') {
                alert('대표자를 입력해주세요');
                return false;
            }
            if (businessType.value === '') {
                alert('업태를 입력해주세요');
                return false;
            }
            if (businessItem.value === '') {
                alert('종목을 입력해주세요');
                return false;
            }
            if (category.value === '') {
                alert('분류 카테고리를 선택해주세요');
                return false;
            }

            let requestData = {
                id: companyId.value,
                name: name.value,
                businessLicense: businessLicense.value,
                businessItem: businessItem.value,
                businessType: businessType.value,
                category: category.value,
                address: address.value,
                owner: owner.value
            }

            fetch('/api/company/companyEdit', {
                method: 'POST',
                body: JSON.stringify(requestData),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    console.log('Response status:', response.status); // 응답 상태 코드 확인
                    if (!response.ok) {
                        // 서버 응답이 성공적이지 않은 경우
                        return response.json().then(data => {
                            // 서버에서 반환된 에러 메시지
                            const errorMessage = data.message || '알 수 없는 오류가 발생했습니다.';
                            alert(errorMessage);
                            throw new Error(errorMessage);
                        });
                    }
                    return response.json();
                })
                .then(data => {
                    console.log(data);
                    // Check if data is an array
                    if (data) {
                        alert('수정완료');
                        document.location.href = "/company";
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });

        });
    }
</script>
<%@ include file="../include/foot.jsp" %>
