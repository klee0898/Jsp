<%@page import="model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	UserDTO dto = (UserDTO)request.getAttribute("user");
	
	String uid;
	if(dto !=null){
		uid = dto.getUid();
	}else{
		uid = request.getParameter("uid");	
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
        if (uid != null) { 
        	out.print(uid+"환영합니다.");
        } else{
        	out.print("웹사이트에 오신것을 환영합니다!!");
        }
    %>
</body>
</html>