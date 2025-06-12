<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THÊM MỚI LỊCH CHIẾU</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<form:form
			action="${contextPath}/Ticket_Selling/thucHienThemMoiLichChieu"
			method="GET" modelAttribute="scheduleSeat">
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Mã lịch chiếu:</label>
				<div class="col-sm-8">
					<form:input path="scheduleSeatID" name="scheduleSeatID"
						id="scheduleSeatID" type="text" class="form-control"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Tên phim:</label>
				<div class="col-sm-8">
					<form:select path="movie.movieID" name="movieID" id="movieID"
						items="${listMovieID}" class="form-control">
					</form:select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Giờ chiếu:</label>
				<div class="col-sm-8">
					<form:select path="schedule.scheduleID" name="scheduleID"
						id="scheduleID" items="${listScheduleID}" class="form-control"></form:select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Ngày chiếu:</label>
				<div class="col-sm-8">
					<form:select path="showDates.showDateID" name="showDateID"
						id="showDateID" items="${listShowdateID}" class="form-control"></form:select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Mã ghế ngồi đầu tiên:</label>
				<div class="col-sm-8">
					<form:select path="seat.seatID" name="seatID" id="seatID"
						items="${listSeatID}" class="form-control"></form:select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Loại vé:</label>
				<div class="col-sm-8">
					<form:select path="ticket.ticketID" name="ticketID" id="ticketID"
						items="${listTicketID}" class="form-control"></form:select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Trạng thái ghế:</label>
				<div class="col-sm-8">
					<form:select path="seatStatus" name="seatStatus" id="seatStatus"
						class="form-control">
						<form:option value="0">Chưa được đặt</form:option>
						<form:option value="1">Đã được đặt</form:option>
					</form:select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Loại ghế:</label>
				<div class="col-sm-8">
					<form:select path="seatType" name="seatType" id="seatType"
						class="form-control">
						<form:option value="0">Ghế thường</form:option>
						<form:option value="1">Ghế VIP</form:option>
					</form:select>
				</div>
			</div>
			<div class="row" style="height: 20px"></div>
			<form:button style="float: right; width: 150px;" type="submit"
				class="btn btn-primary">
				<i class="fa fa-check" aria-hidden="true"></i>&ensp;Thêm mới
			</form:button>
		</form:form>
		<button style="float: right; margin-right: 10px; width: 150px;"
			class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/listNgayChieu'/>';">
			<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
		</button>

	</div>
</div>
<%@include file="include/footer.jsp"%>