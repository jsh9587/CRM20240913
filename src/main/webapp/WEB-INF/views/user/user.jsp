<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">사원 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">
                <div class="d-flex justify-content-between align-items-center">
                    <h6 class="m-0 font-weight-bold text-primary">
                        사원 리스트
                    </h6>
                    <button class="btn btn-primary" type="button" onclick="document.location.href='/user/create';">
                        생성
                    </button>
                </div>
            </h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-striped" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th class="text-center align-middle">이름</th>
                        <th class="text-center align-middle">이메일</th>
                        <th class="text-center align-middle">직급</th>
                        <th class="text-center align-middle">조직</th>
                        <th class="text-center align-middle">상태</th>
                        <th class="text-center align-middle"></th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th class="text-center align-middle">이름</th>
                        <th class="text-center align-middle">이메일</th>
                        <th class="text-center align-middle">직급</th>
                        <th class="text-center align-middle">조직</th>
                        <th class="text-center align-middle">상태</th>
                        <th class="text-center align-middle"></th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td class="text-center align-middle">${user.name}</td>
                            <td class="text-center align-middle">${user.email}</td>
                            <td class="text-center align-middle">${user.level.name}</td>
                            <td class="text-center align-middle">${user.organization.name}</td>
                            <td class="text-center align-middle">${user.status.name}</td>
                            <td class="text-center align-middle">
                                <button class="btn btn-primary editButton" userid="${user.id}" type="button">
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
<!-- /.container-fluid -->
<%@include file="../include/foot.jsp" %>
<script>
    const editButton = document.querySelectorAll('.editButton');
    editButton.forEach(function (item){
        item.addEventListener('click',function (){
            const id = item.getAttribute('userid');
            if( id ){
                document.location.href="/user/edit?id="+id;
            }
        })
    })
</script>