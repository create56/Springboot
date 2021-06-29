<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 절대경로가 아닌 상대경로한다. -->
<%@ include file="../layout/header.jsp" %>

<div class="container">
  <h1>회원가입창</h1>
<!-- submit를 하면 username=xxx&password=xxx&email=xxx&address=xxx -->
<form action="/auth/join" method="post">
 <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" class="form-control" placeholder="Enter username" name="username">
  </div>
  <div class="form-group">
    <label for="email">Email:</label>
    <input type="email" class="form-control" placeholder="Enter email" name="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" name="password">
  </div>
   <div class="form-group">
    <label for="address">Address:</label>
    <input type="text" class="form-control" placeholder="Enter address" name="address">
  </div>
  <button type="submit" class="btn btn-primary">회원가입</button>
</form>
</div>
<%@ include file="../layout/footer.jsp" %>