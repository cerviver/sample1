<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Navigation bar with social media icons -->
<div class="w3-bar w3-black w3-hide-small">
	<%-- 비로그인 상태  --%>
	<c:choose>
	<c:when test="${empty(loginUser) }">
	<a href="${pageContext.request.contextPath }/login" class="w3-bar-item w3-button">로그인</a>
	<a href="${pageContext.request.contextPath }/signup" class="w3-bar-item w3-button">회원가입</a>
	</c:when>
	
	<%-- 로그인 상태 --%>
	<c:otherwise>
	<a class="w3-bar-item w3-button" href="${pageContext.request.contextPath }/home">${loginUser.userName} 님 환영합니다.</a>
	<a href="${pageContext.request.contextPath }/logout" class="w3-bar-item w3-button">로그아웃</a>
	<c:if test="${loginUser.userId!='admin' || loginUser.userGrade!='9' }">
	<a href="${pageContext.request.contextPath }/mypage?userId=${loginUser.userId}" class="w3-bar-item w3-button">회원정보</a>
	</c:if>
	<a href="${pageContext.request.contextPath }/comment" class="w3-bar-item w3-button">내게시글 보기</a>
	<c:if test="${loginUser.userId=='admin' }">
	<a href="${pageContext.request.contextPath }/allUser" class="w3-bar-item w3-button">회원정보 보기</a>
	</c:if>
	</c:otherwise>
	</c:choose>
</div>