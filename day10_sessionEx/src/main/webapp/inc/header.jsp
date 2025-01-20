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
    <ul class="navbar-nav w-100">
      <li class="nav-item">
        <a class="nav-link active" href="#">Active</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
     <!--   <li class="nav-item">-->
      <li class="nav-item me-auto">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item ms-auto">
        <!-- <a class="nav-link " href="#">Disabled</a> -->
        <a class="nav-link " href="#">
        	${sessionScope.email !=null ? email : "GUEST"} have a great day to you!!
        </a>
      </li>
    </ul>
  </div>
</nav>
