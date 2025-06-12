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
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/bootstrap.min.css'/>">
<script type="text/javascript"
	src="<c:url value='/resources/library/jquery-3.3.1.slim.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/library/popper.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/library/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/library/font-awesome.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/selectSeat.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/customReset.css'/>">
</head>
<body style="background-color: #ebebeb;">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="${contextPath}/Ticket_Selling/Booking_Ticket"
		method="POST">
		<div class="box-wrapper">
			<div class="box-movie-center shadow p-3 mb-5 bg-white rounded">
<!-- 				<div style="padding-top: 20px"> -->
<!-- 					<label for="seat-size" -->
<!-- 						style="float: left; font-family: arial; font-weight: bold; font-size: 20xp; padding: 10px;">Select -->
<!-- 						seat quantity:</label> <select name="seatQuantity" id="seat-size" -->
<!-- 						class="form-control" style="width: 80px;"> -->
<!-- 						<option value="1">1</option> -->
<!-- 						<option value="2">2</option> -->
<!-- 						<option value="3">3</option> -->
<!-- 						<option value="4">4</option> -->
<!-- 						<option value="5">5</option> -->
<!-- 						<option value="6">6</option> -->
<!-- 						<option value="7">7</option> -->
<!-- 						<option value="8">8</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
				<br>

				<div class="row">
					<div class="d-flex justify-content-center col-sm-12">
						<c:if test="${empty errorData}">
							<table class="table" style="width: 0px;">
								<tbody>
									<c:set var="dem" value="${0}" />
									<c:forEach var="j" begin="0" end="${sizeRow}">
										<tr>
											<c:forEach var="i" begin="0" end="${sizeColumn}">
												<c:if test="${listSeatOfMovie[dem].seatStatus == 1}">
													<td><label class="container"> <input
															type="checkbox" disabled="disabled"
															value="${listSeatOfMovie[dem].scheduleSeatID}"
															name="listSeat"> <span class="seat-sold"><b
																class="seat-id">${listSeatOfMovie[dem].seatRow}${listSeatOfMovie[dem].seatColumn}</b></span>
													</label></td>
												</c:if>
												<c:if
													test="${listSeatOfMovie[dem].seatStatus == 0 && listSeatOfMovie[dem].seatType == 1}">
													<td><label class="container"> <input
															type="checkbox"
															value="${listSeatOfMovie[dem].scheduleSeatID}"
															name="listSeat"> <span class="seat-vip"><b
																class="seat-id">${listSeatOfMovie[dem].seatRow}${listSeatOfMovie[dem].seatColumn}</b></span>
													</label></td>
												</c:if>
												<c:if
													test="${listSeatOfMovie[dem].seatStatus == 0 && listSeatOfMovie[dem].seatType == 0}">
													<td><label class="container"> <input
															type="checkbox"
															value="${listSeatOfMovie[dem].scheduleSeatID}"
															name="listSeat"> <span class="seat-canchoose"><b
																class="seat-id">${listSeatOfMovie[dem].seatRow}${listSeatOfMovie[dem].seatColumn}</b></span>
													</label></td>
												</c:if>
												<c:if test="${(i + 1) % 3 == 0 && i ne sizeColumn}">
													<td>&nbsp;&nbsp;</td>
												</c:if>
												<c:set var="dem" value="${dem + 1}" />
											</c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
						<c:if test="${not empty errorData}">
							<label
								style="font-size: 28px; color: red; font-family: arial; text-align: center; width: 100%;">${errorData}</label>
						</c:if>
					</div>
					<br>

					<div class="d-flex justify-content-center col-sm-12">
						<div align="center" style="width: 450px; margin: 0 0 15px 18px;">
							<br>
							<h4 style="font-weight: bold; font-family: arial;">Screen</h4>
							<hr class="screen">
						</div>
					</div>
					<div class="d-flex justify-content-center col-sm-12">
						<div>
							<div
								style="background-color: #b1dd77; height: 20px; width: 20px; float: left;"></div>
							<label style="float: left; margin: 0 10px; font-family: arial;">Seat
								is selecting</label>
							<div
								style="background-color: #e11c01; height: 20px; width: 20px; float: left;"></div>
							<label style="float: left; margin: 0 10px; font-family: arial;">Seat
								is sold</label>
							<div
								style="background-color: #ebebeb; height: 20px; width: 20px; float: left;"></div>
							<label style="float: left; margin: 0 10px; font-family: arial;">Seat
								can choose</label>
							<div
								style="background-color: #3c9bec; height: 20px; width: 20px; float: left;"></div>
							<label
								style="float: left; margin-left: 10px; font-family: arial;">Seat
								VIP</label>
						</div>
					</div>
				</div>


			</div>
			<div style="float: right;">
				<a class="btn btn-primary"
					href="<c:url value ='/Ticket_Selling/Show_Time'/>">
					<i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;&nbsp;Quay lại
				</a>
				<button type="reset" class="btn btn-primary">
					<i class="fa fa-history" aria-hidden="true"></i>&nbsp;&nbsp;Chọn lại
				</button>
				<button type="submit" class="btn btn-primary" id="btn" onclick="check()">
					<i class="fa fa-arrow-right" aria-hidden="true"></i>&nbsp;&nbsp;Tiếp tục
				</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
	$(document).ready(function () {
        $("#btn").click(function(){
          let a = $("input:checked").parent().text();
        if(a==""){
        	alert("Please select at least one seat.");
			event.preventDefault();
			event.stopPropagation();
        }
        })
        
    	});
		function check() {
			var n = $("input:checked").length;	
			console.log(a);
			var m = document.getElementById("seat-size").value;
			if (m > n) {
				alert("Please select " + (m - n) + " seat more.");
				event.preventDefault();
				event.stopPropagation();
			}
			if (n > m) {
				alert("Please select only " + m + " seat.");
				event.preventDefault();
				event.stopPropagation();
			}

		}
	</script>
</body>
</html>