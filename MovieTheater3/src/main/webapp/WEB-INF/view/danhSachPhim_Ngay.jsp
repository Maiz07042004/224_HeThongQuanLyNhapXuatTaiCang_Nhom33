<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH PHIM - NGÀY CHIẾU</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới phim - ngày chiếu thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật phim - ngày chiếu thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Phim - ngày chiếu đã được xóa!</p>
			</c:if>
		</div>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Mã phim</th>
						<th scope="col">Tên phim(VN)</th>
						<th scope="col">Mã ngày chiếu</th>
						<th scope="col">Ngày chiếu</th>
						<th scope="col">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listMovieDate" items="${listMovieDate}">
						<tr>
							<td>${listMovieDate.movie.movieID}</td>
							<td>${listMovieDate.movie.movieNameVN}</td>
							<td>${listMovieDate.showDates.showDateID}</td>
							<td>${listMovieDate.showDates.showDate}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/deletePhim_Ngay/${listMovieDate.movie.movieID}/${listMovieDate.showDates.showDateID}'/>"><button
										onclick="return confirm('Xác nhận xóa phim - ngày chiếu này?')">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row" style="height: 20px"></div>
			<button style="float: right;" type="button" class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/themMoiPhim_Ngay'/>';">Thêm
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