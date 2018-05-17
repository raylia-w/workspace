<%@page import="Service.PostList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.PostDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/mypage.css" />

<style>

div#content{
	height: 170px;
	margin: 20px;
}

div#content img {
	width: 200px;
	height: 150px;
 	float: left; 
	padding: 10px;
/* 	border: 1px solid black; */
}
div#content p {
	margin: 0;
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
		<h1>내가 쓴 리뷰</h1>
		<table class="table table-striped table-hover">
			<thead>
			<tr>
				<th>No</th>
				<th>리뷰 제목</th>
				<th>리뷰 내용</th>
				<th>작성일</th>
				<th>삭제</th>
			</tr>
			</thead>
			
			<tbody>
		<c:forEach items="${list }" begin="0" end="${paging.listCount }" var="i">			
			<tr>
				<td>${i.p_no }</td>
				<td><a href="/PostShopDt.do?p_no=${i.p_no } ">${i.p_name }</a></td>
				<td>${i.p_main }</td>
				<td>${i.p_date }</td>
				<td><input type="button" id="deleteBtn" value="삭제" onClick="location.href='/PostDelete.do?p_no=${i.p_no}'"></td>
			</tr>
		</c:forEach>			
			</tbody>			
		</table>
		
		<jsp:include page="/util/myReviewpaging.jsp"></jsp:include>
	</div>
	
	<div class="clear"></div>
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
