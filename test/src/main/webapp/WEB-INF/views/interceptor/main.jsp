<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnLogin").click(function(){
		$(location).attr("href", "/interceptor/login.do");
	});
	$("#btnLogout").click(function(){
		$(location).attr("href", "/interceptor/logout.do");
	});
	$("#btnAdmin").click(function(){
		$(location).attr("href", "/interceptor/admin/main.do");
	});
	$("#btnList").click(function(){
		$(location).attr("href", "/interceptor/board/list.do");
	});
});
</script>
</head>
<body>
<div>
<h1>인터셉터 테스트</h1>
<h3>메인 페이지</h3>
<hr>
<c:choose>
<c:when test="${login}">
<button id="btnLogout">로그아웃</button>
</c:when>
<c:otherwise>
<button id="btnLogin">로그인</button>
</c:otherwise>
</c:choose>
<button id="btnAdmin">관리자 페이지로</button>
<button id="btnList">목록</button>
</div>
</body>
</html>