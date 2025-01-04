<%@page import="util.MyUtil"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 핵심기능(비즈니스 로직)
/* 	int sum=0;
	for(int i=1;i<=10;i++){
		sum +=i;
	} */
	// import 단축키 : ctrl + space
	MyUtil mu= new MyUtil();
	int sum = mu.add();
%>  

<!-- 사용자에게 보여주는 로직(프리젠테이션 로직) : View -->  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{ border:1px solid red;}
</style>
</head>
<body>
	<table>
		<tr>
			<td>1~ 10까지의 합계</td>
		</tr>
		<tr>
			<td><%=sum%></td>
		</tr>
	</table>
</body>
</html>