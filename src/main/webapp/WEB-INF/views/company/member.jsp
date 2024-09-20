<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">회사 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">회사</h6>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <input type="hidden" id="companyId" value="${company.id}">
                    <label for="name">상호명(회사명)</label>
                    <input type="text" id="name" class="form-control bg-light border-0 small"
                           placeholder="상호명(회사명) 입력해주세요." value="${company.name}" readonly>
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
                           placeholder="대표자를 입력해주세요." value="${company.owner}" readonly>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="address">주소</label>
                    <input type="text" id="address" class="form-control bg-light border-0 small"
                           placeholder="주소를 입력해주세요." value="${company.address}" readonly>
                </div>

            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="address">업태</label>
                    <input type="text" id="businessType" class="form-control bg-light border-0 small"
                           placeholder="업태를 입력해주세요." value="${company.businessType}" readonly>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="address">종목</label>
                    <input type="text" id="businessItem" class="form-control bg-light border-0 small"
                           placeholder="종목을 입력해주세요." value="${company.businessItem}" readonly>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="category">분류 카테고리</label>
                    <input type="text" id="category" class="form-control bg-light border-0 small"
                           placeholder="종목을 입력해주세요." value="${company.category}" readonly>
                </div>
                <div class="col-md-6"></div>
            </div>
        </div>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <div class="d-flex justify-content-between align-items-center">
                <h6 class="m-0 font-weight-bold text-primary">
                    담당자 리스트
                </h6>
                <button class="btn btn-primary" type="button" data-toggle="modal" data-target=".addMemberModal">
                    생성
                </button>
            </div>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-striped" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th class="text-center align-middle">이름</th>
                        <th class="text-center align-middle">직책</th>
                        <th class="text-center align-middle">휴대폰번호</th>
                        <th class="text-center align-middle">이메일</th>
                        <th class="text-center align-middle">유선전화</th>
                        <th class="text-center align-middle">팩스</th>
                        <th class="text-center align-middle">맵핑사원</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th class="text-center align-middle">이름</th>
                        <th class="text-center align-middle">직책</th>
                        <th class="text-center align-middle">휴대폰번호</th>
                        <th class="text-center align-middle">이메일</th>
                        <th class="text-center align-middle">유선전화</th>
                        <th class="text-center align-middle">팩스</th>
                        <th class="text-center align-middle">맵핑사원</th>
                        <th></th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="member" items="${company.members}">
                        <tr>
                            <td class="text-center align-middle">${member.name}</td>
                            <td class="text-center align-middle">${member.title}</td>
                            <td class="text-center align-middle">${member.hphone}</td>
                            <td class="text-center align-middle">${member.email}</td>
                            <td class="text-center align-middle">${member.tel}</td>
                            <td class="text-center align-middle">${member.fax}</td>
                            <td class="text-center align-middle"></td>
                            <td class="text-center align-middle">
                                <c:if test="${member.status == 0}">
                                    <button class="btn btn-primary deleteButton" memberid="${member.id}" type="button">
                                        미사용
                                    </button>
                                </c:if>
                                <c:if test="${member.status == 1}">
                                    <button class="btn btn-primary recoveryButton" memberid="${member.id}"
                                            type="button">
                                        사용
                                    </button>
                                </c:if>
                                <button class="btn btn-primary editButton" memberid="${member.id}" type="button">
                                    수정
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="modal fade addMemberModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">담당자 생성</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="memberName" class="col-form-label">이름</label>
                        <input type="text" class="form-control" id="memberName">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="memberTitle" class="col-form-label">직책</label>
                        <input type="text" class="form-control" id="memberTitle">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="memberHphone" class="col-form-label">휴대폰번호</label>
                        <input type="text" class="form-control" id="memberHphone">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="memberEmail" class="col-form-label">이메일</label>
                        <input type="email" class="form-control" id="memberEmail">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="memberTel" class="col-form-label">유선전화</label>
                        <input type="text" class="form-control" id="memberTel">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="memberFax" class="col-form-label">팩스</label>
                        <input type="text" class="form-control" id="memberFax">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 mb-3">
                        <label for="memberAddress" class="col-form-label">주소</label>
                        <input type="text" class="form-control" id="memberAddress">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" id="addMemberSubmitButton">생성</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="../include/foot.jsp" %>
<script>
    const companyId = document.querySelector('#companyId');
    const deleteButton = document.querySelectorAll('.deleteButton');
    const editButton = document.querySelectorAll('.editButton');
    const recoveryButton = document.querySelectorAll('.recoveryButton');
    const addMemberSubmitButton = document.querySelector('#addMemberSubmitButton');
    addMemberSubmitButton.addEventListener('click', function () {
        const name = document.querySelector('#memberName');
        const title = document.querySelector('#memberTitle');
        const hphone = document.querySelector('#memberHphone');
        const email = document.querySelector('#memberEmail');
        const tel = document.querySelector('#memberTel');
        const fax = document.querySelector('#memberFax');
        const address = document.querySelector('#memberAddress');

        if (name.value === '') {
            alert('담당자 이름을 입력해주세요');
            return false;
        }
        if (hphone.value === '') {
            alert('휴대폰 번호를 입력해주세요');
            return false;
        }
        if (hphone.value === '') {
            alert('이메일을 입력해주세요');
            return false;
        }

        let requestData = {
            name: name.value,
            title: title.value,
            hphone: hphone.value,
            email: email.value,
            tel: tel.value,
            fax: fax.value,
            address: address.value,
            company: {
                id: companyId.value
            }
        }

        fetch('/api/companyMember/memberStore', {
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
                    alert('저장완료');
                    document.location.href = "/company/member?id=" + companyId.value;
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    deleteButton.forEach(function (item) {
        item.addEventListener('click', function () {
            const memberId = this.getAttribute('memberid');
            if (confirm('해당 담당자를 미사용 처리하시겠습니까?')) {
                const requestData = {
                    id: memberId,
                    status: 1
                }
                fetch('/api/companyMember/memberStatusEdit', {
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
                            alert('저장완료');
                            document.location.href = "/company/member?id=" + companyId.value;
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            }
        });
    });
    recoveryButton.forEach(function (item) {
        item.addEventListener('click', function () {
            const memberId = this.getAttribute('memberid');
            if (confirm('해당 담당자를 사용 처리하시겠습니까?')) {
                const requestData = {
                    id: memberId,
                    status: 0
                }
                fetch('/api/companyMember/memberStatusEdit', {
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
                            alert('저장완료');
                            document.location.href = "/company/member?id=" + companyId.value;
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            }
        });
    });
</script>