<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<style>
div.sc_menu {
	position: relative;
	overflow: auto;
	max-width: 1000px;
	min-width: 400px;
}

ul.sc_menu {
	display: block;
	width: 2500px;
	padding: 0 0 0 10px;
	margin: 0;
	list-style: none;
}

.sc_menu li {
	display: block;
	float: left;
	padding: 0 4px;
}

.sc_menu a {
	display: block;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #000;
	text-decoration: none;
	padding: 5px 10px;
	font-family: Arial, Helvetica, sans-serif;
}
div.pd_menu {
	max-width: 1000px;
	min-width: 400px;
}

ul.pd_menu {
	display: block;
	width: 1200px;
	padding: 0 0 0 10px;
	margin: 0;
	list-style: none;
}

.pd_menu li {
	display: block;
	float: left;
	padding: 0 4px;
}

.pd_menu a {
	display: block;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #000;
	text-decoration: none;
	padding: 5px 10px;
	font-family: Arial, Helvetica, sans-serif;
}

</style>
<div id="content">
	<!-- <body class="box-body"> -->
	
		
</div>

<script type="text/javascript">
	$(function() {
		var div = $('div.sc_menu'), ul = $('ul.sc_menu'), ulPadding = 15;
		var divWidth = div.width();
		div.css({
			overflow : 'hidden'
		});
		var lastLi = ul.find('li:last-child');
		div.mousemove(function(e) {
			var ulWidth = lastLi[0].offsetLeft + lastLi.outerWidth()
					+ ulPadding;

			var left = (e.pageX - div.offset().left) * (ulWidth - divWidth)
					/ divWidth;
			div.scrollLeft(left);
		});
	});
</script>

<%@include file="include/footer.jsp"%>