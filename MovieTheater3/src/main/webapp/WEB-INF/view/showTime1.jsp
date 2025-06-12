<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<c:url value='/resources/img/ticket.png'/>">
<title>SHOWTIMES</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/showTimes.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/customReset.css'/>">
</head>
<body class="box-body">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">SHOWTIMES</p>
		</div>
		<div class=" d-flex justify-content-center">
			<div class="box-btn-show-date row ">
				<c:forEach var="tempShowDates" items="${listShowDates}">
					<div class="col-2 d-flex justify-content-center">
						<c:if test="${tempShowDates.showDateID eq dateID}">
							<c:set var="btnClass" value="${btnChoose}" />
						</c:if>
						<c:if test="${tempShowDates.showDateID ne dateID}">
							<c:set var="btnClass" value="${btnNormal}" />
						</c:if>
						<button class="${btnClass}"
							onclick="location.href='<c:url value ='/Ticket_Selling/Show_Date/${tempShowDates.showDateID}'/>';">
							<p class="text-show-date">
								<strong>${tempShowDates.showDate.getDayOfMonth()}</strong>
							</p>
							<p class="text-show-day">${tempShowDates.dateName}</p>
						</button>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="box-movie-center shadow p-3 mb-5 bg-white rounded">
			<label
				style="font-size: 28px; color: red; font-family: arial; text-align: center; width: 100%;">${nullMovieMessage}</label>
			<c:forEach var="tempMovieDate" items="${listMovieDate}">
				<div class="box-movie row">
					<div class="box-img-movie col-sm-2">
						<a href="<c:url value ='/Ticket_Selling/errorPage'/>"> <img
							src="<c:url value='/resources/img/${tempMovieDate.movie.smallImage}'/>"
							class="img-movie"></a>
					</div>
					<div class="col-sm-10">
						<a class="text-movie-name"
							href="<c:url value ='/Ticket_Selling/errorPage'/>">
							${tempMovieDate.movie.movieNameVN} </a> <label
							class="label-movie-name">${tempMovieDate.movie.movieNameEnglish}</label>
						<c:forEach var="tempMovieSchedule"
							items="${tempMovieDate.movie.listMovieSchedule}">
							<c:set var="hourSchedule"
								value="${Integer.parseInt(tempMovieSchedule.schedule.scheduleTime.substring(0, 2))}" />
							<c:set var="minuteSchedule"
								value="${Integer.parseInt(tempMovieSchedule.schedule.scheduleTime.substring(3, 5))}" />
							<c:if
								test="${tempMovieDate.showDates.showDateID <= dateNowID}">
								<c:if test="${hourSchedule < hourNow}">
									<button disabled class="btn-show-time-dis">${tempMovieSchedule.schedule.scheduleTime}</button>
								</c:if>
								<c:if test="${hourSchedule == hourNow}">
									<c:if test="${minuteSchedule < minuteNow}">
										<button disabled class="btn-show-time-dis">${tempMovieSchedule.schedule.scheduleTime}</button>
									</c:if>
									<c:if test="${minuteSchedule >= minuteNow}">
										<button class="btn-show-time"
									onclick="location.href='<c:url value ='/Ticket_Selling/Selecting_Seat/${tempMovieDate.showDates.showDateID}/${tempMovieDate.movie.movieID}/${tempMovieSchedule.schedule.scheduleID}'/>';">${tempMovieSchedule.schedule.scheduleTime}</button>
									</c:if>
								</c:if>
								<c:if test="${hourSchedule > hourNow}">
									<button class="btn-show-time"
									onclick="location.href='<c:url value ='/Ticket_Selling/Selecting_Seat/${tempMovieDate.showDates.showDateID}/${tempMovieDate.movie.movieID}/${tempMovieSchedule.schedule.scheduleID}'/>';">${tempMovieSchedule.schedule.scheduleTime}</button>
								</c:if>
							</c:if>
							<c:if
								test="${tempMovieDate.showDates.showDateID > dateNowID}">
								<button class="btn-show-time"
									onclick="location.href='<c:url value ='/Ticket_Selling/Selecting_Seat/${tempMovieDate.showDates.showDateID}/${tempMovieDate.movie.movieID}/${tempMovieSchedule.schedule.scheduleID}'/>';">${tempMovieSchedule.schedule.scheduleTime}</button>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<hr>
			</c:forEach>
		</div>
	</div>
</body>
</html>