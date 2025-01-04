<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 주석 --%>
<%! // 선언문
	public int substract(int x, int y){
		return x - y;
	}
%>

<%
	int sum=0;
	for(int i=1; i<=100; i++){
		sum += i;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li> 합계 : <%=sum %></li>
		<li><%=substract(100, 10) %></li>
	</ul>
</body>
</html>