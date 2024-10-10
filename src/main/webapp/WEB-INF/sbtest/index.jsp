<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "./layout/header.jsp" %>
	<h2>${sessionScope.principal.username}</h2>
	<h1>Index Page</h1>
<%@ include file = "./layout/footer.jsp" %>