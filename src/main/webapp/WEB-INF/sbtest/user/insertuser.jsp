<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container mt-3">	
	<form method="post" action="/insertuser">
	  <div class ="row">
		  <div class="col">
		    <label for="exampleInputPassword1" class="form-label">Username</label>
		    <input type="text" class="form-control" id="username" name ="username">
		  </div>
		  <div class="col">
		    <button id="btn-check" type="button" class="btn btn-success">Check</button>
		   </div>
	   </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Password</label>
	    <input type="password" class="form-control" id="password" name="password">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email address</label>
	    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
	  </div>
	  <button id="btn-insert" type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<script src="js/user.js"></script>	
<%@ include file="../layout/footer.jsp" %>