<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
  <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){

	
	$('#goIPF').on("click", function(e){
		e.preventDefault();
	});
	
	$('#goJoin').on("click", function(e){
		return join.jsp
	});	
	
	$('#goLogin').on("click", function(e){
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
    <h1>Login</h1>
    <form method="post" action="/member/login">
        <fieldset>
        <legend></legend>
          <label>User ID</label>
          	<input name="id" type="text" value="${id}" value="one"><br> 
          <label>Password</label> 
          	<input name="pwd" type="password" value="1111"><br> 
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="로그인" id="goLogin" class="submit">
            <input type="button" value="회원가입" id="goJoin" class="cancel" onclick="location='join'">
            <input type="button" value="아이디 비밀번호 찾기" id="goIPF" class="submit" onclick="location='?command=find_id_form'">     
        </div>
    </form>  
  </article>
<%@ include file="../footer.jsp" %>
</body>
</html>      
