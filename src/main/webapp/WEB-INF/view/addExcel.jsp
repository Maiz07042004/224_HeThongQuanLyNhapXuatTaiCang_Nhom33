<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">Thêm mới nhân viên</p>
		</div>
		<form action="${contextPath}/Ticket_Selling/themUserTuExcel" method="POST" enctype="multipart/form-data">
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">Chọn File Excel</label>
        <div class="col-sm-8">
            <input type="file" name="file" class="form-control" accept=".xlsx, .xls">
        </div>
    </div>
    <div class="row" style="height: 20px"></div>
     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
    <button type="submit" float="right" color="#007bff" class="btn btn-success">
        <i class="fa fa-upload" aria-hidden="true"></i>&ensp;Tải lên và Thêm nhân viên
    </button>
</form>
<%@include file="include/footer.jsp"%>