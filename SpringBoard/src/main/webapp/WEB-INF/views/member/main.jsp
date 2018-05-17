<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인 페이지</h1>
<hr>
<h3><a href="/board/list.do">게시판</a></h3>
<c:choose>
<c:when test="${userid eq null}">
<h3><a href="/member/join.do">회원 가입</a></h3>
<h3><a href="/member/login.do">로그인</a></h3>
</c:when>
<c:when test="${userid ne null}">
<h3><a href="/member/logout.do">로그아웃</a></h3>
</c:when>
</c:choose>
</body>
</html>