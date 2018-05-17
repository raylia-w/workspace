<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#login").click(function(){
		if($("#userid").val()==""||$("#userid").val()==null){
			alert("아이디를 입력하세요");
			$("#userid").focus();
		}else if($("#userpw").val()==""||$("#userpw").val()==null){
			alert("비밀번호를 입력하세요");
			$("#userpw").focus();
		}else{
			$.ajax({
				type:"post",
				url:"/member/login.do",
				data:{
					userid:$("#userid").val(),
					userpw:$("#userpw").val()
				}, success:function(data){
					if(data.trim()=="true"){
						alert("로그인 성공");
						location.href="/member/main.do";
					}else{
						alert("등록되지 않은 회원입니다");
					}
				}
			});
		}
	});
});
</script>
</head>
<body>
<h1>로그인</h1>
<hr>
<form action="/member/login.do" method="post">
<label>아이디 : <input type="text" id="userid" name="userid"/></label><br>
<label>비밀번호 : <input type="password" id="userpw" name="userpw"/></label>
<input type="button" id="login" value="로그인">
</form>
</body>
</html>