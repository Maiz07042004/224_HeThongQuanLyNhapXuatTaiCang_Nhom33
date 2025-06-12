<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<!-- <body class="box-body"> -->
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">THÊM MỚI SẢN PHẨM</p>
		</div>
		<div align="center" style="margin-top: 10px">
			<c:if test="${param['insert']}">
				<p style="color: green;">Thêm mới sản phẩm thành công!</p>
			</c:if>
		</div>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<div style="margin-top: 10px;">
			<form:form
				action="${contextPath}/Ticket_Selling/thucHienThemMoiSanPham"
				method="GET" modelAttribute="product">
				<div class="form-group row" style="display: none;">
					<label class="col-sm-4 col-form-label">Mã sản phẩm:</label>
					<div class="col-sm-8">
						<form:input path="productID" name="productID" id="productID"
							type="text" class="form-control" value="0"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập tên sản phẩm:</label>
					<div class="col-sm-8">
						<form:input path="productName" name="productName" id="productName"
							type="text" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập danh mục:</label>
					<div class="col-sm-8">
						<form:select path="categoryID.categoryID" name="categoryID" id="categoryID"
							items="${listCategoryID}" class="form-control">
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập đơn giá:</label>
					<div class="col-sm-8">
						<form:input path="price" name="price" id="price" type="number"
							class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Nhập số lượng:</label>
					<div class="col-sm-8">
						<form:input path="quantity" name="quantity" id="quantity"
							type="number" value="1" class="form-control"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Chọn hình ảnh minh
						họa<span style="color: red;">(*)</span>:
					</label>
					<div class="col-sm-8">
						<form:input path="smallImage" name="smallImage" id="smallImage"
							type="file" class="form-control"></form:input>

					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Chọn hình ảnh chi
						tiết<span style="color: red;">(*)</span>:
					</label>
					<div class="col-sm-8">
						<form:input path="largeImage" name="largeImage" id="largeImage"
							type="file" class="form-control"></form:input>

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
				onclick="location.href='<c:url value ='/Ticket_Selling/listDanhMuc'/>';">
				<i class="fa fa-arrow-left" aria-hidden="true"></i>&ensp;Quay lại
			</button>
		</div>
	</div>
</div>

