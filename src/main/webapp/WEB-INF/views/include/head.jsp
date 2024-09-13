<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Admin</title>
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <link href="/css/sb-admin-2.min.css" rel="stylesheet">
    <style>
        .dataTables_length,
        .dataTables_filter {
            width: 30%;
        }
        .dataTables_length label,
        .dataTables_filter label {
            display: flex;
            align-items: center; /* Centers items vertically within the label */
        }
        .dataTables_length select[name="dataTable_length"] {
            margin-left: 3%;
            margin-right: 3%;
        }
        .dataTables_filter input[type="search"]{
            margin-left: 3%;
            margin-right: 3%;
        }
    </style>
</head>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <%@include file="left.jsp"%>
    <!-- End of Sidebar -->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <%@include file="top.jsp"%>
            <!-- End of Topbar -->