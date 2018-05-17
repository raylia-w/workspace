<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/mypage.css" />

<style>

</style>

<div id="wrapper">
	<div id="header">
		<jsp:include page="/main/top.jsp"></jsp:include>
	</div>
	<div id="aside">
		<jsp:include page="aside.jsp" />
	</div>
	<div id="contents">
		<h1>1:1 문의 신청</h1>
		<form action="/Question.do" method="post">
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="p_name" name="p_name" />
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" rows="10" id="p_main" name="p_main"></textarea>
			</div>
			<input type="text" style="display:none;" id="bNo" name="bNo" value="5"/>
			<button class="btn btn-primary center-block">문의 신청</button>
		</form>
	</div>	
	<div class="clear"></div>
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
