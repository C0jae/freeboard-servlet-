<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day12 Gallery</title>

<style type="text/css">
	input {  padding: 10px; border: 1px solid gray; border-radius:5px;  }
	.thumbnail { padding-bottom: 5px; border:none; }
	.thumbnail img{ width:100%;height: 300px; object-fit:cover; margin-bottom: 10px;}
	.container {width:30%; float:left; padding:10px;border: none;}
</style>	<!-- 이미지를 다룰때 썸네일을 다루는 라이브러리가 따로 존재한다. -->

</head>
<body>
	<form action="regist.do" method="post" enctype="multipart/form-data">
		<input type="text" name="title" placeholder="제목을 입력하세요."> <br>
		<input type="file" name="pic" accept="image/*"
			placeholder="이미지파일을 선택하세요."> <br>
			<!-- accept="image/*" -> 이미지 파일만 선택할수있게 보인다. -->
		<input type="submit" value="전송">
	</form>
	
	<hr>	<!-- 업로드 결과 확인 : upload 폴더에 파일이 있는지, db table에 insert 되어있는지 -->
	<!-- 파일 업로드 전송을 한 후에 view를 gallery.jsp 로 하고 아래에 업로드 이미지가 나오도록 하기 -->
	
	<c:forEach var="item" items="${glist}">
		<div class="container">
			<div class="thumbnail">
				<img alt="gallery" src="/img/${item.filename}">	
				<!-- /img/는 url 경로, 이 경로와 e:\\upload와 매핑 필요 -> server.xml -->
			</div>
			<div>
				<strong>${item.title}</strong>
			</div>
		</div>
	</c:forEach>
	
	
</body>

<!-- 
server.xml에서 host 태그사이에 추가
<Context docBase="E:\Program\upload" path="/img" reloadable="true" />
-->

</html>