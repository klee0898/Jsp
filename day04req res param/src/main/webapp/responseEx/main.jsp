<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.jsp" method="post">
		아이디 : <input type="text" name="uid"><br/>
		비밀번호 : <input type="password" name="pw">
<%
	String loginErr = request.getParameter("loginErr");

	// 인증 실패시
	if(loginErr !=null){
		out.print("<p style='color:red; font-size:11px;'>아이디와 비밀번호를 다시 입력하시오!!</p>");
	}
%>
		
		<input type="submit" value="로그인">
	</form>
</body>
</html>