<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
		<nav>   <!-- 의미(semantic)가 있는 태그 -->
            <ul class="container">
                <li><a class="menu" href="list.do">Community</a></li>
                <li><a class="menu" href="">Instagram</a></li>
                <li><a class="menu" href="">Kakao</a></li>
                <li><a class="menu" href="about.html">About</a></li>
                
                <li id="login">
                	<c:if test="${sessionScope.user == null}">
						<a href="login.do">로그인</a>
					</c:if>
	
					<c:if test="${sessionScope.user != null}">
					<!-- 로그인 상태 -->
					<br>${user.name}(${user.email}) 님 반갑습니다.<br>
					<a href="logout.do">로그아웃</a>
					</c:if>
					<a href="gallery.do">갤러리</a>
				</li>
            </ul>
        </nav>