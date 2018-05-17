<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<title>게시글 목록</title>
</head>

<jsp:include page="/manager/manager_main/manager_top.jsp" />

<body>
<!-- <div class="container"> -->
<div class="container" >

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>No.</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>게시물 제목</th>
		<th>게시물 삭제</th>		
	</tr>
</thead>
<tbody>

<c:forEach items="${list }" begin="0" end="${paging.listCount }" var="i">
	<tr>
		<td>${i.p_no }</td>
		<td>${i.u_no }</td>
		<td>${i.p_date }</td>
		<td><a href="/postDetail.do?p_no=${i.p_no } ">${i.p_name }</a></td>
		<td><input type="button" id="deleteBtn" value="정보 삭제" onClick="location.href='/PostDelete.do?p_no=${i.p_no}'"></td>
	</tr>
	
</c:forEach>

</tbody>
</table>

<input type="button" value="홈으로" onClick="location.href='/manager/postlist.do'" />

<%-- 페이징 불러오기 --%>
<jsp:include page="/manager/list/util/postpaging.jsp" />

</div>

<%-- <jsp:include page="/manager/manager_main/manager_footer.jsp" /> --%>


</body></html>