<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core : jstl에서 가장 많이 사용되는 태그 라이브러리(if, for,..) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String[] cityArr = {"서울", "인천", "부산", "대구"};

	pageContext.setAttribute("cArr",cityArr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<% for(String city : cityArr) { %>
		<li><%=city%></li>
		<% } %>
	</ul>
<hr>
	<ul>
									<!-- pageScope 생략 가능, ${cArr} -->				
		<c:forEach var="city" items="${pageScope.cArr}">
			<li>${city}</li>
		</c:forEach>
	</ul>
	<hr>
	<!-- localhost:8088/day06_JSTL/01_jstl/ex02.jsp?user=김길동 -->
	<c:if test="${param.user != null}">
		${param.user}님 안녕하세요!!
	</c:if>
	<hr>
	<fmt:formatNumber type="currency" value="${param.number}"/><br/>
	<fmt:formatNumber type="currency" currencyCode="KRW" value="${param.number}"/><br/>
	<fmt:formatNumber type="currency" currencySymbol="$" value="${param.number}"/><br/>
	<fmt:formatNumber type="number" value="${param.number}"/>
	<hr>
	<%
		pageContext.setAttribute("date", new Date());
	%>
	<fmt:formatDate value="${date}"/><br/><!-- 2024. 12. 30. -->
	<fmt:formatDate type="date" pattern="yy/MM/dd" value="${date}"/><br/><!-- 24/12/30 -->
	<fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${date}"/><br/><!-- 2024-12-30 -->
	<fmt:formatDate type="date" pattern="yyyy-MM-dd(E)" value="${date}"/><br/><!-- 2024-12-30(월) -->
	
</body>
</html>