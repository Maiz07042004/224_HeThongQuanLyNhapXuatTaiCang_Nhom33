<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH PHIM - GIỜ CHIẾU</p>
		</div>
				<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới phim - giờ chiếu thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật phim - giờ chiếu thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Phim - giờ chiếu đã được xóa!</p>
			</c:if>
		</div>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Mã phim</th>
						<th scope="col">Tên phim(VN)</th>
						<th scope="col">Mã giờ chiếu</th>
						<th scope="col">Giờ chiếu</th>
						<th scope="col">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listMovieSchedule" items="${listMovieSchedule}">
						<tr>
							<td>${listMovieSchedule.movie.movieID}</td>
							<td>${listMovieSchedule.movie.movieNameVN}</td>
							<td>${listMovieSchedule.schedule.scheduleID}</td>
							<td>${listMovieSchedule.schedule.scheduleTime}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/deletePhim_Gio/${listMovieSchedule.movie.movieID}/${listMovieSchedule.schedule.scheduleID}'/>"><button
										onclick="return confirm('Xác nhận phim - giờ chiếu này?')">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row" style="height: 20px"></div>
			<button style="float: right;" type="button" class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/themMoiPhim_Gio'/>';">Thêm
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