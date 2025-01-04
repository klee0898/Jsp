<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>과일리스트</h1>
	<ul>
		<c:forEach var="fruit" items="${requestScope.lists}">
			<li>${fruit}</li>
		</c:forEach>
	</ul>
</body>
</html>