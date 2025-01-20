<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form action="login.do" class="w-75 shadow p-5 rounded mx-auto" method="post">
   <h2>로그인</h2>
   <div class="mb-3 mt-3">
      <input type="text" class="form-control" id="email" 
         placeholder="이메일" name="email"/>
   </div>
   <div class="mb-3 mt-3">      
      <input type="password" class="form-control" id="pwd" 
         placeholder="비밀번호" name="pwd"/>
   </div>
   <button type="submit" class="btn btn-primary">로그인</button>
</form>