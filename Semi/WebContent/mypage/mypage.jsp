<%@page import="Service.MemberService"%>
<%@page import="DTO.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/mypage.css" />
<script type="text/javascript">
$(document).ready(function(){
	$("#btnConfirm").click(function(){
		if($("#password").val()==null||$("#password").val()==""){
			alert("회원 정보 수정 시 새로 사용할 비밀번호를 입력해야합니다");
			$("#password").focus();
			return;
		}
		
		$("#memberInfo").submit();
		
	});
	$("#btnCancel").click(function() {
		location.href="/00_Main.jsp";
	});
	
});
</script>

<style> 
div#contents{
	float: right;

}
div#contents label {
   display: inline-block;
   width: 120px;
   margin-left: 30px;
}

div#contents div {
	margin: 20px;
}

</style>

<div id="wrapper">
	<div id="header">
		<jsp:include page="/main/top.jsp"></jsp:include>
	</div>
	<div id="aside">
		<jsp:include page="aside.jsp" />
	</div>
	<div id="contents">
		<h1>회원정보 수정</h1>
		<form action="/MemberUpdate.do" method="post" id="memberInfo"> 
		<div class="form-inline">
		<label for="id">아이디</label>
		<input class="form-control" size="30" type="text" id="id" name="id" value=<%=session.getAttribute("id") %> readonly />
		</div>
		<div class="form-inline">
		<label for="password">비밀번호 </label>
		<input class="form-control" size="30" type="password" id="password" name="password" />
		</div>
		<div class="form-inline">
		<label for="password2">비밀번호 확인</label>
		<input class="form-control" size="30" type="password" id="password2" name="password2" />
		</div>
		<div class="form-inline">
		<label for="name">이름</label>
		<input class="form-control" size="30" type="text" id="name" name="name" value=${m.uName } />
		</div>
		<div class="form-inline">
		<label for="nick">닉네임</label>
		<input class="form-control" size="30" type="text" id="nick" name="nick" value=${m.uNick } /><br>
		</div>
		<div class="form-inline">
		<label for="phone">전화번호</label>
		<input class="form-control" size="30" type="text" id="phone" name="phone" value=${m.uPNo } /><br>
		</div>
		<div class="form-inline">
		<label for="email">이메일</label>
		<input class="form-control" size="30" type="text" id="email" name="email" value=${m.uEmail } /><br>
		</div>
<%-- 		<div class="form-inline"><label for="age">연령대</label><input class="form-control" size="30" type="text" id="age" name="age" value="${age='추가할것' }" /><br></div> --%>
		<div class="form-inline">
		<label for="location">지역(주소)</label>
		<input class="form-control" size="30" type="text" id="addr" name="addr" value=${m.uAddr } /><br>
		</div>
		<div>
		<label></label>
		<input type="button" id="btnConfirm" class="btn btn-primary" value="확인"/>&nbsp;&nbsp;&nbsp;
		<input type="button" id="btnCancel" class="btn btn-default" value="취소"/>
		</div>
		</form>
	</div>	
	<div class="clear"></div>
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
