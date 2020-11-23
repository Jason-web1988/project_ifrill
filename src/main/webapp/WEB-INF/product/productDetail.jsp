<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script type="text/javascript">
$(function(){
	alert("상품번호 no >> " + ${param.id})
	var contextPath = "<%=request.getContextPath()%>";
	var no=${param.id}
	$.get(contextPath+"/api/getProduct/"+no, 		/* 객방식호출 */
	function(json) {
		
			var sCont = "";
				sCont += "<tr>";
				sCont += "<td id='id'>" + json.no + "</a></td>";
				sCont += "<td>" + json.image + "</td>";
				/* sCont += "<td><img src='" + product.image + "'></td>"; */
				sCont += "<td>" + json.name + "</td>";
				sCont += "<td>" + json.salePrice + "</td>";
				sCont += "</tr>";
			
		alert("선택하신 상품명은  " + "[" + json.name + "]"+ " 입니다.");
			 $("#load").append(sCont);
		}
	); 
		
});
</script>
</head>
<body>
<%@ include file="../header.jsp" %> 
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>  

<article>
 <h1> Item </h1>
    <div id="itemdetail" >
      <form  method="post" id="cartform">  
        
        <fieldset>
          <legend> Item detail Info</legend>  
            <span style="float: left;">
            	<img src="product_images/${product.image}"  /> 
            </span>              
            <h2> ${product.name} </h2>  
          </a>    
          <label> 가 격 :  </label>  
          <p> ${product.salePrice} 원</p>  
          <label> 수 량 : </label>
          <input  type="number"      id="quantity" name="quantity"  size="2"      value="1"><br>
          <input  type="hidden"    name="no"       value="${product.no}"><br>
        </fieldset>
        <div class="clear"></div>
        
        <div id="buttons">
          <input type="button" value="장바구니에 담기"   id="gocart" class="submit" > 
          <input type="button" value="즉시 구매"       id="goorder" class="submit" > 
          <input type="reset"  value="취소"           class="cancel">
        </div>
      </form>  
    </div>
  </article>
  
 <%@ include file="../footer.jsp" %> 
</body>
</html>