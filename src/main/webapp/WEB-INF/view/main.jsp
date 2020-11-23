<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
		var contextPath = "<%=request.getContextPath()%>";
	
		$.get(contextPath+"/api/newProducts", function(json) {
			var dataLength = json.length;
			if (dataLength >= 1) {
				var sCont = "";
				for (i = 0; i < dataLength; i++) {
					sCont += "<tr>";
					sCont += "<td>" + json[i].no + "</td>";
					sCont += "<td><a href ='read?id=" + json[i].no + "'>"+ json[i].name + "</a></td>";
					sCont += "<td>" + json[i].salePrice + "</td>";
					sCont += "<td>" + json[i].image + "</td>";
					sCont += "</tr>";
				}
				$("#load:last-child").append(sCont);
			}
		});
	});
</script>
</head>
<body>
<%@ include file="header.jsp" %>
 <!--메인 이미지 들어가는 곳 시작 --->
  <div class="clear"></div>
  <div id="main_img">
    <img src="images/main_img.jpg" >    
  </div>
  <!--메인 이미지 들어가는 곳 끝--->

  <div class="clear"></div>   

  <div id="front">   
    <h2> New Item</h2>     
    <div id="newProduct">    
     <%-- <c:forEach items="${bestProductList}"  var="product"> --%>
        
        <div id="item">
        <table>
        <thead>
        <tr>
        <th>번호</th>
        <th>이름</th>
        <th>가격</th>
        <th>이미지</th>
        </tr>
        </thead>
         <tbody id = load></tbody>
        </table>
   		 
          <a href="productDetail.do?no=${product.no}">
            <img src="product_images/${product.image}" />
            <h3> ${product.name} </h3>    
            <p>${product.salePrice} </p>
          </a>    
        </div>
        
         <%-- </c:forEach> --%>
    </div>
   <div class="clear"></div>
   
     
    <h2> Best Item</h2>     
      <div id="bestProduct">         
        <c:forEach items="${bestProductList}"  var="product">
          <div id="item">
           <a href="productDetail.do?no=${product.no}">
             <img src="product_images/${product.image}" />
           <h3> ${product.name} </h3>    
           <p>${product.salePrice} </p>
        </a>  
      </div>
    </c:forEach>      
  </div>
  <div class="clear"></div>
  </div>
    
<%@ include file="footer.jsp" %>    
</body>
</html>