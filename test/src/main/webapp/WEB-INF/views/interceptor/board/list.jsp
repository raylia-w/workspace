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
	$("#btnWrite").click(function(){
		$(location).attr("href", "/interceptor/board/write.do");
	});
});
</script>
</head>
<body>
<div>
<h1>목록</h1>
<hr>
<button id="btnWrite">글쓰기</button>
</div>
</body>
</html>