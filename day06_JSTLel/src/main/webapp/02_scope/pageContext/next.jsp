<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object intVal = pageContext.getAttribute("intVal");
	String strVal = (String)pageContext.getAttribute("strVal");
	Member member = (Member)pageContext.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<li>intVal : <%= (intVal == null) ? "null값" :intVal%></li>
<li>strVal : <%= (strVal == null) ? "null값" :strVal%></li>
<li>member : <%= (member == null) ? "null값" : member.getUserName() %></li>
</body>
</html>