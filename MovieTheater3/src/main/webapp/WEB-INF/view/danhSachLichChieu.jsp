<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THÔNG TIN PHÒNG CHIẾU</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div align="center" style="margin-top: 10px">
			<p style="color: green;">${messageInsert}</p>
			<p style="color: green;">${messageUpdate}</p>
			<p style="color: red;">${messageDelete}</p>
		</div>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped text-center">
				<thead>
					<tr>
						<th scope="col">Tên phim</th>
						<th scope="col">Ngày chiếu</th>
						<th scope="col">Giờ chiếu</th>
						<th scope="col">Mã vé</th>
						<th scope="col">Trạng thái</th>
						<th scope="col">Loại ghế</th>
						<th scope="col">Cập nhật</th>
						<th scope="col">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listScheduleSeat" items="${listScheduleSeat}">
						<tr>
							<td>${listScheduleSeat.movie.movieNameVN}</td>
							<td>${listScheduleSeat.showDates.showDate}</td>
							<td>${listScheduleSeat.schedule.scheduleTime}</td>
							<td>${listScheduleSeat.ticket.ticketID}</td>
							<td>${listScheduleSeat.seatStatus}</td>
							<td>${listScheduleSeat.seatType}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/updateLichChieu/${listScheduleSeat.scheduleSeatID}'/>"><button>
										<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
									</button></a></td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/deleteLichChieu/${listScheduleSeat.scheduleSeatID}'/>"><button
										onclick="return confirm('Xác nhận xóa lịch chiếu này?')">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row" style="height: 20px"></div>
			<button style="float: right;" type="button" class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/themMoiLichChieu'/>';">Thêm
				mới</button>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>