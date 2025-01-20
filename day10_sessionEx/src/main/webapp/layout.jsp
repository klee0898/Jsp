<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap 5 Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
     .fakeImg {
        height:200px; background: #aaa;
     }
  </style>
</head>
<body>
<!--------------------------- header -------------------------> 
<div class="container-fluid p-5 bg-primary text-white text-center">
  <h1>Java Web 개발</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="#">Active</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
  </div>
</nav>


<!--------------------------- content ------------------------->  
<div class="container mt-5">
  <div class="row">
    <!-------------------- aside Start----------------------->
    <div class="col-md-3 border">
      <h5>현재 접속자 수 : </h5>
      <ul class="nav nav-pills">
         <li class="nav-item">
            <a class="nav-link active">로그인</a>
         </li>
      </ul>
    </div>
    <!-------------------- aside End------------------------->
    <div class="col-md-9">
      <h3>Welcome To Page</h3>        
      <h5>23. 10. 16</h5>
      <div class="fakeImg">Fake Image</div>
      <p>환영합니다......</p>
    </div>
  </div>
</div>
<!--------------------------- footer -------------------------> 
<div class = "mt-5 p-3 bg-dark text-white text-center">
   <p>Footer</p>
</div>
</body>
</html>
