<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Item</title>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var contextPath = "<%=request.getContextPath()%>";
	
	 function numberFormat(inputNumber){		//천단위 ","해주기
         return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }
	 $.get(contextPath + "/api/getProduct/"+no, function(json){
		 var dataLength = json.length;
		 if(dataLength >= 1){
			 var sCont = "<ul>";
			 
		 }
	 });
});

</script>
</head>
<body>
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>  
  <article>
    <h2> Item</h2>     
    <c:forEach items="${productKindList }"  var="product">
      <div id="item">
        <a href="productDetail.do?no=${product.no}"> 
          <img src="product_images/${product.image}" />
          <h3>${product.name} </h3>        
          <p>${product.salePrice} </p>
        </a>  
      </div>
    </c:forEach>    
    <div class="clear"></div>
  </article>
<%@ include file="../footer.jsp" %>   
</body>
</html>