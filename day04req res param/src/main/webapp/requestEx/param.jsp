<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post방식으로 전송되는 한글은 인코딩을 지정하지 않으면 깨짐
	request.setCharacterEncoding("utf-8");

	String[] hbs= request.getParameterValues("hobby");
	
	String str = "";
	if(hbs != null){
		for(int i=0; i<hbs.length; i++){
			str += hbs[i] + " ";
		}
	}
	
	String reply = request.getParameter("reply").replace("\r\n", "<br/>");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>아이디 : <%=request.getParameter("id") %></li>
		<li>비밀번호 : <%=request.getParameter("pw") %></li>
		<li>과목명 : <%=request.getParameter("kor") %></li>
		<li>성별 : <%=request.getParameter("gender") %></li>
		<li>취미 : <%= hbs.length %>개, <%=str %></li>
		<li>댓글 : <%= reply %></li>
	</ul>
</body>
</html>