<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#login").click(function(){
		if($("#id").val()==""||$("#id").val()==null){
			alert("아이디를 입력하세요");
			$("#id").focus();
		}else if($("#pw").val()==""||$("#pw").val()==null){
			alert("비밀번호를 입력하세요");
			$("#pw").focus();
		}else{
			$.ajax({
				type:"post",
				url:"/user/loginProc.do",
				data:{
					id:$("#id").val(),
					pw:$("#pw").val()
				}, success:function(data){
					if(data.trim()=="true"){
						alert("로그인 성공");
						location.href="/user/main.do";
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
<form action="/user/loginProc.do" method="post">
<label>아이디 : <input type="text" id="id" name="id"/></label><br>
<label>비밀번호 : <input type="password" id="pw" name="pw"/></label>
<input type="button" id="login" value="로그인">
</form>
</body>
</html>