<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>

<article>
<h1>상품리스트</h1>	
<form id="frm" method="post">
<table>
  <tr>
  <td width="642">
      상품명 
     <input type="text" name="key">
     <input class="btn" type="button" id="btn_search" name="btn_search" value="검색" >
     <input class="btn" type="button" id="btn_total" name="btn_total" value="전체보기 " >
     <input class="btn" type="button" id="btn_write" value="상품등록" >
  </td>
  </tr>
</table>
<table id="productList">
    <tr>
        <th>번호</th><th>상품명</th><th>원가</th><th>판매가</th><th>등록일</th><th>사용유무</th>
    </tr>
    <c:choose>
    <c:when test="${productListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">등록된 상품이 없습니다.</td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${productList}" var="product">
    <tr>
      <td height="23" align="center" >${product.no}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="#" class="detail" data-info='["${tpage}", "${product.no}"]'>${product.name} </a>
   	  </td>
      <td><fmt:formatNumber value="${product.price}"/></td>
      <td><fmt:formatNumber value="${product.salePrice}"/></td>
      <td><fmt:formatDate value="${product.regDate}"/></td>
      <td>
      	<c:choose>
   	 		<c:when test='${product.delYn=="1"}'>미사용</c:when>
   	 		<c:otherwise>사용</c:otherwise>   	 		
   	 	</c:choose>	 
   	  </td> 
    </tr>
    </c:forEach>
    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
	</c:otherwise>	
</c:choose>  
</table>
</form> 
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>