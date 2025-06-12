<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">CẬP NHẬT PHÒNG CHIẾU</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<form:form action="${contextPath}/Ticket_Selling/thucHienUpdatePhongChieu"
			method="GET" modelAttribute="room">
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Mã phòng chiếu:</label>
				<div class="col-sm-8">
					<form:input path="cinemaRoomID" name="cinemaRoomID" id="cinemaRoomID"
						type="text" class="form-control" readonly="true"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Nhập tên phòng chiếu:</label>
				<div class="col-sm-8">
					<form:input path="cinemaRoomName" name="cinemaRoomName" id="cinemaRoomName"
						type="text" class="form-control"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Chọn số lượng ghế:</label>
				<div class="col-sm-8">
					<form:select path="seatQuantity" name="seatQuantity" id="seatQuantity"
						class="form-control">
						<form:option value="60">60</form:option>
						<form:option value="80">80</form:option>
						<form:option value="100">100</form:option>
						<form:option value="120">120</form:option>
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
			onclick="location.href='<c:url value ='/Ticket_Selling/listPhongChieu'/>';">
			<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
		</button>

	</div>
</div>
<%@include file="include/footer.jsp"%>