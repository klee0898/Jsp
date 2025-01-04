<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core : jstl에서 가장 많이 사용되는 태그 라이브러리(if, for,..) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 변수 선언 -->
<%
	int aa = 200;
%>
<c:set var="aa" value="100"/> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
jsp 기존 문법 : <%=aa%><br/>
el 표현식 : ${aa}, ${aa > 50}, ${aa + 100}
<hr>
<!-- test = 조건식 -->
<c:if test="${aa%2 == 0}">
	짝수
</c:if>
<c:if test="${aa%2 != 0}">
	홀수
</c:if>
<hr>
<!-- choose : switch문과 비슷 -->
<c:choose>
	<c:when test="${aa%2 == 0}">짝</c:when>
	<c:when test="${aa%2 != 0}">홀</c:when>
	<c:otherwise>일치하는 when이 없음.</c:otherwise>
</c:choose>
<hr>
<!-- 반복문 -->
<c:forEach var="i" begin="1" end="6" step="1">
	<h${i}>하이</h${i}>
</c:forEach>
</body>
</html>