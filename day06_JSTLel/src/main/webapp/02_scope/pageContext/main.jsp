<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	pageContext.setAttribute("intVal", 1000);
	pageContext.setAttribute("strVal", "문자열");
	pageContext.setAttribute("member", new Member("홍길동", "33"));	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int intVal = (int)pageContext.getAttribute("intVal");
	String strVal = (String)pageContext.getAttribute("strVal");
	Member member = (Member)pageContext.getAttribute("member");
%>
<li>intVal : <%=intVal%></li>
<li>strVal : <%=strVal%></li>
<li>member : <%=member.getUserName()%>, <%=member.getAge()%></li>
<hr>
<li>intVal : ${pageScope.intVal}</li>
<!-- pageScope 생략 가능 -->	
<li>strVal : ${strVal}</li>	
<li>member : ${member.userName}, ${member.age}</li>	
<hr>
<a href="next.jsp">다음 페이지</a>
</body>
</html>