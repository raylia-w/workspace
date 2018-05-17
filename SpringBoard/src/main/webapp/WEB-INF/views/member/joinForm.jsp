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
	var isNew = false;
	$("#idCheck").click(function(){
		console.log($("#userid").val());
		if($("#userid").val()==null||$("#userid").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
		}else{
			$.ajax({
				type:"post",
				url:"/member/idCheck.do",
				data:{
					id:$("#userid").val()
				}, success:function(data){
					if(data.trim()=="true"){
						isNew=true;
						alert("사용 가능한 아이디");
					}else{
						isNew=false;
						alert("사용 불가능한 아이디");
					}
				}
			});
		}
	});
	
	$("#join").click(function(){
		if(isNew){
			frm.submit();
		}else{
			frm.reset();
			alert("아이디 중복 체크를 해주세요");
		}
	});
});
</script>
</head>
<body>
<h1>회원 가입</h1>
<hr>
<form action="/member/join.do" method="post" id="frm">
<label>아이디 : <input type="text" id="userid" name="userid"/></label>
<input type="button" id="idCheck" value="중복 체크"/><br>
<label>패스워드 : <input type="password" id="userpw" name="userpw"/></label><br>
<label>닉네임 : <input type="text" id="usernick" name="usernick"/></label><br>
<input type="button" id="join" value="회원 가입">
</form>
</body>
</html>