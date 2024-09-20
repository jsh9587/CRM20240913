<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">레벨 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">레벨 수정</h6>
        </div>
        <div class="card-body">
            <form id="createForm">
                <input type="hidden" id="level_id" value="${level.id}">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">이름</label>
                        <input type="text" id="name" class="form-control bg-light border-0 small"
                               placeholder="이름을 입력해주세요." value="${level.name}">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="sort">순번</label>
                        <input type="number" id="sort" class="form-control bg-light border-0 small"
                               placeholder="순번을 입력해주세요." value="${level.sort}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="status">사용유무</label>
                        <select id="status" class="form-control bg-light border-0 small">
                            <option value="">상태를 선택하세요</option>
                            <option value="0" <c:if test="${level.status == 0}">selected</c:if>>사용</option>
                            <option value="1" <c:if test="${level.status == 1}">selected</c:if>>미사용</option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                    </div>
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
<%@ include file="../include/foot.jsp" %>
<script>
    const submitButton = document.querySelector('#submitButton');
    const nameBox = document.querySelector('#name');
    const sortBox = document.querySelector('#sort');
    const levelIdBox = document.querySelector('#level_id');
    const statusBox = document.querySelector('#status');
    submitButton.addEventListener('click', function () {
        if (levelIdBox.value === '') {
            alert('id 설정 오류');
            return false;
        }
        if (nameBox.value === '') {
            alert('이름을 입력해주세요.');
            return false;
        }
        if (sortBox.value === '' || sortBox.value === 0) {
            alert('순번을 입력해주세요');
            return false;
        }
        if (statusBox.value === '') {
            alert('사용 유무를 선택해주세요');
            return false;
        }
        const requestData = {
            id: levelIdBox.value,
            name: nameBox.value,
            sort: sortBox.value,
            status: statusBox.value
        }
        fetch('/api/level/levelEdit', {
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
                alert('수정완료');
                document.location.href = '/level';
                console.log(data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
</script>