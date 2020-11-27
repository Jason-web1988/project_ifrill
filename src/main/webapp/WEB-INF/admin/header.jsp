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

<%--<script type="text/javascript" src="admin/product/product.js"></script>
  <c:choose>
	<c:when test="${empty workerId}">
		<script type="text/javascript">
			location.href = 'adminLoginForm.do';
		</script>
	</c:when>
</c:choose>  --%>

</head>
<body >
	<div id="wrap">
		<header>			
			<div id="logo">
				<a href="adminMain"> 
					<img style="width:800px" src="admin/images/bar_01.gif">
					<img src="admin/images/text.gif">
				</a>
			</div>	
			<input class="btn" type="button"  value="logout"  style="float: right;"  onClick="location.href='adminMain'">			
		</header>
		<div class="clear"></div>