<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 border shadow p-5">
   <h1>관리자 로그인</h1>
   <form action="adminLoginOk.do" method="post">
      <div class="mt-3 mb-3">
         <label for="id">아이디</label>
         <input type="text" class="form-control" id="id" placeholder="아이디"
            name="id">      
      </div>
      <div class="mb-3">
         <label for="id">비밀번호</label>
         <input type="text" class="form-control" id="pwd" placeholder="비밀번호"
            name="pwd">         
      </div>
      <div class="text-center">
         <button type="submit" class="btn btn-primary">로그인</button>
      </div>
   </form>
</div> 
</body>
</html>