<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Shop</title>
<link href="resources/css/shopping.css" rel="stylesheet">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var contextPath = "<%=request.getContextPath()%>";
	$.get(contextPath+"/api/kindList", function(json){
	    var dataLength = json.length;
	    if ( dataLength >=1 ){
	        var sCont = "<ul>";
	        for ( i=0 ; i < dataLength ; i++){
	            sCont += "<li><a href=productKind?no=" + json[i].no + ">" + json[i].name + "</a></li>";
	        }
	        sCont += "</ul>";
	         if ($("#top_menu").has("ul").length < 1){    
	            $("#top_menu").append(sCont); 
	        }
	        if ($("#sub_menu").has("ul").length < 1){
	            $("#sub_menu").append(sCont);
	        } 
	    } 
	}); 
});
  </script>
</head>

<body>
<div id="wrap">
<!--헤더파일 들어가는 곳 시작 -->
  <header>
    <!--로고 들어가는 곳 시작--->  
    <div id="logo">
      <a href="main">
        <img src="images/logo.gif" width="180" height="100" alt="nonageshop">
      </a>  
    </div>
    <!--로고 들어가는 곳 끝-->     
    <nav id="catagory_menu">
     <ul>
       <c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       <li>         
         <a href="loginform.do" style="width:110px;">LOGIN(CUSTOMER</a>   
	     <a href="adminLoginForm.do" style="width:100px;">| ADMIN)</a>
	   </li>		       
       <li>/</li>
       <li><a href="contract.do">JOIN</a></li>
       </c:when>
       <c:otherwise>
       <li style="color:orange">
         ${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
       </li>
       <li><a href="logout.do">LOGOUT</a></li>
       </c:otherwise>       
       </c:choose>
       <li>/</li>
       <li>
         <a href="cartList.do">CART</a>
       </li><li>/</li>
       <li>
         <a href="mypage">MY PAGE</a>
       </li><li>/</li>
       <li>
         <a href="qnaList.do">Q&amp;A(1:1)</a>
       </li>
     </ul>
    </nav>

    <nav id="top_menu">
    </nav>
    <div class="clear"></div>
    <hr>
  </header>
  <!--헤더파일 들어가는 곳 끝 -->