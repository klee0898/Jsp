<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="./inc/header.jsp"/>
<%-- <%@ include file="./inc/header.jsp" %> --%>

<!--------------------------- content ------------------------->  
<div class="container mt-5">
  <div class="row">
    <!-------------------- aside Start----------------------->
    <jsp:include page="./inc/aside.jsp"/>
    <!-------------------- aside End------------------------->
    <div class="col-md-9">
		 <%-- <jsp:include page="${pg}"/--%>
		 <jsp:include page="${requestScope.pg}"/>
    </div>
  </div>
</div>

<!--------------------------- footer -------------------------> 
<jsp:include page="./inc/footer.jsp"/>
