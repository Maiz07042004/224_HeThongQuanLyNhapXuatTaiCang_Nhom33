<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH KHÁCH HÀNG</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới khách hàng thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật khách hàng thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Khách hàng đã được xóa!</p>
			</c:if>
		</div>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped text-center">
				<thead>
					<tr>
						<th scope="col">Mã khách hàng</th>
						<th scope="col">Tên khách hàng</th>
						<th scope="col">Địa chỉ</th>
						<th scope="col">Số điện thoại</th>
						<th scope="col">Xoá khách hàng</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listAccount" items="${listAccount}">
						<tr>
							<td>${listAccount.accountID}</td>
							<td>${listAccount.fullName}</td>
							<td>${listAccount.address}</td>
							<td>${listAccount.phoneNumber}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/deleteKhachHang/${listAccount.accountID}'/>"><button
										onclick="return confirm('Xác nhận xóa khách hàng này?')">
										<i class="fa fa-trash-o" aria-hidden="true"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>