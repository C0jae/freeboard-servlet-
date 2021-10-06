<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 페이지 요청 오류</title>
<style type="text/css">
	a {
		text-decoration: none;
		height: 35px;
		width: 120px;
		margin:30px;
		color: gray;
		text-align: center;
		border: 1px solid gray;
		padding: 10px 15px;
	}
	
	.center {
		/* margin:auto; */
	}
</style>
</head>
<body>
	<div style="width:50%; margin:auto; padding-top:10%">
	
		<div style="width:50%">
			<img alt="404status" src="../img/icon_error.png">
				<!-- alt : 이미지가 나오지 않을때 출력되는 텍스트 -->
		</div>
		
		<h3 class="center">요청하신 페이지를 찾을 수 없습니다.</h3>
		<div class="center">
			<a href="${pageContext.request.contextPath }">HOME</a>	<!-- jsp2로만 경로저장된 home으로 이동 -->
			<a href="javascript:history.back()">뒤로가기</a>
			<!-- 상대경로 : 현재위치를 기준으로 ../ 또는 ./ 또는 경로명/ 
				 절대경로 : 이 애플리케이션의 context를 기준으로 한다.
			-->
		</div>
	</div>
</body>
</html>