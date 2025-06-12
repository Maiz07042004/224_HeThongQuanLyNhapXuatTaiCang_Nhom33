<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH PHÒNG CHIẾU</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới phòng chiếu và ghế tương ứng thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật phòng chiếu và ghế tương ứng thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Phòng chiếu đã được xóa!</p>
			</c:if>
		</div>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Tên phòng chiếu</th>
						<th scope="col">Số ghế ngồi</th>
						<th scope="col">Cập nhật</th>
						<th scope="col">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listRoom" items="${listRoom}">
						<tr>
							<td>${listRoom.cinemaRoomName}</td>
							<td>${listRoom.seatQuantity}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/updatePhongChieu/${listRoom.cinemaRoomID}'/>"><button>
										<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
									</button></a></td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/deletePhongChieu/${listRoom.cinemaRoomID}'/>"><button
										onclick="return confirm('Xác nhận xóa phòng chiếu này?')">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row" style="height: 20px"></div>
			<button style="float: right;" type="button" class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/themMoiPhongChieu'/>';">Thêm
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