<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	
	// id : test, pw:1212 인증성공
	if(uid.equals("test") && pw.equals("2521")){
		// index.jsp(홈페이지) 재요청
		response.sendRedirect("/day04/index.jsp");
	}else{
		// 인증 실패시 로그인페이지로 이동
		response.sendRedirect("main.jsp?loginErr=1");
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>