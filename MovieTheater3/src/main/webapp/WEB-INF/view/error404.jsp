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
		<div class="box-movie-center shadow p-3 mb-5 bg-white rounded">
			<div class="d-flex justify-content-center">
				<label
					style="font-size: 28px; color: red; font-family: arial; text-align: center; width: 100%;">${errorData}</label>
			</div>
			<br>
			<div class="d-flex justify-content-center">
				<a href="<c:url value ='/Ticket_Selling/'/>">
					<button class="btn btn-warning">
						<i class="fa fa-home" aria-hidden="true"></i>&nbsp;&nbsp; GO BACK
						HOME PAGE
					</button>
				</a>
			</div>

		</div>
	</div>
	<script src="<c:url value='/resources/library/popper.min.js'/>"></script>
	<script src="<c:url value='/resources/js/form-validation.js'/>"></script>
</body>
</html>