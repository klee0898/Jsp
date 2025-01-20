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
	제목 : ${requestScope.title}<br/>
	<!-- 
		http://localhost:8088/day10_fileUpload/upload.jsp
		
		위의 url에서 contextPath는 /day10_fileUpload
	 -->
	<%-- #1.스크립트릿
	 <img src="<%=request.getContextPath()%>/uploadedFile/${requestScope.fileName}"/> --%>
	<%-- #2. EL  	
		<img src="${pageContext.request.contextPath}/uploadedFile/${requestScope.fileName}"/> 
	--%>

	<!-- #3. JSTL core 라이브러리 사용 
	자동으로 contextPath를 지정-->
	<img src="<c:url value='/uploadedFile/${requestScope.fileName}'/>"/>
</body>
</html>