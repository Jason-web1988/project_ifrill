<%@page import="project_ifrill.dto.Worker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Admin</title>
<link rel="stylesheet" href="resources/css/admin.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script type="text/javascript">
$(function(){
	var contextPath = "<%=request.getContextPath()%>";
	
	$('#login').on("click", function(e){
		e.preventDefault();
		var data ={
				id : $('#workerId').val(),
				pwd : $('#workerPwd').val()
        };
	 	
        if($('#workerId').val().length==0){
            alert("아이디를 입력하세요.");
            document.getElementById("workerId").focus();
            return false;
        }else if($('#workerPwd').val().length==0){
           	alert("비밀번호를 입력하세요.");
           	document.getElementById("workerPwd").focus();
            return false;
        } 
		 alert("id >> "+ data.id + " ," + " pwd >> " + data.pwd); 
		 
		$.ajax({
			url : contextPath + "/worker/check",
			type:"post",
			contentType : "application/json; charset=utf-8",
			dataType : 'JSON',
			cache : false,
			data : JSON.stringify(data),
			success : function(res){
				alert(res);
				window.location.href=contextPath + "/adminProductList";
			},
			error : function(res){
				alert("비밀번호가 맞지 않습니다.");
				 document.getElementById("workerId").value ='';
				 document.getElementById("workerPwd").value ='';
			}
			
		}); 
	});
});
</script>
</head>
<body>
  <div id="wrap">
  <%@ include file = "header.jsp" %>
  
    <div class="clear"></div>
    <article>
      <div id="loginform">
      <form id="frm" method="post" action="adminProductList">
      <table>
        <tr>
          <td> 아 이 디 </td>
          <td> <input type="text" id="workerId" name="workerId" size="10" value="ADMIN"></td>
        </tr>
        <tr>
          <td> 비밀번호 </td>
          <td> 
            <input type="password" id="workerPwd" name="workerPwd" size="10" value="ADMIN">
          </td>
        </tr>
        <tr align="center" >
          <td  colspan="2">          
            <input class="btn" type="submit" id="login" value="업무 로그인"><br><br>
            <h4 style="color:red">${message}</h4>
          </td>
        </tr>
      </table>
      </form>
      </div>
    </article>
  </div>
</body>
</html>