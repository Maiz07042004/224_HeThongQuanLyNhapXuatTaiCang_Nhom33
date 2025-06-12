<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">CẬP NHẬT VÉ</p>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div style="margin-top: 10px;">
		<form:form action="${contextPath}/Ticket_Selling/thuchienupdateVe"
			method="POST" modelAttribute="ticket">
			<div class="form-group row" style="display: none;">
				<label class="col-sm-4 col-form-label">Mã vé</label>
				<div class="col-sm-8">
					<form:input path="ticketID" name="ticketID" id="ticketID"
						type="number" class="form-control"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Loại vé:</label>
					<div class="col-sm-8">
					<form:input path="ticketType" name="ticketType" id="ticketType"
						type="number" class="form-control"></form:input>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Giá tiền:</label>
				<div class="col-sm-8">
					<form:input path="price" name="price" id="price"
						type="number" class="form-control"></form:input>
				</div>
			</div>
			<div class="row" style="height: 20px"></div>
			<form:button style="float: right; width: 150px;" type="submit"
				class="btn btn-primary">
				<i class="fa fa-check" aria-hidden="true"></i>&ensp;Cập nhật
			</form:button>

		</form:form>
		<button style="float: right; margin-right: 10px; width: 150px;"
			class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/listTicket'/>';">
			<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
		</button>
</div>
	</div>
</div>

