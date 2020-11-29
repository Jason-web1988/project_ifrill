<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<%@ include file="../product/sub_img.html"%> 
<%@ include file="../product/sub_menu.jsp" %>   
  <article>
      <h2> 1:1 고객 게시판 </h2>
      <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    
    <form name="formm" method="post">
    <table id="notice">
      <tr>
              <th>제목</th>
              <td>${qna.subject}</td> 
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${qna.writeDate}" type="date"/></td>
      </tr>
      <tr>
        <th>질문내용</th>
        <td>${qna.content} 
      </tr>
      <tr>
        <th>답변 내용</th>
        <td>${qna.rep}  
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons" style="float:right">
      <input type="button"  value="목록보기"     class="submit"  onclick="location.href='qnaList'"> 
      <input type="button"  value="쇼핑 계속하기"  class="cancel"  onclick="location.href='main'">  
      </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>