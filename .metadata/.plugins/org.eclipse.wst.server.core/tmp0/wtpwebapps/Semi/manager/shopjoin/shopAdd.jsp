<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.js"></script>
<link rel="stylesheet" type="text/css" href="/css/mypage.css" />

<title>게시판 등록 폼</title>
<script type="text/javascript">
$(document).ready(function(){

	$("#submitBtn").click(function(){
		$("#shopJoin").submit();
	
	});
});
</script>

<style> 

/* div#contents label { */
/*    display: inline-block; */
/*    width: 120px; */
/* } */

div#contents label {
   display: inline-block;
   width: 120px;
   margin-left: 30px;
}

div#contents div {
	margin: 20px;
}

/* div { */
/*     	height: 700px; */

/*     } */

</style></head>

<jsp:include page="/manager/manager_main/manager_top.jsp"></jsp:include>

<body>	
	<div id="contents">
		<form action="/ShopJoin.do" method="post" id="shopJoin">
			<div class="form-inline">
			<label for="id">음식점 이름</label>
			<input class="form-control" size="30" type="text" id="sName" name="sName"  />
			</div>
			<div class="form-inline">
			<label for="id">주소</label>
			<input class="form-control" size="30" type="text" id="sAddress" name="sAddress"  />
			</div>
			<div class="form-inline">
			<label for="id">번호</label>
			<input class="form-control" size="30" type="text" id="sPhone_#" name="sPhone_#"  />
			</div>
			<div class="form-inline">
			<label for="id">타입</label>
			<input class="form-control" size="30" type="text" id="sType" name="sType"  />
			</div>
			<div class="form-inline">
			<label for="id">가격대</label>
			<input class="form-control" size="30" type="text" id="sPrice" name="sPrice"  />
			</div>
			<div class="form-inline">
			<label for="id">오픈 시간</label>
			<input class="form-control" size="30" type="text" id="sOpen_time" name="sOpen_time"  />
			</div>
			<div class="form-inline">
			<label for="id">클로즈 시간</label>
			<input class="form-control" size="30" type="text" id="sClose_time" name="sClose_time"  />
			</div>
			<div class="form-inline">
			<label for="id">Poss</label>
			<input class="form-control" size="30" type="text" id="sPoss" name="sPoss"  />
			</div>
			<div class="form-inline">
			<label for="id">휴일</label>
			<input class="form-control" size="30" type="text" id="sHoli" name="sHoli"  />
			</div>
			
			<div>
			<label></label>
			<input type="button" id="submitBtn" class="btn btn-primary" value="완료"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" id="cancelBtn" class="btn btn-default" value="취소"/>
			</div>	
		
		</form>
	</div>

<jsp:include page="/manager/manager_main/manager_footer.jsp"></jsp:include>
			
</body></html>