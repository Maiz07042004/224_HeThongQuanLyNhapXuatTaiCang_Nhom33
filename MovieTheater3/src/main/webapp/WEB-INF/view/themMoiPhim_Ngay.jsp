<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THÊM MỚI PHIM - NGÀY CHIẾU</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['error']}">
				<p style="color: red">Phim - ngày chiếu này đã tồn tại trong hệ thống!</p>
			</c:if>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div style="margin-top: 20px;">
			<form:form
				action="${contextPath}/Ticket_Selling/thucHienThemMoiPhim_Ngay"
				method="GET" modelAttribute="movieDate">
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Mã phim:</label>
					<div class="col-sm-8">
					<!-- path="movie.movieID" -->
						<form:select path="id.movieID" name="movieID" id="movieID"
							items="${listMovieID}" class="form-control"></form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Mã ngày chiếu:</label>
					<div class="col-sm-8">
						<!-- path="showDates.showDateID"  attibute Name đếu làm me hết--> 
						<form:select path="id.showDateID" name="showDateID"
							id="showDateID" items="${listShowdateID}" class="form-control"></form:select>
					</div>
				</div>
				<div class="row" style="height: 20px"></div>
				<form:button style="float: right; width: 150px;" type="submit"
					class="btn btn-primary">
					<i class="fa fa-check" aria-hidden="true"></i>&ensp;Thêm mới
			</form:button>
			</form:form>
			<button style="float: right; margin-right: 10px; width: 150px;"
				class="btn btn-primary"
				onclick="location.href='<c:url value ='/Ticket_Selling/listPhim_Ngay'/>';">
				<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
			</button>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>