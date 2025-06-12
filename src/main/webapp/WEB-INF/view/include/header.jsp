<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon"
	href="<c:url value='/resources/img/ticket.png'/>">
<title>Cảng Tiên Sa</title>
<script
	src="<c:url value='/resources/library/jquery-3.3.1.slim.min.js' />"></script>
<script src="<c:url value='/resources/library/jquery-3.4.1.min.js'/>"></script>
<script
	src="<c:url value='/resources/library/datatablejs/media/js/jquery.dataTables.js'/>"></script>
<script src="<c:url value='/resources/library/popper.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/datatablejs/media/css/jquery.dataTables.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/font-awesome.min.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/library/style.css'/>">
<script src="<c:url value='/resources/library/font-awesome.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/showTimes.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/customReset.css'/>">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<div class="col-md-12"
		style="background-color: #0056A8; margin-bottom: 30px">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">

					<a style="color: white; font-size: 30px" class="navbar-brand fpt"
						href="<c:url value ='/Ticket_Selling/'/>"><i
						class="fa fa-home" aria-hidden="true"></i>&ensp;Cảng Tiên Sa</a>
				</div>
				<!-- Search form -->
				<c:set var="contextPath" value="${pageContext.request.contextPath}" />
				<div align="center">
					<form class="form-inline" style="width: 600px"
						action="${contextPath}/Ticket_Selling/searchPhim" method="get">
						<input class="form-control form-control-sm mr-3 w-75" type="text"
							placeholder="Tìm kiếm ..." aria-label="Search" name="movie" />
						<button style="background-color: #595ED7; border: none;"
							type="submit" value="Submit">
							<i class="fa fa-search" aria-hidden="true" style="color: white;"></i>
						</button>
					</form>
				</div>
				<ul class="nav navbar-nav navbar-right d-flex flex-row">

					<c:if test="${account ne null}">
						<li><a style="color: white"
							href="${pageContext.request.contextPath}/logout"><i
								class="fa fa-sign-out" aria-hidden="true" style="color: white;"></i>
								Hi, ${account.getAccountID()}</a></li>

					</c:if>
					<c:if test="${account eq null}">
						<li><a style="color: white"
							href="${pageContext.request.contextPath}/login"><i
								class="fa fa-sign-in" aria-hidden="true" style="color: white;"></i>
								Sign in</a></li>
					</c:if>

				</ul>
			</div>
		</nav>
	</div>
	<%@include file="menuleft.jsp"%>