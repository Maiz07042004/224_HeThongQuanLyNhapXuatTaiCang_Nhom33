<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH NGƯỜI DÙNG</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới người dùng thành công!</p>
			</c:if>
			<c:if test="${param['update']}">
				<p style="color: green;">Cập nhật người dùng thành công!</p>
			</c:if>
			<c:if test="${param['delete']}">
				<p style="color: red;">Người dùng đã được xóa!</p>
			</c:if>
		</div>
		<table id="example" class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Mã người dùng</th>
					<th scope="col">Họ và tên</th>
					<th scope="col">Cập nhật</th>
					<th scope="col">Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listAccount" items="${listAccount}">
					<tr>
						<td>${listAccount.accountID}</td>
						<td>${listAccount.fullName}</td>
						<td align="center"><a
							href="<c:url value ='/Ticket_Selling/updateUser/${listAccount.accountID}'/>"><button>
									<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
								</button></a></td>
						<td align="center"><a
							href="<c:url value ='/Ticket_Selling/deleteUser/${listAccount.accountID}'/>"><button
									onclick="return confirm('Xác nhận xóa người dùng này?')">
									<i class="fa fa-trash-o" aria-hidden="true"></i>
								</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row" style="height: 20px"></div>
		<button style="float: left;" type="button" class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/themMoiUser'/>';">Thêm
			mới</button>
			<button style="float: right;" type="button" class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/addExcel'/>';">Thêm
			mới từ file Excel</button>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>