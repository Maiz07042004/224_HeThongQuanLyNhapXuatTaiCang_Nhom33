<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<c:url value='/resources/img/ticket.png'/>">
<title>DUT THEATER</title>
<script
	src="<c:url value='/resources/library/jquery-3.3.1.slim.min.js' />"></script>
<script
	src="<c:url value='/resources/library/datatablejs/media/js/jquery.dataTables.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/customReset.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/confirmBookingTicket.css'/>">
<script src="<c:url value='/resources/library\font-awesome.min.js'/>"></script>
</head>
<body style="background-color: #eff0f3">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THÔNG TIN ĐẶT VÉ</p>
		</div>

		<div class="box-movie-center shadow p-3 mb-5 bg-white rounded">
			<div class="box-movie row">
				<div class="box-img-movie col-sm-2">
					<img
						src="<c:url value='/resources/img/${movieSchedule.movie.smallImage}'/>"
						class="img-fluid">
				</div>
				<div class="col-sm-10">
					<label class="text-movie-name">${movieSchedule.movie.movieNameVN}</label>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Screen:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value">${cinemaRoom}</label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Date:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value">${movieDate.showDates.formartStartDate()}</label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Time:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value">${movieSchedule.schedule.scheduleTime}</label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Seat:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value"><c:forEach var="tempListSeat"
									items="${listSeat}">
						${tempListSeat.seatRow}${tempListSeat.seatColumn}
						</c:forEach></label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Price:</label>
						</div>
						<div class="col-sm-7">
							<c:forEach var="tempListSeat" items="${listSeat}">
								<label class="label-value label-seat">${tempListSeat.seatRow}${tempListSeat.seatColumn}:
									${tempListSeat.ticket.price}</label>
								<br>
							</c:forEach>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Total:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-number">${totalPriceString}đ</label>
						</div>
					</div>
					<c:if test="${not empty member}">
					<div class="row">
						<div class="col-sm-12">
							<label class="text-movie-name label-member">Member</label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Member ID:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value">${member.memberID}</label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Identity Card:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value">${member.account.identityCard}</label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Full name:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value">${member.account.fullName}</label>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-5">
							<label class="label-attribute">Number phone:</label>
						</div>
						<div class="col-sm-7">
							<label class="label-value">${member.account.phoneNumber}</label>
						</div>
					</div>
					<hr>
					</c:if>
				</div>
			</div>
		</div>
		<a class="btn btn-primary" style="float: right;"
			href="<c:url value ='/Ticket_Selling/'/>"><i class="fa fa-home"
			aria-hidden="true"></i>&nbsp;&nbsp; GO BACK HOME PAGE </a>
	</div>
	<script src="<c:url value='/resources/library/popper.min.js'/>"></script>
	<script src="<c:url value='/resources/js/form-validation.js'/>"></script>
</body>
</html>