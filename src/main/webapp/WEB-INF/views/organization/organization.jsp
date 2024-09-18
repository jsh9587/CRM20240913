<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>
<style>
    .tree {
        min-height: 20px;
        padding: 19px;
        margin-bottom: 20px;
        background-color: #fbfbfb;
        border: 1px solid #999;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
        -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05)
    }

    .tree li {
        list-style-type: none;
        margin: 0;
        padding: 10px 5px 0 5px;
        position: relative
    }

    .tree li::before, .tree li::after {
        content: '';
        left: -20px;
        position: absolute;
        right: auto
    }

    .tree li::before {
        border-left: 1px solid #999;
        bottom: 50px;
        height: 100%;
        top: 0;
        width: 1px
    }

    .tree li::after {
        border-top: 1px solid #999;
        height: 20px;
        top: 25px;
        width: 25px
    }

    .tree li span:not(.glyphicon) {
        -moz-border-radius: 5px;
        -webkit-border-radius: 5px;
        border-radius: 5px;
        display: inline-block;
        padding: 4px 9px;
        text-decoration: none
    }

    .tree li.parent_li > span:not(.glyphicon) {
        cursor: pointer
    }

    .tree > ul > li::before, .tree > ul > li::after {
        border: 0
    }

    .tree li:last-child::before {
        height: 30px
    }

    .tree li.parent_li > span:not(.glyphicon):hover, .tree li.parent_li > span:not(.glyphicon):hover + ul li span:not(.glyphicon) {
        background: #eee;
        border: 1px solid #999;
        padding: 3px 8px;
        color: #000
    }
