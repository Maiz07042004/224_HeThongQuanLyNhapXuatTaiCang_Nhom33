<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">CẬP NHẬT NGÀY CHIẾU</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<p style="color: red;">${error}</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div style="margin-top: 10px;">
			<form:form
				action="${contextPath}/Ticket_Selling/thucHienUpdateNgayChieu"
				method="GET" modelAttribute="showdate">
				<div class="form-group row" style="display: none">
					<label class="col-sm-4 col-form-label">Mã ngày chiếu:</label>
					<div class="col-sm-8">
						<form:input path="showDateID" name="showDateID" id="showDateID"
							type="text" class="form-control" readonly="true"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập ngày chiếu:</label>
					<div class="col-sm-8">
						<form:input path="showDate" name="showDate" id="s howDate"
							type="date" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Chọn tên ngày chiếu:</label>
					<div class="col-sm-8">
						<form:select path="dateName" name="dateName" id="dateName"
							class="form-control">
							<form:option value="MON">Thứ hai</form:option>
							<form:option value="TUE">Thứ ba</form:option>
							<form:option value="WED">Thứ tư</form:option>
							<form:option value="THU">Thứ năm</form:option>
							<form:option value="FRI">Thứ sáu</form:option>
							<form:option value="SAT">Thứ bảy</form:option>
							<form:option value="SUN">Chủ nhật</form:option>
						</form:select>
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
				onclick="location.href='<c:url value ='/Ticket_Selling/listNgayChieu'/>';">
				<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
			</button>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>