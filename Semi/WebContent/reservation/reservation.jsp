<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>푸드뷰 예약</title>
<link rel="stylesheet" href="style.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="calendar.js"></script>    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
#contents {
 width: 1000px;
 margin: 0 auto;
 
}

#p_btn{
	width: 1000px;
	margin: 0 auto;
	text-align: center;
}

div#l_contents {
 	width: 350px; 
	float: left;
/* 	border: 1px solid red; */
}

div#r_contents {
 	width: 620px; 
	float: right;
/* 	border: 1px solid blue; */
}

div#reserve .center{
	text-align: center;
}

.left{
	float: left;
}

.right{
	float: right;
}

.clear {
	height: 0px;
	clear: both;
}

.jquery-calender {
	width: 620px;
	height:320px;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	$("#dNum").focus();
	$("#rTime").css("display", "none");
	$("#rNum").css("display", "none");
	$("#rSelectInfo").css("display", "none");
	$("#rUserInfo").css("display", "none");
	
	$("#dNum").change(function() {
		if( $(this).val() != null && $(this).val() !="" ){
			$("#rTime").css("display", "inline-block");}
		selectOption();
	});
	
	$("#timeSelect").change(function() {
		if( $(this).val() != null && $(this).val() !="" ){
			$("#rNum").css("display", "inline-block");}
		selectOption();
	});
	
	$("#rPerson").change(function() {
		if( $(this).val() != null && $(this).val() !="" ){
			$("#rSelectInfo").css("display", "inline-block");
			$("#rUserInfo").css("display", "inline-block");}
		selectOption();
	});
	
	function selectOption() {
		if($("#dNum").val() != null &&
			$("#timeSelect").val() != null &&
			$("#rPerson").val() != null) {

			$("#selectInfo").val(
					$("#dNum").val() + " "
					+ $("#timeSelect").val() + " "
					+ $("#rPerson").val());
			
			console.log($("#s_price").val());
		}
	}
	
	$("#btnOk").click(function(){
		if($("#terms1").is(":checked") && $("#terms2").is(":checked")){
			var person = $("#rPerson").val(); 
			var price = $("#s_price").val();
			var disrate = ($("#discount").val() * 0.1).toFixed(1);
			var discount = person * price * disrate;
			var amount = person * price - discount;
			$("#selectInfo").val(amount);
			$("#reservation").submit();

		} else {
			alert("약관 동의를 체크해주세요");
		}
	});

	function btnCancel(s_id_no){
		
	}	
});


</script>

