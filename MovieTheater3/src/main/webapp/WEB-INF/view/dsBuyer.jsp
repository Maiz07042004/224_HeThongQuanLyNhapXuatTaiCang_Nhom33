<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">DANH SÁCH KHÁCH HÀNG TRONG THÁNG</p>
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
						<th scope="col">Chi tiết</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listInvoice" items="${listInvoice}">
					<c:forEach var="listAccount" items="${listAccount}">
					<c:if
							test="${listInvoice eq listAccount.accountID}">
					
						<tr>
							<td>${listAccount.userName}</td>
							<td>${listAccount.fullName}</td>
							<td>${listAccount.phoneNumber}</td>
							<td>${listAccount.identityCard}</td>
							<td>${listAccount.address}</td>
							<td>${listAccount.dateOfBirth}</td>
							<td align="center"><a
								href="<c:url value ='/Ticket_Selling/showBuyerDetail/${listAccount.userName}'/>"><button>
										<i class="	fa fa-external-link" aria-hidden="true"></i>
									</button></a></td>
						</tr>
						</c:if>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@include file="include/footer.jsp"%>