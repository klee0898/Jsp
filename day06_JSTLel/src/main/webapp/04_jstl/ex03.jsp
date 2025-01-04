<%@page import="model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> list = new ArrayList<String>();
	list.add("java");
	list.add("python");
	list.add("C#");
	list.add("Spring");
	list.add("JSP");
	
	// Q> request에 객체바인딩후 EL 표현식으로 리스트 요소를 모두 출력하시오.
    //   (변수는 lang)
    
    request.setAttribute("list", list);
    
    // Q> Member 객체를 이용해서 강호동 33 생성후 request에 바인딩 합니다.
    Member member = new Member("강호동", "33");
    request.setAttribute("member", member);
    //    EL 표현식으로 이름과 나이를 모두 출력하시오.
    //
    
    Member member1 = new Member("홍길동", "44");
	Member member2 = new Member("홍길서", "33");
	Member member3 = new Member("홍길남", "22");
	Member member4 = new Member("홍길북", "11");
	
	List<Member> memberList = new ArrayList<>();
	memberList.add(member1);
	memberList.add(member2);
	memberList.add(member3);
	memberList.add(member4);	
	// Q> request로 바인딩 후 멤버 모두 테이블에 출력하시오. 
    request.setAttribute("memberList", memberList);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="lang" items="${requestScope.list}">
		${lang}
	</c:forEach>
	<hr>
	${requestScope.member.userName}, ${requestScope.member.age} <br/>
	<!-- getter 메소드를 호출한 것과 같다. -->
	${requestScope.member.getUserName()}, 
	${requestScope.member.getAge()}
	
	<hr>
		<table>
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach var="member" items="${requestScope.memberList}">
			<tr>
				<td>${member.userName}</td>
				<td>${member.age}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>