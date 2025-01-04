<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="info.jsp?kor=90&eng=80">Get 방식</a>
	
	<!-- post 방식 -->
	<form action="info.jsp" method="post">
		국어 : <input type="text" name="kor"/>
		영어 : <input type="text" name="eng"/>
		<input type="submit" value="post방식"/>
	</form>
	<hr>
	<form action="param.jsp" method="post">
		국어 : <input type="text" name="kor" value="국어"/>
		아이디 : <input type="text" name="id" /><br/>
		비밀번호 : <input type="password" name="pw" /><br/>
		
		<hr/>
		<input type="radio" name="gender" value="male"> 남자
		<input type="radio" name="gender" value="female"> 여자
		<hr/>
		취미 : 
		<input type="checkbox" name="hobby" value="music"/>음악		     
		<input type="checkbox" name="hobby" value="sports"/>스포츠		     
		<input type="checkbox" name="hobby" value="movie"/>영화		     
		<input type="checkbox" name="hobby" value="tour"/>여행
		<hr/>
		댓글 :
		<textarea name="reply" cols="20" rows="3"></textarea>  
		<input type="submit" value="전송"/>
	</form>
</body>
</html>