<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>
	<article>
		<h2>마이페이지(${title})</h2>
		<form name="form" method="post">
			<table id="cartList">
				<tr>
					<th>주문 일자</th>
					<th>주문 번호</th>
					<th>상품명</th>
					<th>결제 금액</th>
					<th>주문 상세</th>
				</tr>
				<c:forEach items="${ordersList}" var="orders">
					<tr>
						<td><fmt:formatDate value="${orders.orderDate}" type="date" /></td>
						<td>${orders.no}</td>
						<td>${orders.details[0].cart.product.name } 외
							${fn:length(orders.details)}건</td>
						<c:set var="subTotal" value="0" />
						<c:forEach items="${orders.details}" var="detail">
							<c:set var="subTotal"
								value="${subTotal + detail.cart.product.salePrice}" />
						</c:forEach>
						<td><fmt:formatNumber value="${subTotal}" type="currency" /></td>
						<td><a href="orderDetail.do?no=${orders.no}"> 조회 </a></td>
					</tr>
				</c:forEach>
			</table>
	
			<div class="clear"></div>
			<div id="buttons" style="float: right">
				<input type="button" value="쇼핑 계속하기" class="cancel"
					onclick="location.href='/project_ifrill/main'">
			</div>
		</form>
	</article>
<%@ include file="../footer.jsp"%>
