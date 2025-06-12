<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH GHẾ NGỒI</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<form:form method="GET" modelAttribute="movies" align="center"
				action="${contextPath}/thongkeSLV">
				<select name="roomID" onchange="location=options[selectedIndex].value;">
					<c:forEach var="seat" items="${listSeat}" >
						<option hidden>-- Chọn phòng chiếu -- </option>
						<option value="thongtinghe?roomID=${seat.cinemaRoomID}">${seat.cinemaRoomName }</option>
					</c:forEach>
				</select>
			</form:form>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped text-center">
				<thead>
					<tr>
						<th scope="col">Mã ghế</th>
						<th scope="col">Tên hàng</th>
						<th scope="col">Tên cột</th>
						<th scope="col">Mã phòng chiếu</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listSeat" items="${listSeatRoom}">
						<tr>
							<td>${listSeat.seatID}</td>
							<td>${listSeat.seatRow}</td>
							<td>${listSeat.seatColumn}</td>
							<td>${listSeat.cinemaRoom.cinemaRoomID}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
<%@include file="include/footer.jsp"%>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>