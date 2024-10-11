<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layout/postheader.jsp" %>

<c:if test="${empty postlist}">
	<h1>게시물이 없습니다</h1>
	<a href="/insertpost">게시물 등록</a>
</c:if>

<c:foreach var="post" items="${postlist}">
  <div class="container mt-3">
    <div class="card">
       <div class="card-body">
          <h4 class="card-title">게시물</h4>
          <a href="#" class="btn btn-secondary">상세보기</a>
       </div>
    </div>
  </div>
</c:foreach>
  <%@ include file="./layout/footer.jsp" %>  