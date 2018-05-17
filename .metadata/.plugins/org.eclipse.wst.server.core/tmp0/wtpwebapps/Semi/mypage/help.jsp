<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/mypage.css" />
<style> 

div#contents label {
   display: inline-block;
   width: 120px;
/*    margin-left: 30px; */
}

/* div#contents div { */
/* 	margin: 20px; */
/* } */

</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#id_phone").blur(function(){
    	var num = $(this).val();
    	blur(num, this)
	 });

    $("#id_phone").click(function(){
    	var num = $(this).val();
    	focus(num, this);
    });
    
    $("#pw_phone").blur(function(){
    	var num = $(this).val();
    	blur(num, this)
	 });

    $("#pw_phone").click(function(){
    	var num = $(this).val();
    	focus(num, this);
    });
	
	function focus(num, id) {
		num = num.replace(/[^0-9]/g, '');
		$(id).val(num);
	}

	function blur(num, id) {
		num = num.replace(/[^0-9]/g, '');
		var tmp = '';
		tmp += num.substr(0, 3);
		tmp += '-';
		tmp += num.substr(3, 4);
		tmp += '-';
		tmp += num.substr(7, 13);
		$(id).val(tmp);
	}
	
	
	$("#btnid").click(function(){
		if($("#id_name").val()==null||$("#id_name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
		}else if($("#id_phone").val()==null||$("#id_phone").val()==""){
			alert("전화번호를 입력하세요");
			$("#id_phone").focus();
		}else{	
			$("#idSearch").submit();
		}
	});
	$("#btnpw").click(function(){
		if($("#id").val()==null||$("#id").val()==""){
			alert("아이디를 입력하세요");
			$("#id").focus();
		}else if($("#pw_name").val()==null||$("#pw_name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
		}else if($("#pw_phone").val()==null||$("#pw_phone").val()==""){
			alert("전화번호를 입력하세요");
			$("#pw_phone").focus();
		}else{	
			$("#pwSearch").submit();
		}
	});
	$("#btnCancel1").click(function(){
		location.href="/00_Main.jsp";
	});
	$("#btnCancel2").click(function(){
		location.href="/00_Main.jsp";
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="/main/top.jsp"></jsp:include>
	</div>
	<div id="contents">
		<h1>아이디 찾기</h1>
		<form action="/IdHelper.do" method="post" id="idSearch">
			<div class="form-inline">
			<label for="name">이름</label>
			<input class="form-control" size="30" type="text" id="id_name" name="id_name" /><br>
			<label for="phone">전화번호</label>
			<input class="form-control" size="30" type="text" id="id_phone" name="id_phone" />
			</div>
			<div>
				<label></label>
				<input type="button" id="btnid" class="btn btn-primary" value="아이디 찾기"/>&nbsp;&nbsp;&nbsp;
				<input type="button" id="btnCancel1" class="btn btn-default" value="취소"/>
			</div>
		</form>
		<h1>비밀번호 찾기</h1>
		<form action="/PwHelper.do" method="post" id="pwSearch">
			<div class="form-inline">
			<label for="name">아이디</label>
			<input class="form-control" size="30" type="text" id="id" name="id" /><br>
			<label for="name">이름</label>
			<input class="form-control" size="30" type="text" id="pw_name" name="pw_name" /><br>
			<label for="phone">전화번호</label>
			<input class="form-control" size="30" type="text" id="pw_phone" name="pw_phone" />
			</div>
			<div>
				<label></label>
				<input type="button" id="btnpw" class="btn btn-primary" value="비밀번호 찾기"/>&nbsp;&nbsp;&nbsp;
				<input type="button" id="btnCancel2" class="btn btn-default" value="취소"/>
			</div>
		</form>
	</div>
	<div style="clear:both;"></div>
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>