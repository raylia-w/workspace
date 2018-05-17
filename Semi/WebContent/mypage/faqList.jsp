<%@page import="DTO.PostDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service.PostList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/mypage.css" />

<script type="text/javascript">
$(document).ready(function(){
	$("#btnWrite").click(function(){
		location.href="/mypage/faqWrite.jsp";
	});
});
</script>

<style type="text/css">

#btnWrite {
 	margin:20px;
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
		<h1>문의 내역</h1>
		<button id="btnWrite" class="btn btn-default pull-right">글쓰기</button>

		<table class="table table-striped table-hover">

			<thead>
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>작성일</th>
				<th>삭제</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" begin="0" end="${paging.listCount }" var="i">			
			
			<tr>
				<td>${i.p_no }</td>
				<td><a href="/PostShopDt.do?p_no=${i.p_no } ">${i.p_name }</a></td>
				<td>${i.p_date }</td>
				<td><input type="button" id="deleteBtn" value="삭제" onClick="location.href='/PostDelete.do?p_no=${i.p_no}'"></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	<jsp:include page="/util/myFaqpaging.jsp" />
	</div>	
	<div class="clear"></div>
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
