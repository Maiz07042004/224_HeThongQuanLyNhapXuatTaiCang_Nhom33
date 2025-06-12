<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">CẬP NHẬT DANH MỤC</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div style="margin-top: 10px;">
			<form:form
				action="${contextPath}/Ticket_Selling/thucHienUpdateDanhMuc"
				method="GET" modelAttribute="category">
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Mã Danh Mục:</label>
					<div class="col-sm-8">
						<form:input path="categoryID" name="categoryID" id="categoryID"
							type="text" class="form-control" readonly="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập Danh Mục:</label>
					<div class="col-sm-8">
						<form:input path="categoryName" name="categoryName"
							id="categoryName" type="text" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Chọn hình ảnh minh
						họa<span style="color: red;">(*)</span>:
					</label>
					<div class="col-sm-8">
						<form:input path="smallImage" name="smallImage" id="smallImage"
							type="file" class="form-control"></form:input>
					</div>
				</div>

				<div class="row" style="height: 20px"></div>
				<form:button style="float: right; width: 150px;" type="submit"
					class="btn btn-primary">
					<i class="fa fa-check" aria-hidden="true"></i>&ensp;Cập nhật
			</form:button>
			</form:form>
			<button style="float: right; margin-right: 10px; width: 150px;"
				class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/listDanhMuc'/>';">
				<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
			</button>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>