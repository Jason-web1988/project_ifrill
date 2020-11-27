<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">
$(function(){
    $('.qnaDetail').on("click", function(){
        alert($(this).data('href'));
        $('input[name="no"]').val($(this).data('href'));
        $("#frm").attr("action", "adminQnADetail.do");
    	$('#frm').submit();
    });
});
</script>

<article>
<h1>Q&amp;A 게시글 리스트</h1>  
<form id="frm" method="post">
<input type="hidden" name="no">  
<table id="qnaList">
  <colgroup>
	<col style="width:100px;">
    <col style="width:500px;">
    <col style="width:200px;">
    <col style="width:100px;">
  </colgroup>
  <tr>
    <th>번호(답변여부)</th> <th>제목</th> <th>작성자</th> <th>작성일</th>    
  </tr>
  <c:forEach items="${qnaList}" var="qna">  
      <tr>
      <td>
      ${qna.no}  
      <c:choose>          
        <c:when test='${qna.repYN=="1"}'>(미처리)</c:when>
        <c:otherwise>(답변처리완료)</c:otherwise>
      </c:choose>      
      </td>
      <td> 
      <a href="#" class="qnaDetail" data-href="${qna.no}">
        ${qna.subject} 
      </a>
      </td>
      <td> ${qna.id} </td>
      <td> <fmt:formatDate value="${qna.writeDate}"/></td>
      </tr>
    </c:forEach>
    </table>
    </form>    
  </article>
  <%@ include file="../footer.jsp"%>
</body>
</html>