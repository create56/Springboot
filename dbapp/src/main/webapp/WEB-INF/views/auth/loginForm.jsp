<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<div class="container">
  <h1>로그인창</h1>
<form action="/auth/login" method="post">
  <div class="form-group">
    <label for="username">username:</label>
    <input type="text" class="form-control" placeholder="Enter username" name="username" required="required"/>
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" name="password" required="required"/>
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
</form>
</div>

<%@ include file="../layout/footer.jsp" %>