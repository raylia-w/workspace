<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>푸드뷰</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var loginCheck = false;
	jQuery.fn.extend({
	    live: function (event, callback) {
	       if (this.selector) {
	            jQuery(document).on(event, this.selector, callback);
	        }
	    }
	});
	//로그인 팝업
	$('a.login-window').click(function() {
		
		var loginBox = $(this).attr('href');

		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		$div = $('<div id="mask"></div>');
// 		$("#login-box").appendTo($div);
// 		$('body').append($div);

		$('body').append('<div id="mask"></div>');
// 		$('#mask').fadeIn(300);
		$(loginBox).fadeIn(300);
		
		return false;
	});
	
	$('a.close, #mask').live('click', function() { 
	  $('#mask , .login-popup').fadeOut(300 , function() {
		$('#mask').remove();  
	}); 
	return false;
	});
	
	$("#login-btn").click(function(){
		if($("#username").val()==null||$("#username").val()==""){
			alert("아이디를 입력하세요");
			$("#username").focus();
		}else if($("#password").val()==null||$("#password").val==""){
			alert("비밀번호를 입력하세요");
			$("#password").focus();
		}else{
			$.ajax({
				type:'POST',
				url:'/LoginCheckServlet.do',
				dataType:"json",
				data:{
					"id":$("#username").val(),
					"pw":$("#password").val()
				}, success:function(data){
					if($.trim(data)=="true"){
						$('.login-popup').fadeOut(300 , function() {
							location.reload();
						});
<%-- 						console.log(<%=session.getAttribute("id")%>); --%>
					}else if($.trim(data)=="false"){
						alert("아이디와 비밀번호를 확인해주세요");
					}
// 					alert("ajax 연결");
				}, error:function(request, error){
					console.log(request.responseText);
					console.log(error.printStackTrace);
				}
			});
		}
	});
	
	$('#join-btn').click(function(){
		location.href="/01_MemberJoin.jsp";
	});
});
</script>
<style type="text/css">

a{
	text-decoration: none;
}

#gnb{
	float:right;
}

/* 메뉴 */
ul{
	list-style:none;
	position:relative;
}
ul li{
	float:right;
	margin:0px 20px;
}
li ul{
	background: rgb(109,109,109);
	display:none;
	height:auto;
	width:auto;
	padding:0px;
	border:0px;
	position:absolute;
	z-index:200;
}

#menu:hover ul{
	display:block;
}

/* 검색창 */
#search{
	display:table;
	margin-left: auto;
	margin-right: auto;
}

#search_text{
	height:40px;
	width: 800px;
}

.btn-sign a { color:#fff; text-shadow:0 1px 2px #161616; }

#mask {
	display: none;
	background: #000; 
	position: fixed; left: 0; top: 0; 
	z-index: 10;
	width: 100%; height: 100%;
	opacity: 0.8;
	z-index: 999;
}

.login-popup{
	display:none;
	background: #333;
	padding: 10px; 	
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%; left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
    -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius:3px 3px 3px 3px;
    -moz-border-radius: 3px; /* Firefox */
    -webkit-border-radius: 3px; /* Safari, Chrome */
}

img.btn_close {
	float: right; 
	margin: -28px -28px 0 0;	
	border: 0; /* 익스플러에서 닫기 버튼 테두리 나타나는 문제 해결 */
}

fieldset { 
	border:none; 
}

form.signin .textbox label { 
	display:block; 
	padding-bottom:7px; 
}

form.signin .textbox span { 
	display:block;
}

form.signin p, form.signin span { 
	color:#999; 
	font-size:11px; 
	line-height:18px;
} 

form.signin .textbox input { 
	background:#666666; 
	border-bottom:1px solid #333;
	border-left:1px solid #000;
	border-right:1px solid #333;
	border-top:1px solid #000;
	color:#fff; 
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px;
    -webkit-border-radius: 3px;
	font:13px Arial, Helvetica, sans-serif;
	padding:6px 6px 4px;
	width:200px;
}

