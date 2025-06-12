<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<c:url value='/resources/img/ticket.png'/>">
<title>APPLE THEATER</title>
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
			<p class="text-show-time">XÁC NHẬN ĐẶT VÉ</p>
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
							<label class="label-value">${movieSchedule.movie.cinemaRoom.cinemaRoomName}</label>
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
					<div class="row">
						<div class="col-sm-12">
							<label class="text-movie-name label-member">Member</label>
						</div>
					</div>
					<hr>
					<c:set var="contextPath" value="${pageContext.request.contextPath}" />
					<form action="${contextPath}/Ticket_Selling/Check_Member"
						method="POST" class="add-customer-validation" novalidate>
						<div class="row">
							<div class="col-sm-6">
								<input type="text" name="searchAccount" value="${searchAccount}"
									autofocus class="form-control input-search" maxlength="10"
									placeholder="Phone Number" pattern="^[a-zA-Z0-9]{9,10}$"
									required>
								<div class="invalid-feedback input-search">Please enter
									member's phone number</div>
							</div>
							<div class="col-sm-6">
								<input class="btn btn-primary button-check" name="checkAccount"
									type="submit" value="Check" />
							</div>
							<p class="error-message">${checkAccountMessage}</p>
						</div>
					</form>
					<c:if test="${not empty member}">
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
						<div class="row">
							<div class="col-sm-5">
								<label class="label-attribute">Score:</label>
							</div>
							<div class="col-sm-7">
								<label class="label-number">${scoreString}</label>
							</div>
						</div>
						<hr>
						<c:set var="contextPath"
							value="${pageContext.request.contextPath}" />
						<form
							action="${contextPath}/Ticket_Selling/Confirm_Booking_Ticket"
							method="POST" class="add-customer-validation" novalidate>
							<div class="row">
								<div class="col-sm-5">
									<p class="label-attribute">
										Convert to ticket:<label style="color: red;">*</label>
									</p>
								</div>
								<div class="col-sm-7">
									<input type="radio" name="convertTicket" id="convertTicket2"
										value="Agree" title="Agree" autofocus
										class="form-control input-radio-score"
										style="width: 15px; height: 15px; display: inline;" required>
									<label for="convertTicket2" class="label-value">Agree</label> <br>
									<input type="radio" name="convertTicket" id="convertTicket3"
										value="Disagree" title="Disagree" autofocus
										class="form-control input-radio-score"
										style="width: 15px; height: 15px; display: inline;" required>
									<label for="convertTicket3" class="label-value label-score">Disagree</label>
									<div class="invalid-feedback">You haven't selected the
										score usage form.</div>
								</div>
							</div>
							<p class="error-message">${scoreMassage}</p>
					</c:if>
					<c:if test="${empty member}">
						<br>
						<br>
						<br>
					</c:if>
				</div>
			</div>
		</div>
		<div>
			<c:if test="${empty member}">
				<a class="btn btn-primary" style="float: right; margin-right: 5px;"
					href="<c:url value ='/Ticket_Selling/Confirm_Booking_Ticket'/>">
					<i class="fa fa-ticket text-light" aria-hidden="true"></i> Confirm
					booking ticket
				</a>
			</c:if>
			<c:if test="${not empty member}">
				<button class="button-confirm btn btn-primary" type="submit"
					name="cofirm">
					<i class="fa fa-ticket text-light" aria-hidden="true"></i> Confirm
					booking ticket
				</button>
				<!-- 				<a class="btn btn-primary" style="float: right; margin-right: 5px;" -->
				<%-- 				href="<c:url value ='/Ticket_Selling/Confirm_Booking_Ticket'/>"> --%>
				<!-- 				<i class="fa fa-ticket text-light" aria-hidden="true"></i> Confirm -->
				<!-- 					booking ticket -->
				<!-- 			</a> -->
			</c:if>
			<a class="btn btn-primary" style="float: right; margin-right: 5px;"
				href="<c:url value ='/Ticket_Selling/Selecting_Seat/${movieDate.showDates.showDateID}/${movieDate.movie.movieID}/${movieSchedule.schedule.scheduleID}'/>">
				<i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;&nbsp;Back
			</a>
		</div>
		</form>
	</div>
	<script src="<c:url value='/resources/library/popper.min.js'/>"></script>
	<script src="<c:url value='/resources/js/form-validation.js'/>"></script>
</body>

</html>