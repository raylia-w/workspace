<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<title>결제 목록</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

function refund(imp_uid, res_id){
	location.href="/refund.do?uid="+imp_uid+"&res_id="+res_id;
}
</script>
</head><body>

<jsp:include page="/manager/manager_main/manager_top.jsp" />

<!-- <div class="container"> -->
<div class="container" >
<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>결제 승인 번호</th>
<!-- 		<th>No</th> -->
<!-- 		<th>결제 회원</th> -->
		<th>음식점 이름</th>
		<th>결제 금액</th>
		<th>결제 수단</th>
		<th>결제 대행사</th>
		<th>구매자 이름</th>
		<th>구매자 연락처</th>
		<th>구매한 날짜</th>
		<th>결제 상태</th>
		<th>환불 승인</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" begin="0" end="${paging.listCount }" var="i">
	<tr>		
		<td>${i.imp_uid }</td>		
		<td><a href="">${i.s_name }</a></td>
		<td>${i.amount }</td>
<%-- 		<td>${i.pay_amount }</td> --%>
		<td>${i.pay_method }</td>
		<td>${i.pg }</td>
		<td>${i.buyer_name }</td>
		<td>${i.buy_tel }</td>
		<td>${i.paid_at }</td>
		<td>${i.status }</td>
		<td><input type="button" value="환불승인" onClick="refund('${i.imp_uid }', '${i.res_id }')" /></td>
	</tr>
</c:forEach>
</tbody>
</table>

<input type="button" value="홈으로" onClick="location.href='/manager/postlist.do'" />

<%-- 페이징 불러오기 --%>
<jsp:include page="/manager/list/util/paymentpaging.jsp" />

</div>

<%-- <jsp:include page="/manager/manager_main/manager_footer.jsp" /> --%>

</body></html>