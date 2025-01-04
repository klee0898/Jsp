<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String data = request.getParameter("data");
	String userName = request.getParameter("userName");
	String age = request.getParameter("age");  
	
/* 	MemberDTO dto= (MemberDTO)request.getAttribute("member"); */

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>컨트롤러에서 전송된 값</h2>
	<%-- <%=dto.getUserName() %>
	<%=dto.getAge() %> --%>
 	<%=data%>
	<%=userName%>
	<%=age%> 
</body>
</html>