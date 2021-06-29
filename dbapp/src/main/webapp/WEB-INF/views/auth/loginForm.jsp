<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>


<div class="container">
  <h1>로그인창</h1>
<form action="/">
  <div class="form-group">
    <label for="username">username:</label>
    <input type="text" class="form-control" placeholder="Enter email" name="username">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd">
  </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox">
    </label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<%@ include file="../layout/footer.jsp" %>