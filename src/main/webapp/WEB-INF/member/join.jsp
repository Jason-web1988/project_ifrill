<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>   
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>   
  <article>
    <h2>Join Us</h2>
    <form id="join" action="/member/join" method="post">
      <fieldset>
        <legend>Basic Info</legend>
        <label>User ID</label>
	        <input type="text"      id="id" name="id"        size="12"  >
	        <input type="button"    id="dup" value="중복 체크"  class="dup"><br>
        <label>Password</label> 
	        <input type="password"  id="pwd" name="pwd"><br> 
	        <label>Retype Password</label> 
	        <input type="password"  id="pwdCheck" name="pwdCheck"><br> 
        <label>Name</label>
        	<input type="text"      id="name" name="name"><br> 
        <label>E-Mail</label>
        	<input type="email"      id="email" name="email"><br>
      </fieldset>
      <fieldset>
        <legend>Optional</legend>
        <label>Zip Code</label> 
	        <input type="text"       id="zipNum" name="zipNum"   size="10" >      
	        <input type="button"     id="findZipNum" value="주소 찾기" class="dup"><br>
        <label>Address</label> 
	        <input type="text"       id="addr1" name="addr1"   size="50">
	    <label></label>
			<input type="text"       id="addr2" name="addr2"   size="25"> <br>
	    <label>Phone Number</label> 
	        <input  type="tel"       name="phone"><br>
      </fieldset>
      <div class="clear"></div>
      <div id="buttons">
        <input type="button" id="reg" value="회원가입"   class="submit"> 
        <input type="reset"  value="취소" class="cancel">
      </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>