<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<div class="col-md-8" id="content">
	<div class="box-wrapper container-fluid">
		<div>
			<p class="text-show-time">GIỎ HÀNG</p>
		</div>
		<table id="example" class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Ảnh</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Đơn giá</th>
					<th scope="col">Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="dem" value="${0}" />
				<c:set var="count" value="${0}" />
				<c:forEach var="listGioHangDetail" items="${listGioHangDetail}">
					<c:forEach var="listProduct" items="${listProduct}">
						<c:if
							test="${listGioHangDetail.gioHangID.productID eq listProduct.productID}">

							<tr>
								<td><img width="45" height="45"
									src="<c:url value='/resources/img/${listProduct.smallImage}'/>"
									class="img-fluid"></td>
								<td>${listProduct.productName}</td>
								<td><input style="width: 45px; text-align: center;"
									type="number" id="${dem}" name="soLuong"
									value="${listGioHangDetail.quantity}"
									onchange="Update(${dem},${listProduct.productID})"></td>
								<td>${listProduct.price}</td>
								<td align="center"><a
									href="<c:url value ='/Ticket_Selling/deleteCart/${listGioHangDetail.gioHangID.productID}'/>"><button
											onclick="return confirm('Xác nhận xóa sản phẩm này?')">
											<i class="fa fa-trash-o" aria-hidden="true"></i>
										</button></a></td>
							</tr>
							<div class="row" style="display: none;">
								<div class="col-sm-5">
									<label class="label-attribute">Mã Sản Phẩm:</label>
								</div>
								<div class="col-sm-7">
									<input type="text" id="productID" name="productID"
										value="${listProduct.productID}"></input>
								</div>
							</div>
							<c:set var="dem" value="${dem + 1}" />
						</c:if>

					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
		<div class="row" style="height: 20px"></div>
		<button style="float: right;" type="button" class="btn btn-primary"
			onclick="location.href='<c:url value ='/Ticket_Selling/confirmBuying'/>';">Mua
			hàng</button>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<script>
function Update(dem, productID) {
	  const xhttp = new XMLHttpRequest();
  var quantity = document.getElementById(dem).value;
	var url = "http://localhost:8012/OnlineShopping/Ticket_Selling/updateQuantity/" + quantity + "/" + productID ;
	//window.location.href = url; 
	  xhttp.open("GET", url);
	  xhttp.send();


}
</script>
<%@include file="include/footer.jsp"%>