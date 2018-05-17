<%@page import="DTO.ShopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.ShopService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/mypage.css" />

<script type="text/javascript">
$(document).ready(function(){
	$("#btnConfirm").click(function(){
		$("#shopInfo").submit();		
		
	});
	
});
</script>

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

<div id="wrapper">
	
	<div id="contents">
		<h1>음식점 정보 수정</h1>		
		<form action="/ShopUpdateExe.do" method="post" id="shopInfo">
		<input type="hidden" value="${s.s_id_no }" id="sID" name="sID" />
		 
		<div class="form-inline">
		<label for="s_name">음식점 이름</label>
		<input class="form-control" size="30" type="text" value="${s.s_name }" id="sName" name="sName" />
		</div>
		<div class="form-inline">
		<label for="s_addr">음식점 주소</label>
		<input class="form-control" size="30" type="text" value="${s.s_addr }" id="sAddress" name="sAddress" />
		</div>
		<div class="form-inline">
		<label for="s_p_no">음식점 전화 번호</label>
		<input class="form-control" size="30" type="text" value="${s.s_p_no }" id="sPhone_#" name="sPhone_#" />
		</div>
		<div class="form-inline">
		<label for="s_type">음식점 유형</label>
		<input class="form-control" size="30" type="text" value="${s.s_type }" id="sType" name="sType" />
		</div>
		<div class="form-inline">
		<label for="s_price">음식점 가격대</label>
		<input class="form-control" size="30" type="text" value="${s.s_price }" id="sPrice" name="sPrice" /><br>
		</div>
		<div class="form-inline">
		<label for="s_op_time">오픈 시간</label>
		<input class="form-control" size="30" type="text" value="${s.op_time }" id="sOpen_time" name="sOpen_time" /><br>
		</div>
		<div class="form-inline">
		<label for="s_cl_time">클로즈 시간</label>
		<input class="form-control" size="30" type="text" value="${s.cl_time }" id="sClose_time" name="sClose_time" /><br>
		</div>
		<div class="form-inline">
		<label for="s_score">예약 가능 여부</label>
		<input class="form-control" size="30" type="text" value="${s.res_poss }" id="sPoss" name="sPoss" /><br/>
		</div>
		<div class="form-inline">
		<label for="s_res_poss">휴일</label>
		<input class="form-control" size="30" type="text" value="${s.s_holiday }" id="sHoli" name="sHoli" /><br/>
		</div>
		<div>
		<label></label>
		<input type="button" id="btnConfirm" class="btn btn-primary" value="확인"/>&nbsp;&nbsp;&nbsp;
		<input type="reset" id="btnCancel" class="btn btn-default" value="취소" onClick="location.href='/manager/manager_main/manager_main.jsp'" />
		</div>
		</form>
		
	</div>	
	<div class="clear"></div>
</div>