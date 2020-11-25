<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item</title>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var contextPath = "<%=request.getContextPath()%>";
	alert("상품종류 번호는 >> " + ${param.kind});
	var kind = ${param.kind};
	
	function numberFormat(inputNumber){		//천단위 ","해주기
         return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }
	
	 $.get(contextPath+"/api/kindProducts/"+ kind , function(json){
		 alert("json >> " + json);
		var dataLength = json.length;
		if (dataLength >= 1) {
			var sCont = "";
			for (i = 0; i < dataLength; i++) {
				sCont += "<td><a href ='productDetail?id=" + json[i].no + "'>" + "<img src= "+ json[i].image + ">" + "</a>";
				/* sCont += "<td><a href ='read?id=" + json[i].no + "'>" + json[i].no + "</a></td>"; */
				sCont += "<a href ='productDetail?id=" + json[i].no + "'>"+ json[i].name + "</a>"; 
				sCont +="  ";
				sCont += "<a href ='productDetail?id=" + json[i].no + "'>" + numberFormat(json[i].salePrice) + "</a></td>";
			}
			$("#kindProducts:last-child").append(sCont); 
		 };
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
      <div id="item">
      	<table>
      		<thead>
      		</thead>
      		<tbody id="kindProducts"></tbody>
      	</table>
      </div>
    <div class="clear"></div>
  </article>
<%@ include file="../footer.jsp" %>   
</body>
</html>