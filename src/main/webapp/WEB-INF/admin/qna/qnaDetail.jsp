<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">
$(function(){
	$('#qnalist').on("click",function(){
		$("#frm").attr("action", "adminQnAList.do");
		$('#frm').submit();
	});
	
	$('#qnasave').on("click",function(){
	    $('input[name="no"]').val($(this).data('no'));
		$("#frm").attr("action", "adminQnARepSave.do");
		$('#frm').submit();
	});
});
   
</script>
<article>
<h1>Q&amp;A 게시판</h1>   
<form id="frm" name="frm" method="post">
<input type="hidden" name="no">
<table id="qnaList">
    <tr>
        <th width="20%">제목</th>
        <td> ${qna.subject}</td>
    </tr>
   <tr>
         <th>등록일</th>
         <td> <fmt:formatDate value="${qna.writeDate}"/> </td>  
    </tr>
    <tr>
        <th>내용</th>
        <td> ${qna.content}</td>  
    </tr>
</table>
<c:choose>          
  <c:when test='${qna.repYN=="1"}'>
  <table id="orderList">
      <tr>
          <td colspan="2">
      <img src="admin/images/opinionimg01.gif">
      </td>
      </tr>
    <tr>
          <td colspan="2">    
      <textarea name="reply" rows="3" cols="50"></textarea>
      <input type="button" id="qnasave" class="btn" value="저장" data-no="${qna.no}")>    
      </td>
      </tr>
  </table>
  <br>
  </c:when>
  <c:otherwise>  
  <table id="orderList">
    <tr>
     <th>댓글</th>
     <td> ${qna.rep}</td>
    </tr>
  </table>
  </c:otherwise>
</c:choose>    
<input type="button" id="qnalist" class="btn" value="목록">
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>