<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH SELLER ĐANG CHỜ DUYỆT</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['messageapprove']}">
				<p style="color: green;">Duyệt seller thành công!</p>
			</c:if>
		</div>
		<div style="margin-top: 20px">
			<table id="example" class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Tài khoản</th>
						<th scope="col">Họ và tên</th>
						<th scope="col">Số điện thoại</th>
						<th style="width: 110px;" scope="col">Số CCCD</th>
						<th style="width: 110px;" scope="col">Địa chỉ</th>
						<th scope="col">Ngày sinh</th>
						<th scope="col">Duyệt</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listSeller" items="${listSeller}">
						<tr>
							<td>${listSeller.userName}</td>
							<td>${listSeller.fullName}</td>
							<td>${listSeller.phoneNumber}</td>
							<td>${listSeller.identityCard}</td>
							<td>${listSeller.address}</td>
							<td>${listSeller.dateOfBirth}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/updateSeller/${listSeller.userName}'/>"><button>
										<i class="fa fa-check-square-o" aria-hidden="true"></i>
									</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row" style="height: 20px"></div>
			<button style="float: right;" type="button" class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/themMoi'/>';">Thêm
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