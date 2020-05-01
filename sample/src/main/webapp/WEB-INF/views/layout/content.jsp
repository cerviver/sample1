<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
.mainsize {
	max-width: 1000px;
	margin: auto;
}

#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

<div class="mainsize">
	<table id="customers">
		<thead>
			<tr>
				<th>제목</th>
				<th>작성자(아이디)</th>
				<th>작성일</th>
				<th>조회수</th>
		 	</tr>
	 	</thead>
	 	
	 	<tbody>
	 		<tr>
	 			<td></td>
	 			<td>
	 				<a href="">
	 					
	 				</a>
	 			</td>
	 			<td></td>
	 			<td></td>
	 		</tr>
	 	</tbody>
	</table>
	<c:if test="${not empty(loginUser) }">
	<div>
		<button type="button">
			글쓰기
		</button>
	</div>
	</c:if>
</div>
</body>
</html>