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
   margin-left: 30px;
}

div#contents div {
	margin: 20px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var idCheck = false;
	var pwCheck = false;
	
	 $("#uIdNum").blur(function(){
    	var num = $("#uIdNum").val();
    	idNo_blur(num);
	 });

    $("#uIdNum").click(function(){
    	var num = $("#uIdNum").val();
    	idNo_focus(num);
    });
	
	function idNo_focus(num) {
		num = num.replace(/[^0-9]/g, '');
		$("#uIdNum").val(num);
	}

	function idNo_blur(num) {
		num = num.replace(/[^0-9]/g, '');
		var tmp = '';
		tmp += num.substr(0, 6);
		tmp += '-';
		tmp += num.substr(6, 13);
		$("#uIdNum").val(tmp);
	}
	$("#pno").blur(function(){
    	var num = $("#pno").val();
    	pno_blur(num)
	 });

    $("#pno").click(function(){
    	var num = $("#pno").val();
    	pno_focus(num);
    });
	
	function pno_focus(num) {
		num = num.replace(/[^0-9]/g, '');
		$("#pno").val(num);
	}

	function pno_blur(num) {
		num = num.replace(/[^0-9]/g, '');
		var tmp = '';
		tmp += num.substr(0, 3);
		tmp += '-';
		tmp += num.substr(3, 4);
		tmp += '-';
		tmp += num.substr(7, 13);
		$("#pno").val(tmp);
	}

	$("#idCheckbtn").click(function(){
		if($("#uId").val()==null||$("#uId").val()==""){
			alert("아이디를 입력하세요");
			return false;
		}else{
			$.ajax({
				type:'POST',
				url:'/idCheck.do',
				dataType:"json",
				data:{
					"id":$("#uId").val()
				}, success:function(data){
					if($.trim(data)=="true"){
						alert("사용 가능한 아이디입니다!");
						idCheck = true;
					}else{
						alert("사용할 수 없는 아이디입니다!");
						idCheck = false;
						$("#uId").focus();
					}
				}, error:function(request, error){
					console.log(request.responseText);
					console.log(error.printStackTrace);
				}
			});
		}
	});
	$("#pwCheckBtn").click(function(){
		var pw = $("#pw").val();
		if($("#pw").val()==null||$("#pw").val()==""||$("#pwCheck").val()==null||$("#pwCheck").val()==""){
			alert("비밀번호를 입력하세요");
			return false;
		}else if(pw.length<12){
			alert("비밀번호는 13자 이상 작성해주세요");
			return false;
		}
		if($("#pw").val()!=$("#pwCheck").val()){
			alert("입력된 비밀번호가 다릅니다!");
			$("#pwCheckTxt").css("display", "none")
			pwCheck = false;
			$("#pwCheck").focus();
		}else{
			$("#pwCheckTxt").css("display", "inline-block")
			pwCheck = true;
		}
		
	});
	$("#submitBtn").click(function(){
			if($("#uName").val()==""||$("#uName").val()==null){
				alert("이름을 입력하세요");
				$("#uName").focus();
			}else if($("#uIdNum").val()==""||$("#uIdNum").val()==null){
				alert("주민번호를 입력하세요");
				$("#uIdNum").focus();
			}else if($("#uId").val()==""||$("#uId").val()==null){
				alert("아이디를 입력하세요");
				$("#uId").focus();
			}else if($("#pw").val()==""||$("#pw").val()==null){
				alert("비밀번호를 입력하세요");
				$("#pw").focus();
			}else if($("#pno").val()==""||$("#pno").val()==null){
				alert("휴대폰 번호를 입력하세요");
				$("#pno").focus();
			}else if($("#addr").val()==""||$("#addr").val==null){
				alert("주소를 입력하세요");
				$("#addr").focus();
			}else if($("#email").val()==""||$("#email").val()==null){
				alert("이메일을 입력하세요");
				$("#email").focus();
			}else if($("#nick").val()==""||$("#nick").val()==null){
				alert("닉네임을 입력하세요");
				$("#nick").focus();
			}else if($(":radio[name='gender']:checked").length<1){
				alert("성별을 선택하세요");
				$("#gender").focus();
// 			}
		}else{
			if(pwCheck&&idCheck){
				console.log("OK");
				$("#memberJoin").submit();
			}else{
				if(!pwCheck){
					alert("비밀번호를 확인해주세요");
					$("#pwCheck").focus();
				}else if(!idCheck){
					alert("아이디 중복을 확인해주세요");
					$("#uId").focus();
				}
			}
			
		}
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
	<h1>회원가입</h1>
		<div id="form" class="form-inline">
		<form action="/MemberJoin.do" method="post" id="memberJoin">
			<label>이름 : </label><input type="text" id="uName" name="uName" class="form-control" size="30"/><br>
			<label>주민번호 : </label><input type="text" id="uIdNum" name="uIdNum" class="form-control" size="30"/><br>
			<label>아이디 : </label><input type="text" id="uId" name="uId" class="form-control" size="30" maxlength="12"/><input type="button" id="idCheckbtn" value="중복 확인"/><br>
			<label>비밀번호 : </label><input type="password" id="pw" name="pw" class="form-control" size="30" maxlength="30"/><br>
			<label>비밀번호 확인 : </label><input type="password" id="pwCheck" class="form-control" size="30" maxlength="30"/><input type="button" id="pwCheckBtn" value="비밀번호 확인"><br>
			<label id = "pwCheckTxt" style="display:none;">비밀번호 확인 완료</label><br>
			<label>휴대폰 번호 : </label><input type="text" id="pno" name="pno" class="form-control" size="30"/><br>
			<label>주소 : </label><input type="text" id="addr" name="addr" class="form-control" size="30"/><br>
			<label>이메일 : </label><input type="email" id="email" name="email" class="form-control" size="30"/><br>
			<label>닉네임 : </label><input type="text" id="nick" name="nick" class="form-control" size="30"/><br>
			<label>성별 : </label>
				<input type="radio" name="gender" value="M"/>남
				<input type="radio" name="gender" value="F"/>여
			<br>
			<input type="button" id="submitBtn" value="완료">
			<input type="reset" id="cancelBtn" value="취소">
		</form>
		</div>
	</div>
	<div class="clear"></div>
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>