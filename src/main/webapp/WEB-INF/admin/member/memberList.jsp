<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">
    $(function() {
        $('#search').on("click", function() {
            $("#frm").attr("action", "adminMemberList.do");
            $('#frm').submit();
        });
    });
</script>

<article>
<h1>회원리스트</h1>  
<form id="frm" method="post">
<table style="float:right; ">
  <tr>
  <td> 
  회원 이름
  <input type="text" name="key">
  <input class="btn" id="search" type="button" value="검색">
  </td>
  </tr>
</table>  
<br>
<table id="orderList">
  <tr>
    <th> 아이디(탈퇴여부) </th>    <th> 이름 </th>
    <th> 이메일 </th>             <th> 우편번호 </th>  
    <th> 주소 </th>  <th> 전화 </th>  <th> 가입일 </th>
  </tr>
  <c:forEach items="${memberList}" var="member">  
  <tr>
    <td>${member.id} 
    <c:choose>
      <c:when test='${member.leave_yn=="y"}'>
        <input type="checkbox" name="leave_yn" disabled="disabled">
      </c:when>
      <c:otherwise>
        <input type="checkbox" name="leave_yn" checked="checked" disabled="disabled">
      </c:otherwise>
    </c:choose>
    </td>
    <td> ${member.name} </td>
    <td> ${member.email} </td> 
    <td> ${member.zipNum} </td>
    <td> ${member.address} </td>
    <td> ${member.phone} </td> 
    <td> <fmt:formatDate value="${member.joinDate}"/></td>
  </tr>
  </c:forEach>
</table>
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>