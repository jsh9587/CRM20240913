<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="../include/head.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">회사 관리</h1>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">
                <div class="d-flex justify-content-between align-items-center">
                    <h6 class="m-0 font-weight-bold text-primary">
                        회사 리스트
                    </h6>
                    <button class="btn btn-primary" type="button" onclick="document.location.href='/company/create';">
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
                        <th class="text-center align-middle">NO</th>
                        <th class="text-center align-middle">상호명(회사명)</th>
                        <th class="text-center align-middle">대표자</th>
                        <th class="text-center align-middle">사업자등록번호</th>
                        <th class="text-center align-middle">주소</th>
                        <th class="text-center align-middle">업태</th>
                        <th class="text-center align-middle">종목</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th class="text-center align-middle">NO</th>
                        <th class="text-center align-middle">상호명(회사명)</th>
                        <th class="text-center align-middle">대표자</th>
                        <th class="text-center align-middle">사업자등록번호</th>
                        <th class="text-center align-middle">주소</th>
                        <th class="text-center align-middle">업태</th>
                        <th class="text-center align-middle">종목</th>
                        <th></th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="company" items="${companys}">
                        <tr>
                            <td class="text-center align-middle">${company.id}</td>
                            <td class="text-center align-middle">${company.name}</td>
                            <td class="text-center align-middle">${company.owner}</td>
                            <td class="text-center align-middle">${company.businessLicense}</td>
                            <td class="text-center align-middle">${company.address}</td>
                            <td class="text-center align-middle">${company.businessType}</td>
                            <td class="text-center align-middle">${company.businessItem}</td>
                            <td class="text-center align-middle">
                                <button class="btn btn-primary editButton" companyid="${company.id}" type="button">
                                    수정
                                </button>
                                <button class="btn btn-primary memberButton" companyid="${company.id}" type="button">
                                    담당자
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
    const memberButton = document.querySelectorAll('.memberButton');
    editButton.forEach(function (item){
        item.addEventListener('click',function (){
            const id = item.getAttribute('companyid');
            if( id ){
                document.location.href="/company/edit?id="+id;
            }
        })
    })
    memberButton.forEach(function (item){
        item.addEventListener('click',function (){
            const id = item.getAttribute('companyid');
            if( id ){
                document.location.href="/company/member?id="+id;
            }
        })
    })
</script>