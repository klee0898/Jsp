<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("strVal", "문자열");
	request.setAttribute("member", new Member("강길동", "22"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<li>${requestScope.strVal}</li>
<li>${requestScope.member.userName}</li>
<hr>
<h2>포워딩</h2>
<%
	RequestDispatcher rd = request.getRequestDispatcher("next.jsp");
	rd.forward(request, response);
%>
</body>
</html>