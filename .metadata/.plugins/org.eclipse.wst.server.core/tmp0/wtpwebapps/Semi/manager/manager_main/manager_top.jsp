<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      background-color: #df9f3c;
      margin-bottom: 0;
      border-radius: 0;
      height: 150px;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    .container {
    	height: 700px;

    }    
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #df9f3c;
      color: white;
      padding: 15px;
      height: 150px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
    li {
    font-size: 30px;
    list-style: none;
    margin: 10px;
    position: relative;
    top: 50px;
    
    
    }
  </style>
  
<script type="text/javascript">
// $(document).ready(function(){
// 	$("#post").click(function(){
// 		alert("테스트")
// 		$("#main") {
// 			location.href="/manager/postlist.do"
// 		}		
		
		
// 	});
	
// });
</script>  
  
</head><body>

<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><img src="/img/foodview.png" /></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active" id="post" ><a href="/manager/postlist.do">게시판 관리</a></li>
        <li><a href="/manager/paymentlist.do">결제 관리</a></li>
        <li><a href="/manager/shoplist.do">업체 관리</a></li>
        <li><a href="/manager/memberlist.do">회원 관리</a></li>
        <li><a href="/manager/faqlist.do">문의 관리</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/main/logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<!-- <div class="container-fluid text-center">     -->
<!--   <div class="row content"> -->
<!--     <div class="col-sm-2 sidenav"> -->
<!--       <p><a href="#">Link</a></p> -->
<!--       <p><a href="#">Link</a></p> -->
<!--       <p><a href="#">Link</a></p> -->
<!--     </div> -->
<!--     <div class="col-sm-8 text-left" id="main">  -->
	
<!--     </div> -->
<!--     <div class="col-sm-2 sidenav"> -->
<!--       <div class="well"> -->
<!--         <p>ADS</p> -->
<!--       </div> -->
<!--       <div class="well"> -->
<!--         <p>ADS</p> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->

<!-- <footer class="container-fluid text-center"> -->
<!--   <p>Footer Text</p> -->
<!-- </footer> -->

<!-- </body></html> -->