<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">
  function go_order_save() {
	// 선택된 갯수
	var count = $("input:checkbox[name=result]:checked").length;

    if (count == 0) {
      alert("주문처리할 항목을 선택해 주세요.");
    } else {
    	$("#frm").attr("action", "adminOrderSave.do");
    	$('#frm').submit();
    }
  }
</script>
<article>
<h1>주문리스트</h1>
<form id="frm" name="frm" method="post">
  <table style="float: right;">
    <tr>
      <td>주문자 이름 <input type="text" name="key"> 
      <input class="btn" type="button" value="검색" onclick="go_search()">
      </td>
    </tr>
  </table>
  <br>
  <table id="orderList">
  <tr>
    <th>주문번호(처리여부)</th><th>주문자</th>
    <th>우편번호</th><th>배송지</th><th>전화</th><th>주문일</th>
    <th>상품명</th><th>수량</th><th>가격</th>
  </tr>
  <c:set var="preOrderNo" value="-1"/> 
  <c:forEach items="${ordersList}" var="orders">
  
  <tr>
  	<c:choose>
    		<c:when test='${preOrderNo==orders.no}'>
    			<td colspan="6"></td>
    		</c:when>
    		<c:otherwise>
	    		<td> 	
			      <c:choose>
			        <c:when test='${orders.detail.result=="1"}'>
			        <span style="font-weight: bold; color: blue">${orders.no}</span>
			        (<input type="checkbox" name="result" value="${orders.no}"> 미처리)
			        </c:when>
			        <c:otherwise>
			          <span style="font-weight: bold; color: red">${orders.no}</span>
			          (<input type="checkbox" checked="checked" disabled="disabled">처리완료)
			        </c:otherwise>
			      </c:choose>
			    </td>
			    <td>${orders.member.name}</td> 
			    <td>${orders.member.zipNum}</td>
			    <td>${orders.member.address}</td>  
			    <td>${orders.member.phone}</td>
			    <td><fmt:formatDate value="${orders.orderDate}" /></td>
    		</c:otherwise>
	</c:choose>
    <td>${orders.detail.cart.product.name}</td>
    <td>${orders.detail.cart.quantity}</td> 
    <td><fmt:formatNumber value="${orders.detail.cart.product.salePrice * orders.detail.cart.quantity}" pattern="#,##0"/> </td>
  </tr>
  <c:set var="preOrderNo" value="${orders.no}"/>
  </c:forEach>
  </table>
  <input type="button" class="btn" style="width: 200px"
      value="주문처리(입금확인)" onClick="go_order_save()">
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>