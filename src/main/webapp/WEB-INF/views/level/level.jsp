<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">레벨 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">
                <div class="d-flex justify-content-between align-items-center">
                    <h6 class="m-0 font-weight-bold text-primary">
                        레벨 리스트
                    </h6>
                    <button class="btn btn-primary" type="button" onclick="document.location.href='/level/create';">
                        생성
                    </button>
                </div>
            </h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th class="text-center align-middle">순번</th>
                        <th class="text-center align-middle">이름</th>
                        <th class="text-center align-middle">사용유무</th>
                        <th class="text-center align-middle">유저수</th>
                        <th class="text-center align-middle"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="level" items="${levels}">
                        <tr>
                            <td class="text-center align-middle">${level.sort}</td>
                            <td class="text-center align-middle">${level.name}</td>
                            <td class="text-center align-middle">
                                <c:if test="${level.status==0}">사용중</c:if>
                                <c:if test="${level.status==1}">미사용</c:if>
                            </td>
                            <td class="text-center align-middle">${level.users.size()}</td>
                            <td class="text-center align-middle">
                                <button class="btn btn-primary editButton" levelid="${level.id}" type="button">
                                    수정
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th class="text-center align-middle">순번</th>
                        <th class="text-center align-middle">이름</th>
                        <th class="text-center align-middle">사용유무</th>
                        <th class="text-center align-middle">유저수</th>
                        <th class="text-center align-middle"></th>
                    </tr>
                    </tfoot>
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
           const level_id = item.getAttribute('levelid');
           document.location.href="/level/edit?id="+level_id;
       })
    });
</script>