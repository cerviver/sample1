<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
* {box-sizing: border-box}

/* Full-width input fields */
  input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

.deletebtn {
  padding: 14px 20px;
  background-color: black;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
    width: 100%;
  }
}
</style>
<script type="text/javascript">
function modifyUser() {
	if(confirm("정말로 수정하시겠습니까")){
		f.action = "${pageContext.request.contextPath}/mypage_modify?userId=${modiUser.userId}";
		f.submit();
	};
}

function deleteUser(userId) {
	if(confirm("회원정보를 정말 삭제하시겠습니까")){
		f.action = "${pageContext.request.contextPath}/remove_user?userId="+userId;
		f.submit();
	};
}
</script>

<body>
<div id="id01" class="modal">
  <form class="modal-content" method="post" name="f">
    <div class="container">
      <h1>회원정보수정</h1>
      <hr>
      <label for="id"><b>아이디 : ${userinfo.userId }</b></label>
      <hr>
      
      <label for="password"><b>비밀번호</b></label>
      <input type="password" id="userPassword" name="userPassword" value="${userinfo.userPassword }">
      
      <label for="name"><b>이름</b></label>
      <input type="text" id="userName" name="userName" value="${userinfo.userName }">

      <label for="email"><b>이메일</b></label>
      <input type="text" id="userEmail" name="userEmail" value="${userinfo.userEmail }">

      <label for="address"><b>주소</b></label>
      <input type="text" id="userAddress" name="userAddress" value="${userinfo.userAddress }">

      <label for="phone"><b>전화번호</b></label>
      <input type="text" id="userPhone" name="userPhone" value="${userinfo.userPhone }">

      <div class="clearfix">
        <button type="button" onclick="location.href='${pageContext.request.contextPath}/home';" class="cancelbtn" style="width: 33.3%">취소</button>
        <button type="button" onclick="modifyUser()" class="signupbtn" style="width: 33.3%" >정보수정</button>
        <c:if test="${loginUser.userId!='admin' && userinfo.userId!='admin'}">
        <button type="button" onclick="deleteUser('${userinfo.userId}')" class="deletebtn" style="width: 33.3%" >삭제하기</button>
        </c:if>
      </div>
    </div>
  </form>
</div>

</body>
</html>
