<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//fwController의 reqeust객체를 공유하기 때문에 dto 객체를 가져올 수 있음.
	
	// 포워딩은 url주소가 안바뀜

	// 바인딩된 객체 가져오기(타입이 Object된다.)
	// request.getAttribute("키");

	// 명시적 캐스팅을 해줘야 함.
	MemberDTO dto = (MemberDTO)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=dto.getUserName() %>
	<%=dto.getAge() %>
	<%=dto.getAddr() %>
</body>
</html>