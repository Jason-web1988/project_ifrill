<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
    <div id="bestProduct">         
      <c:forEach items="${newProductList }"  var="product">
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