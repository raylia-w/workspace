<%@page import="Service.ReservationServiceImpl"%>
<%@page import="Service.ReservationService"%>
<%@page import="Service.PaymentService"%>
<%@page import="DTO.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/mypage.css" />

<div id="wrapper">
	<div id="header">
		<jsp:include page="/main/top.jsp"></jsp:include>
	</div>
	<div id="aside">
		<jsp:include page="aside.jsp" />
	</div>
	<div id="contents">
		<h1>결제 내역</h1><br>
		<small>환불이 완료된 결제 내역은 목록에서 삭제됩니다</small>
		<table class="table table-striped table-hover">
			<thead>
			<tr>		
				<th>음식점명</th>
				<th>결제수단</th>
				<th>가격</th>
				<th>결제일시</th>
				<th>환불요청</th>
				<th>결제상태</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" begin="0" end="${paging.listCount }" var="i">			
				<tr>	
					<td>${i.s_name }</td>
					<td>${i.pay_method}</td>
					<td>${i.amount }</td>
					<td>${i.paid_at }</td>
					<td><a href="/refundReq.do?uid=${i.imp_uid }"><input type="button" id="refund" value="환불신청"></a></td>
					<td>${i.status }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<jsp:include page="/util/myPaypaging.jsp" />
	</div>
		
	<div class="clear"></div>
	
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
