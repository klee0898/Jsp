<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<!-- 페이지내에 여러 스코프가 있는 경우
			유효범위가 가장 작은 작은 스코프가 생략될 수 있다.
			
			될수 있으면 스코프는 생략하지 않는 것이 좋다.
		  -->
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
</body>
</html>