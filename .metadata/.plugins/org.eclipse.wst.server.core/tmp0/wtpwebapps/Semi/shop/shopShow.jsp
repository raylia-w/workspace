<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/mypage.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><body>
	
<div id="wrapper">

	<div id="contents">
	
	
		<h1>문의 사항 관리</h1>
		<table class="table table-striped table-hover">
		<c:forEach items="${list}" var="dto">
			<thead>
				<tr>
					<th>No.</th>
					<th>문의 분류</th>
					<th>문의자</th>
					<th>글제목</th>
					<th>답변 여부</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>음식 관련</td>
					<td>김태환</td>
					<td><a href="/manager/answer.jsp">너무 맛이 없어여...</a></td>
					<td>답변 안함</td>
				</tr>
				<tr>
					<td>2</td>
					<td>예약 관련</td>
					<td>김주석</td>
					<td><a href="/manager/answer.jsp">예약 취소 가능한가여?</a></td>
					<td>답변 완료</td>
				</tr>
				<tr>
					<td>3</td>
					<td>${dto.s_address}</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">7</a></li>
				<li><a href="#">8</a></li>
				<li><a href="#">9</a></li>
				<li><a href="#">10</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</div>	<!-- text-center END -->
		
		</div>  <!-- contents END -->
	
	<div class="clear"></div>
	
</div>

</body></html>