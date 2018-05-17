<%@page import="DTO.ReservationDTO"%>
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
		<h1>예약 내역</h1><br>
		<small>결제가 완료된 예약을 확인하실 수 있습니다</small>
		<table class="table table-striped table-hover">
			<thead>
			<tr>
				<th>예약일</th>
				<th>예약자 아이디</th>
				<th>예약 장소</th>
				<th>예약 시간</th>
				<th>예약 인원</th>
			</tr>
			</thead>
			
			<tbody>
		<c:forEach items="${resList }" begin="0" end="${paging.listCount }" var="i">			
			<tr>
				<td>${i.res_date}</td>
				<td>${i.u_id }</td>
				<td>${i.s_name }</td>
				<td>${i.res_time }</td>
				<td>${i.res_person }</td>
			</tr>
		</c:forEach>			
			</tbody>			
		</table>
		<div class="clear"></div>
		<jsp:include page="/util/myReservation.jsp" />

	</div>	
	<div class="clear"></div>
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
