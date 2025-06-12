<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">CẬP NHẬT HỒ SƠ</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới danh mục thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật hồ sơ thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Danh mục đã được xóa!</p>
			</c:if>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div style="margin-top: 10px;">
			<form:form
				action="${contextPath}/Ticket_Selling/thucHienUpdateProfile"
				method="GET" modelAttribute="formAccount">
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Account ID</label><%--  <label
						class="col-sm-4 col-form-label">${accountID}</label> --%>
					<div class="col-sm-8">
						<form:input path="accountID" name="accountID" id="accountID"
							type="text" class="form-control" readonly="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Tên tài khoản</label>
					<%-- <label
						class="col-sm-4 col-form-label">${userName}</label> --%>
					<div class="col-sm-8">
						<form:input path="userName" name="userName" id="userName"
							type="text" class="form-control" readonly="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Role</label><%--  <label
						class="col-sm-4 col-form-label">${roles.roleName}</label> --%>
					<div class="col-sm-8">
						<form:input path="roles.roleID" name="roles.roleID"
							id="roles.roleID" type="text" class="form-control"
							readonly="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Địa chỉ</label>
					<div class="col-sm-8">
						<form:input path="address" name="address" id="address" type="text"
							class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Họ và tên</label>
					<div class="col-sm-8">
						<form:input path="fullName" name="fullName" id="fullName"
							type="text" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Mật khẩu</label>
					<div class="col-sm-8">
						<form:input path="password" name="password" id="password"
							type="password" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Số điện thoại</label>
					<div class="col-sm-8">
						<form:input path="phoneNumber" name="phoneNumber" id="phoneNumber"
							type="text" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Ngày sinh</label>
					<div class="col-sm-8">
						<form:input path="dateOfBirth" name="dateOfBirth" id="dateOfBirth"
							type="text" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Email</label>
					<div class="col-sm-8">
						<label class="col-sm-4 col-form-label">${email}</label>
						<form:input path="email" name="email" id="email" type="text"
							class="form-control" readonly="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Căn cước công dân</label>
					<div class="col-sm-8">
						<form:input path="identityCard" name="identityCard"
							id="identityCard" type="text" class="form-control"></form:input>
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
				onclick="location.href='<c:url value ='/Ticket_Selling/homePage'/>';">
				<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
			</button>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>