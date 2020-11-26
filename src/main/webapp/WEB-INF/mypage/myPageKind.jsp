<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info</title>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var contextPath = "<%=request.getContextPath()%>";
		alert("선택한 메뉴는 >> " + ${param.kind});
		var kind = ${param.kind};
		
		$.get(contextPath+"/api/")
		
	});
</script>
</head>
<body>

</body>
</html>