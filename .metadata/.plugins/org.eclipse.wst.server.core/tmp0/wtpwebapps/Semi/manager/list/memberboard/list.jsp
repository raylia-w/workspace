<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<title>회원 목록</title>

<script type="text/javascript">
function updateMember(u_no) {
	
	var id = u_no;
	var grade = $("#grade"+id).val();
		
// 	var obj = document.getElementById("grade");
// 	var value = obj.options[obj.selectedIndex].value;
// 	alert(value);
		
	location.href='/MmemberUpdate.do?u_no='+id+'&grade='+grade;
}
</script>
</head>

<body>

<jsp:include page="/manager/manager_main/manager_top.jsp" />

<!-- <div class="container"> -->
<div class="container" >

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th>No.</th>
		<th>회원명</th>
		<th>아이디</th>
		<th>패스워드</th>
		<th>등급</th>
		<th>등급 변경</th>
		<th>정보 수정</th>
		<th>정보 삭제</th>
	</tr>
</thead>

<tbody>
<c:forEach items="${list }" begin="0" end="${paging.listCount }" var="i">
	<tr>
		<td>${i.ID }</td>
		<td>${i.uName }</td>
		<td>${i.uId }</td>
		<td>${i.password }</td>
		<td>${i.uGrade }</td>
		<td>			
					<select class="form-control" id="grade${i.ID }" name="grade" size="1" style="width: 100px;">
						<option value="0" >회원등급</option>
						<option value="1" >1</option>
						<option value="2" >2</option>
						<option value="3" >3</option>
						<option value="4" >4</option>
						<option value="5" >5</option>
					</select>
		</td>
		<td><input type="button" value="수정" onClick="updateMember(${i.ID })" /></td>
		<td><input type="button" value="삭제" onClick="location.href='/MmemberDelete.do?u_no=${i.ID }'" /></td>					
	</tr>
</c:forEach>
</tbody>
</table>

<input type="button" value="홈으로" onClick="location.href='/manager/postlist.do'" />

<%-- 페이징 불러오기 --%>
<jsp:include page="/manager/list/util/memberpaging.jsp" />
</div>

<%-- <jsp:include page="/manager/manager_main/manager_footer.jsp" /> --%>

</body></html>