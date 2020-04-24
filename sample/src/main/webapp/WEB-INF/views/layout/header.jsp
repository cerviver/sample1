<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Navigation bar with social media icons -->
<div class="w3-bar w3-black w3-hide-small">
  <a href="${pageContext.request.contextPath }/login" class="w3-bar-item w3-button">로그인</a>
  <a href="#" class="w3-bar-item w3-button">로그아웃</a>
  <a href="${pageContext.request.contextPath }/signup" class="w3-bar-item w3-button">회원가입</a>
  <a href="#" class="w3-bar-item w3-button">회원정보</a>
  <a href="#" class="w3-bar-item w3-button">내게시글 보기</a>
</div>