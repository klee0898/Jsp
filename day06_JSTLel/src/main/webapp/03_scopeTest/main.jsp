<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String key = "local변수";
	pageContext.setAttribute("key", "pageScope Value");
	request.setAttribute("key", "requestScope Value");
	session.setAttribute("key", "sessionScope Value");
	application.setAttribute("key", "application Value");
	
//	RequestDispatcher rd = request.getRequestDispatcher("next.jsp");
//  rd.forward(request, response);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>스크립트 표현식 : <%=key%></li>
		<!-- pageScope이 생략된 형태, 변수 key가 아님  -->
		<li>${key}</li> 
		<li>${pageScope.key}</li>
		<li>${requestScope.key}</li>
		<li>${sessionScope.key}</li>
		<li>${applicationScope.key}</li>
		<!-- http://localhost:8088/day06_JSTL/03_scopeTest/main.jsp?key=500 
			위의 쿼리스트링의 변수 key값을 EL표현식에서 받아오려면 param 객체를 사용한다.
		-->
		<li>${param.key}</li>
	</ul>
	<hr>
	<input type="button" value="페이지이동"
		onclick="location.href='next.jsp?key=param값'"/>
</body>
</html>