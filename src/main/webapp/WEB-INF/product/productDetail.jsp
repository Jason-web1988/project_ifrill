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
	
	 function numberFormat(inputNumber){		//천단위 ","해주기
         return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }
	
	$.get(contextPath+"/api/getProduct/"+no, 		/* 객방식호출 */
	function(json) {
			var sContName = "";
				sContName = json.name;
			$("#name").append(sContName);
			
			var sContNo = "";
				sContNo = json.no;
			$("#no").append(sContNo);
			
			var sContImage = "";
				sContImage = "<img src=" + json.image + ">"; 
			$("#image").append(sContImage);	
			
			var sContPrice = "";
				sContPrice = numberFormat(json.price) + " 원";
			$("#price").append(sContPrice);	
				
		/* 	var sCont = "";
				sCont += "<tr>";
				sCont += "<td id='id'>" + json.no + "</a></td>";
				sCont += "<td><img src='" + product.image + "'></td>";
				sCont += "<td>" + json.name + "</td>";
				sCont += "<td>" + json.salePrice + "</td>";
				sCont += "</tr>"; */
			
		alert("선택하신 상품명은  " + "[" + json.name + "]"+ " 입니다.");
		}
	); 
	
	$('#cancel').on("click", function(e){
		e.preventDefault();
		window.location.href = contextPath + "/main";
	});
	
	$('#goCart').on("click", function(e){
		e.preventDefault();
	});	
	
	$('#goOrder').on("click", function(e){
		e.preventDefault();
	});	
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
            	<div id="image" ></div> 
            </span>              
            <h2 id="name"></h2>  
          <label> 가 격 :  </label>  
          <p id="price"></p>  
          <label> 수 량 : </label>
          <input  type="number"      id="quantity" name="quantity"  size="2"      value="1"><br>
          <input  type="hidden"    name="no"       value="${product.no}"><br>
        </fieldset>
        <div class="clear"></div>
        
        <div id="buttons">
          <input type="button" value="장바구니에 담기"   id="goCart" class="submit" > 
          <input type="button" value="즉시 구매"       id="goOrder" class="submit" > 
          <input type="reset"  value="취소"          id="cancel" class="cancel">
        </div>
      </form>  
    </div>
  </article>
  
 <%@ include file="../footer.jsp" %> 
</body>
</html>