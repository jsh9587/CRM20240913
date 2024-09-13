<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">사원 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">사원 생성</h6>
        </div>
        <div class="card-body">
            <form id="createForm">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">이름</label>
                        <input type="text" id="name" class="form-control bg-light border-0 small"
                               placeholder="이름을 입력해주세요.">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="email">이메일</label>
                        <input type="email" id="email" class="form-control bg-light border-0 small"
                               placeholder="이메일을 입력해주세요.">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="level">직급</label>
                        <select id="level" class="form-control bg-light border-0 small">
                            <option value="">직급을 선택하세요</option>
                            <c:forEach var="level" items="${levelList}">
                                <option value="${level.id}">${level.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>조직</label>
                        <div class="row">
                            <div class="col-md-3">
                                <select id="organization1" depth="1"
                                        class="form-control bg-light border-0 small organizations">
                                    <option value="">선택해주세요.</option>
                                    <!-- Options will be populated dynamically -->
                                </select>
                            </div>
                            <div class="col-md-3">
                                <select id="organization2" depth="2"
                                        class="form-control bg-light border-0 small organizations">
                                    <option value="">선택해주세요.</option>
                                    <!-- Options will be populated dynamically -->
                                </select>
                            </div>
                            <div class="col-md-3">
                                <select id="organization3" depth="3"
                                        class="form-control bg-light border-0 small organizations">
                                    <option value="">선택해주세요.</option>
                                    <!-- Options will be populated dynamically -->
                                </select>
                            </div>
                            <div class="col-md-3">
                                <select id="organization4" depth="4"
                                        class="form-control bg-light border-0 small organizations">
                                    <option value="">선택해주세요.</option>
                                    <!-- Options will be populated dynamically -->
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="password">비밀번호</label>
                        <input type="password" id="password" class="form-control bg-light border-0 small" placeholder="비밀번호를 입력해주세요.">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="status">상태</label>
                        <select id="status" class="form-control bg-light border-0 small">
                            <option value="">상태를 선택하세요</option>
                            <c:forEach var="status" items="${statusList}">
                                <option value="${status.id}">${status.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-12 mb-3">
                        <button class="btn btn-primary" id="submitButton" type="button" >
                            생성
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

<%@ include file="../include/foot.jsp" %>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const depth1 = document.querySelector('#organization1');
        const depth2 = document.querySelector('#organization2');
        const depth3 = document.querySelector('#organization3');
        const depth4 = document.querySelector('#organization4');
        const defaultOption = `<option value="">선택해주세요</option>`;

        const emailBox = document.querySelector('#email');
        const nameBox = document.querySelector('#name');
        const levelBox = document.querySelector('#level');
        const statusBox = document.querySelector('#status');
        const passwordBox = document.querySelector('#password');


        const submitButton = document.querySelector('#submitButton');

        function SearchOrganization(parent_id,depth) {
            const nowDepth = document.querySelector('#organization' + depth);
            const nextDepth = document.querySelector('#organization' + (depth + 1));
            if( depth === 1 ){
                   depth2.innerHTML = defaultOption;
                   depth3.innerHTML = defaultOption;
                   depth4.innerHTML = defaultOption;
            }else if( depth === 2 ){
                depth3.innerHTML = defaultOption;
                depth4.innerHTML = defaultOption;
            }else if( depth === 3 ){
                depth4.innerHTML = defaultOption;
            }
            fetch('/api/getOrganizations', {
                method: 'POST',
                body: JSON.stringify({
                    'parent_id':parent_id,
                    'depth': depth
                }),
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
                    // Check if data is an array
                    if (Array.isArray(data)) {
                        nowDepth.innerHTML=defaultOption;
                        data.forEach(org => {
                            const option = document.createElement('option');
                            option.value = org.id;
                            option.text = org.name;
                            nowDepth.appendChild(option);
                        });

                        // Enable the next depth select if there are children
                        if( nextDepth ){
                            if (data.length > 0) {
                                nextDepth.disabled = false;
                            } else {
                                nextDepth.disabled = true;
                            }
                        }
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }

        document.querySelectorAll('.organizations').forEach(select => {
            select.addEventListener('change', function () {
                const depth = parseInt(this.id.replace('organization', ''));
                if (this.value){
                    SearchOrganization(parseInt(select.value),depth + 1);
                }
            });
        });

        emailBox.addEventListener('blur',function(){
            fetch('/api/emailCheck', {
                method: 'POST',
                body: JSON.stringify({
                    'email':this.value,
                }),
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
                    if( data === 1 ){
                        alert('이미 등록된 이메일입니다.');
                        emailBox.value = '';
                        if( document.querySelector('#emailConfirm') ){
                            document.querySelector('#emailConfirm').remove();
                        }
                        return false;
                    }else if( data === 9 ){
                        alert('Email 형식에 맞춰 입력해주세요');
                        if( document.querySelector('#emailConfirm') ){
                            document.querySelector('#emailConfirm').remove();
                        }
                        return false;
                    }else if( data === 0 ){
                        const emailConfirm = document.createElement('input');
                        emailConfirm.type = 'hidden';
                        emailConfirm.id = 'emailConfirm';
                        emailConfirm.value = 'Y';
                        document.querySelector('#createForm').appendChild(emailConfirm);
                    }
                    console.log(data);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });

        submitButton.addEventListener('click',function (){
           const emailConfirm = document.querySelector('#emailConfirm');
           if( !emailConfirm ){
               alert('이메일 형식에 맞게 입력해주세요');
               return false;
           }
           if( nameBox.value === ''){
               alert('이름을 입력해주세요');
               return false;
           }
           if( levelBox.value === ''){
               alert('직급을 선택해주세요');
               return false;
           }
           if(
               depth1.value === '' &&
               depth2.value === '' &&
               depth3.value === '' &&
               depth4.value === ''
           ){
               alert('조직을 선택해주세요');
               return false;
           }
           if( statusBox.value === ''){
               alert('상태를 선택해주세요');
               return false;
           }
           if( password.value === ''){
               alert('비밀번호를 입력해주세요');
               return false;
           }
           const lastSelectedOrganizationValue = lastSelectedOrganization();
           const requestData = {
               name: nameBox.value,
               email: emailBox.value,
               level_id: levelBox.value,
               organization_id: lastSelectedOrganizationValue,
               status_id: statusBox.value,
               password: passwordBox.value
           };
           fetch('/api/userStore',{
               method: 'POST',
               body: JSON.stringify(requestData),
               headers: {
                   'Content-Type': 'application/json'
               }
           })
               .then(response => {
                   if (!response.ok) {
                       // 서버 응답이 성공적이지 않은 경우
                       return response.json().then(data => {
                           // 서버에서 반환된 에러 메시지
                           const errorMessage = data.message || '알 수 없는 오류가 발생했습니다.';
                           alert(errorMessage);
                           throw new Error(errorMessage);
                       });
                   }

                   // 응답이 성공적일 경우
                   return response.json();
               })
               .then(data => {
                   alert('저장완료');
                   document.location.href='/user';
                   console.log(data);
               })
               .catch(error => {
                   console.error('Error:', error);
               });
        });

        function lastSelectedOrganization(){
            let depths =[
              depth1.value,
              depth2.value,
              depth3.value,
              depth4.value
            ];

            for(let i = depths.length-1; i >= 0; i -- ){
                if( depths[i] ){
                    return depths[i];
                }
            }
            return null;
        }


        SearchOrganization(0,1);
    });

</script>