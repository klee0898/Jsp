<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="col-md-3 border">
      <h5>현재 접속자 수 : ${applicationScope.activeCnt}</h5>
      <ul class="nav nav-pills">
         <li class="nav-item">
         <c:if test="${sessionScope.email == null}">
            <a href="loginForm.do" class="nav-link active">로그인</a>
         </c:if>
         <c:if test="${sessionScope.email != null}">
            <a href="logout.do" class="nav-link active">로그아웃</a>
         </c:if>
         </li>
      </ul>
    </div>