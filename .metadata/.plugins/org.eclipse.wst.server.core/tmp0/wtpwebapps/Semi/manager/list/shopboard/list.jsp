<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<title>업체 목록</title>
</head><body>

<jsp:include page="/manager/manager_main/manager_top.jsp" />

<!-- <div class="container"> -->
<div class="container" >
<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>No</th>
		<th>음식점 이름</th>
		<th>음식점 주소</th>
		<th>음식점 전화 번호</th>
		<th>음식점 유형</th>
		<th>음식 가격대</th>
		<th>오픈 시간</th>
		<th>클로즈 시간</th>
		<th>예약 가능 여부</th>
		<th>휴일</th>
		<th>정보 삭제</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" begin="0" end="${paging.listCount }" var="i">
	<tr>
		<td>${i.s_id_no }</td>
		<td><a href="/ShopUpdate.do?s_id_no=${i.s_id_no } ">${i.s_name }</a></td>
		<td>${i.s_addr }</td>
		<td>${i.s_p_no }</td>
		<td>${i.s_type }</td>
		<td>${i.s_price }</td>
		<td>${i.op_time }</td>
		<td>${i.cl_time }</td>
		<td>${i.res_poss }</td>
		<td>${i.s_holiday }</td>
		<td><input type="button" value="정보 삭제" onClick="location.href='/ShopDelete.do?s_id_no=${i.s_id_no }'" /><td/>
	</tr>
</c:forEach>
</tbody>
</table>

<input type="button" value="홈으로" onClick="location.href='/manager/postlist.do'" />

<input type="button" value="업체 추가" onClick="location.href='/manager/shopjoin/shopAdd.jsp'" />

<%-- 페이징 불러오기 --%>
<jsp:include page="/manager/list/util/shoppaging.jsp" />

</div>

<%-- <jsp:include page="/manager/manager_main/manager_footer.jsp" /> --%>

</body></html>