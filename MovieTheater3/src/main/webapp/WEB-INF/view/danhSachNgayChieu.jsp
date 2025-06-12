<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH NGÀY CHIẾU</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới ngày chiếu thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật ngày chiếu thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Ngày chiếu đã được xóa!</p>
			</c:if>
		</div>
		<table id="example" class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Tên ngày chiếu</th>
					<th style="width: 110px;" scope="col">Ngày chiếu</th>
					<th scope="col">Cập nhật</th>
					<th scope="col">Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listShowdate" items="${listShowdate}">
					<tr>
						<td>${listShowdate.dateName}</td>
						<td>${listShowdate.showDate}</td>
						<td align="center"><a
							href="<c:url value ='/Ticket_Selling/updateNgayChieu/${listShowdate.showDateID}'/>"><button>
									<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
								</button></a></td>
						<td align="center"><a
							href="<c:url value ='/Ticket_Selling/deleteNgayChieu/${listShowdate.showDateID}'/>"><button
									onclick="return confirm('Xác nhận xóa ngày chiếu này?')">
									<i class="fa fa-trash-o" aria-hidden="true"></i>
								</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row" style="height: 20px"></div>
		<button style="float: right;" type="button" class="btn btn-primary"
			 onclick="location.href='<c:url value ='/themMoiNgayChieu'/>';">Thêm
				mới</button>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>