form.signin input:-moz-placeholder { color:#bbb; text-shadow:0 0 2px #000; }
form.signin input::-webkit-input-placeholder { color:#bbb; text-shadow:0 0 2px #000;  }

.button { 
	background: -moz-linear-gradient(center top, #f3f3f3, #dddddd);
	background: -webkit-gradient(linear, left top, left bottom, from(#f3f3f3), to(#dddddd));
	background:  -o-linear-gradient(top, #f3f3f3, #dddddd);
    filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#f3f3f3', EndColorStr='#dddddd');
	border-color:#000; 
	border-width:1px;
	border-radius:4px 4px 4px 4px;
	-moz-border-radius: 4px;
    -webkit-border-radius: 4px;
	color:#333;
	cursor:pointer;
	display:inline-block;
	padding:6px 6px 4px;
	margin-top:10px;
	font:12px; 
	width:214px;
}

/* .button:hover { background:#ddd; } */
</style>
</head>
<body>
<!-- wrapper 시작 -->
<div id="wrapper">
	<!-- header 시작 -->
	<div id="header" style="height:80px; position:relative; z-index:100; background-color:rgb(252, 250, 225);">
		<!-- 로고 -->
		<div id="logo">
			<a href="/00_Main.jsp"><img src=""><h1 style="color: rgb(255, 119, 41);">푸드뷰</h1></a>
		</div>
		<!-- 메뉴 -->
		<div id="gnb">
			<ul>
		
				<li class="menu3"><a href="#login-box" class="login-window">
				<% 
					String id="";
					id=(String)session.getAttribute("id");
					String pw="";
					pw=(String)session.getAttribute("pw");
					
					if(id==null||"".equals(id)||pw==null||"".equals(pw)){
				%>
				로그인
				<%
					}else if(id=="admin"||id.equals("admin")){
						
				%>
					<script>location.href="/manager/10_main.jsp";</script>
				<%
					}else{
				%>
				내 정보
				<% } %>
				</a></li>

				<li id="menu">메뉴
					<ul>
						<li class="menu2"><a href="/05_event.jsp">이벤트</a></li>
						<li class="menu1"><a href="/05_notice.jsp">공지사항</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- 로그인 -->
		
		<div id="login-box" class="login-popup" style="display: none; margin-top: -94px; margin-left: -135.5px;">
        <a href="#" class="close"><img src="img/close_pop.png" class="btn_close" title="Close Window" alt="Close"></a>
		<% 
			id=(String)session.getAttribute("id");
			pw=(String)session.getAttribute("pw");
			
			if(id==null||"".equals(id)||pw==null||"".equals(pw)){
		%>
			<form method="post" class="signin" action="/main/authentication.jsp">
                <fieldset class="textbox">
	            	<label class="username">
		                <span>ID</span>
		                <input id="username" name="username" value="" type="text" autocomplete="on" placeholder="Username">
	                </label>	                
	                <label class="password">
		                <span>Password</span>
		                <input id="password" name="password" value="" type="password" placeholder="Password">
	                </label>
	                <label class="findInfo">
	                	<small><a href="01_help.jsp">아이디/비밀번호 찾기</a></small>
	                </label>      
                <input type="button" id="login-btn" value="로그인">
                <input type="button" id="join-btn" value="회원가입">             
                </fieldset>
          </form>
          <%
          	} else {
          %>
			<label class="userId">
        		<span><%= session.getAttribute("id")%></span><br>
        	</label>
        	<label class="mypage">
        		<span><a href="01_mypage.jsp">마이페이지</a></span><br>
        	</label>
        	<label class="logout">
        		<span><a href="/main/logout.jsp">로그아웃</a></span>
        	</label>
       	<%
          	};
       	%>
	   </div>
		<!-- 검색창 -->
		<div id="search">
			<label class="search"><input type="text" id="search_text" placeholder="검색"/></label>
			<button style="height:45px;"><a href="#">검색</a></button>
		</div>
	<!-- header 끝 -->
	</div>
<!-- wrapper 끝 -->
</div>
</body>
</html>