</head>
<body>
<div id="wrapper">
	<div id="header">
			<jsp:include page="/main/top.jsp"></jsp:include>
	</div>
	<div id="contents">
		<div id="l_contents">
			<img alt="store" src="/img/foodPic/${shop.s_name }.jpg" style="width:350px; height:250px;">
			<div id="reserve">
				<div class="center">
				<label>~ 예약 안내 ~</label><br>

				<label>이용 가능 시간</label>
				<p id="useTime">${shop.op_time } ~ ${shop.cl_time }</p>
				<label>휴일</label>
				<c:set var="holiday" value="${shop.s_holiday }"/>
				<p id="holiday">
				<c:choose>
				<c:when test="${holiday eq '0'}">
				연중무휴
				</c:when>
				<c:when test="${holiday eq '1'}">
				일요일
				</c:when>
				<c:when test="${holiday eq '2'}">
				월요일
				</c:when>
				<c:when test="${holiday eq '3'}">
				화요일
				</c:when>
				<c:when test="${holiday eq '4'}">
				수요일
				</c:when>
				<c:when test="${holiday eq '5'}">
				목요일
				</c:when>
				<c:when test="${holiday eq '6'}">
				금요일
				</c:when>
				<c:when test="${holiday eq '7'}">
				토요일
				</c:when>
				</c:choose>
				</p>
				</div>
				<div style="background-image: url(/img/line-horizontal.svg); width:350px; height:10px;"></div>
				<label>상세 정보</label><br>
				<p id="detail">${shop.s_name }<br>
				${shop.s_addr }<br>
				${shop.s_p_no }<br>
				${shop.s_type }<br>
				정가 : ${shop.s_price }원<br>
				회원 할인율 : ${dis }0 %<br>
				<span>예약가격은 가격 * 인원수로 계산됩니다</span>
				</p>
			</div>
			
		</div>
		<div id="r_contents" >
		
			<form action="/reservation/reservation.do" method="post" id="reservation">
			
			<div><label for="dNum" class="left">날짜</label><input id="dNum" name="dNum" class="right" type="date" /></div><br>
			<div style="background-image: url(/img/line-horizontal.svg); width:620px; height:10px;" class="clear"></div>
		
			
			<div id="rTime">
				<label for="timeSelect" class="left">시간</label>
				<select id="timeSelect" name="timeSelect" size="1" class="right" style="width:170px;">
					<option value="9:00">9:00</option><option value="9:30">9:30</option><option value="10:00">10:00</option><option value="10:30">10:30</option><option value="11:00">11:00</option>
					<option value="11:30">11:30</option><option value="12:00">12:00</option><option value="12:30">12:30</option><option value="13:00">13:00</option><option value="13:30">13:30</option>
					<option value="14:00">14:00</option><option value="14:30">14:30</option><option value="15:00">15:00</option><option value="15:30">15:30</option><option value="16:00">16:00</option>
					<option value="16:30">16:30</option><option value="17:00">17:00</option><option value="17:30">17:30</option><option value="18:00">18:00</option><option value="18:30">18:30</option>
					<option value="19:00">19:00</option><option value="19:30">19:30</option><option value="20:00">20:00</option><option value="20:30">20:30</option><option value="21:00">21:00</option>
				</select>
			<br>
			<div style="background-image: url(/img/line-horizontal.svg); width:620px; height:10px;" class="clear"></div>
			</div>
			
			<div id="rNum"><label for="rPerson" class="left">인원</label><input type="text" id="rPerson" name="rPerson" class="right"/><br>
			<div style="background-image: url(/img/line-horizontal.svg); width:620px; height:10px;" class="clear"></div><br></div>
			
			<div id="rSelectInfo"><label for="selectInfo">선택내역</label><br><input type="text" id="selectInfo" name="amount" readonly="readonly"/><br>
			<div style="background-image: url(/img/line-horizontal.svg); width:620px; height:10px;" class="clear"></div><br></div>
			
			<div id="rUserInfo">
					<div><label for="uId" class="left" >예약자 아이디</label><input type="text" id="uId" name="uId" class="right" value="${id }" /><br></div><div class="clear"></div>
					<div><label for="uName" class="left" >예약자 이름</label><input type="text" id="uName" name="uName" class="right" value="${mem.uName }" /><br></div><div class="clear"></div>
					<div><label for="uTel" class="left" >연락처</label><input type="text" id="uTel" name="uTel" class="right" value="${mem.uPNo }" /><br></div><div class="clear"></div>
					<input type="hidden" name="s_id_no" value="${shop.s_id_no }" />
					<input type="hidden" name="s_name" value="${shop.s_name }"/>
					<input type="hidden" id="s_price" name="s_price" value="${shop.s_price }" />
					<input type="hidden" id="discount" name="discount" value="${dis}"/>
			<br>
			<div style="background-image: url(/img/line-horizontal.svg); width:620px; height:10px;" class="clear"></div></div>
			
			<div id="rTerms"><label>약관 동의</label><br>
				<div><label class="left"><a href="/reservation/terms.do?terms=terms1" target="_blank">약관1</a></label><input type="checkbox" id="terms1" name="terms1" class="right" /></div><br><div class="clear"></div>
				<div><label class="left"><a href="/reservation/terms.do?terms=terms2" target="_blank">약관2</a></label><input type="checkbox" id="terms2" name="terms2" class="right" /></div>
			</div><br>
			
			<div style="background-image: url(/img/line-horizontal.svg); width:620px; height:10px;" class="clear"></div><br>
			<div><input type="button" id="btnOk" class="btn btn-primary" value="확인" />&nbsp;&nbsp;&nbsp;<input type="button" id="btnCancel" class="btn btn-default" onClick="location.href='/restaurantsinfo.do?restaurant=${shop.s_id_no}';" value="취소" /></div><br>
			</form>
		</div>
	</div>
	<div class="clear"></div>
	<div id="header">
			<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>

</body>
</html>