</style>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">조직 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">
                <div class="d-flex justify-content-between align-items-center">
                    <h6 class="m-0 font-weight-bold text-primary">
                        조직 리스트
                    </h6>
                </div>
            </h6>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <div class="tree">
                        <ul>
                            <c:forEach var="depth1" items="${organizationList}">
                                <li class="parent_li">
                                    <span title="${depth1.name}"
                                          organization_id="${depth1.id}"
                                          organization_depth="${depth1.depth}"
                                          organization_sort="${depth1.sort}"
                                          organization_name="${depth1.name}"
                                          organization_status="${depth1.status}"
                                    >${depth1.name}&nbsp;(${depth1.users.size()})</span>
                                    <c:if test="${not empty depth1.children}">
                                        <ul>
                                            <c:forEach var="depth2" items="${depth1.children}">
                                                <li class="parent_li">
                                                    <span title=">${depth2.name}"
                                                          organization_id="${depth2.id}"
                                                          organization_depth="${depth2.depth}"
                                                          organization_sort="${depth2.sort}"
                                                          organization_name="${depth2.name}"
                                                          organization_status="${depth2.status}"
                                                    >${depth2.name}&nbsp;(${depth2.users.size()})</span>
                                                    <c:if test="${not empty depth2.children}">
                                                        <ul>
                                                            <c:forEach var="depth3" items="${depth2.children}">
                                                                <li class="parent_li">
                                                                    <span title="${depth3.name}"
                                                                          organization_id="${depth3.id}"
                                                                          organization_depth="${depth3.depth}"
                                                                          organization_sort="${depth3.sort}"
                                                                          organization_name="${depth3.name}"
                                                                          organization_status="${depth3.status}"
                                                                    >${depth3.name}&nbsp;(${depth3.users.size()})</span>
                                                                    <c:if test="${not empty depth3.children}">
                                                                        <ul>
                                                                            <c:forEach var="depth4"
                                                                                       items="${depth3.children}">
                                                                                <li class="parent_li">
                                                                                    <span title="${depth4.name}"
                                                                                          organization_id="${depth4.id}"
                                                                                          organization_depth="${depth4.depth}"
                                                                                          organization_sort="${depth4.sort}"
                                                                                          organization_name="${depth4.name}"
                                                                                          organization_status="${depth4.status}"
                                                                                    >${depth4.name}&nbsp;(${depth4.users.size()})</span>
                                                                                </li>
                                                                            </c:forEach>
                                                                        </ul>
                                                                    </c:if>
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </c:if>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6">
                    <div class="row">
                        <div class="col-md-12 mb-3">
                            <label for="name">상위조직</label>
                            <input type="hidden" id="organization_id">
                            <input type="hidden" id="parent_id">
                            <input type="text" id="parentName" class="form-control bg-light border-0 small" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="name">조직명</label>
                            <input type="text" id="name" class="form-control bg-light border-0 small"
                                   placeholder="조직명을 입력해주세요.">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="depth">뎁스</label>
                            <input type="number" id="depth" class="form-control bg-light border-0 small" readonly>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="sort">순서</label>
                            <input type="number" id="sort" class="form-control bg-light border-0 small">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="status">사용 유무</label>
                            <select id="status" class="form-control bg-light border-0 small">
                                <option value="">상태를 선택하세요</option>
                                <option value="0">사용</option>
                                <option value="1">미사용</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 mb-3">
                            <button class="btn btn-primary" id="submitButton" type="button" style="display:none;">
                                생성
                            </button>
                            <button class="btn btn-primary" id="editButton" type="button" style="display:none;">
                                수정
                            </button>
                            <button class="btn btn-primary" id="childrenButton" type="button" style="display:none;">
                                하위생성
                            </button>
                            <button class="btn btn-primary" type="button" style="display:none;">
                                취소
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->
<%@include file="../include/foot.jsp" %>
<script>
    const organizationIdBox = document.querySelector('#organization_id');
    const parentIdBox = document.querySelector('#parent_id');
    const nameBox = document.querySelector('#name');
    const depthBox = document.querySelector('#depth');
    const sortBox = document.querySelector('#sort');
    const statusBox = document.querySelector('#status');
    const parentBox = document.querySelector('#parentName');

    const submitButton = document.querySelector('#submitButton');
    const editButton = document.querySelector('#editButton');
    const childrenButton = document.querySelector('#childrenButton');


    const organizationEl = document.querySelectorAll('.parent_li span');
    organizationEl.forEach(function (item) {
        item.addEventListener('click', function () {
            const organizationId = item.getAttribute('organization_id');
            fetch("/api/organization/getOrganization", {
                method: 'POST',
                body: JSON.stringify({
                    'id': organizationId
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
                    console.log(data);
                    organizationIdBox.value = data.id;
                    nameBox.value = data.name;
                    depthBox.value = data.depth;
                    sortBox.value = data.sort;
                    statusBox.value = data.status;
                    parentIdBox.value = data.parent_id;
                    parentBox.value = data.parent.name;
                    if (organizationIdBox.value) {
                        editButton.style.display = 'inline-block';
                        if (data.depth < 4) {
                            childrenButton.style.display = 'inline-block';
                        }
                        submitButton.style.display = 'none';
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });

    });
    if (childrenButton) {
        childrenButton.addEventListener('click', function () {
            parentIdBox.value = organizationIdBox.value;
            parentBox.value = nameBox.value;
            nameBox.value = '';
            depthBox.value = parseInt(depthBox.value) + 1;
            sortBox.value = '';
            statusBox.value = '';
            organizationIdBox.value = '';
            editButton.style.display = 'none';
            childrenButton.style.display = 'none';
            submitButton.style.display = 'inline-block';
        });
    }
    if (submitButton) {
        submitButton.addEventListener('click', function () {
            if (parentIdBox.value === '') {
                alert('상위 조직 데이터 오류');
                return false;
            }
            if (nameBox.value === '') {
                alert('조직명을 입력해주세요.');
                return false;
            }
            if (sortBox.value === '') {
                alert('순서를 입력해주세요.');
                return false;
            }
            if (statusBox.value === '') {
                alert('사용유무를 선택해주세요');
                return false;
            }
            const requestData = {
                name: nameBox.value,
                depth: depthBox.value,
                sort: sortBox.value,
                status: statusBox.value,
                parent_id: parentIdBox.value
            };

            console.log(requestData);
            fetch("/api/organization/organizationStore", {
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
                    alert('생성 완료');
                    document.location.href = "/organization";
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });
    }
    if (editButton) {
        editButton.addEventListener('click', function () {
            if (parentIdBox.value === '') {
                alert('상위 조직 데이터 오류');
                return false;
            }
            if (nameBox.value === '') {
                alert('조직명을 입력해주세요.');
                return false;
            }
            if (sortBox.value === '') {
                alert('순서를 입력해주세요.');
                return false;
            }
            if (statusBox.value === '') {
                alert('사용유무를 선택해주세요');
                return false;
            }
            const requestData = {
                id:organizationIdBox.value,
                name: nameBox.value,
                depth: depthBox.value,
                sort: sortBox.value,
                status: statusBox.value,
                parent_id: parentIdBox.value
            };
            fetch("/api/organization/organizationEdit", {
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
                    alert('수정 완료');
                    document.location.href = "/organization";
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });
    }

</script>