<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String str = (String)request.getAttribute("strVal");
	//Member member = (Member)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Next Page</h2>
<li>${str}</li> <%-- "<% %>" 선언된 변수는 el에서 참조안됨 --%>
<li>${requestScope.strVal}</li>
<li>${requestScope.member.userName}</li>
<li>${requestScope.member.age}</li>
<hr>
<!-- requestScope 생략 -->
<li>${strVal}</li>
<li>${member.userName}</li>
<li>${member.age}</li>

</body>
</html>