<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리커뮤니티 :: 자유게시판</title>
<link rel="stylesheet" href="css/flexbox2.css?v=3">
</head>
<body>

<%@ include file="top.jsp" %>
<!-- 
	아래의 section 태그 내용은 웹사이트 초기화면으로 이미지, 주요 홍보영상, Quick Link 주요 게시물 등을
	포함하도록 수정
 -->
<section>
	<!-- 처음 요청이 들어오는 home.jsp에서 session에 readIdx를 저장한다. -->
	<c:if test="${sessionScope.readIdx == null }">
		<%
			StringBuilder readIdx = new StringBuilder("/");
			session.setAttribute("readIdx", readIdx);
		%>
	</c:if>
	
	<a href="list.do">커뮤니티 게시판</a>
	<c:if test="${sessionScope.user == null}">
		<a href="login.do">로그인</a>
	</c:if>
	
	<c:if test="${sessionScope.user != null}">
		<!-- 로그인 상태 -->
		<br>${user.name}(${user.email}) 님 반갑습니다.<br>
		<a href="logout.do">로그아웃</a>
	</c:if>
	<a href="gallery.do">갤러리</a>
</section>
<%@ include file="bottom.jsp" %>
</body>
</html>