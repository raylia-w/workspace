<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
function deleteAct(idx){
	console.log("deleteAct() Called : "+idx);
// 	location.href="/member/delete.do?idx="+idx;

// 	var form = document.createElement("form");
// 	form.method = 'post';
// 	form.action = '/member/delete.do';
	
// 	var idxInput = document.createElement("input");
// 	idxInput.type='hidden';
// 	idxInput.name='idx';
// 	idxInput.value=idx;
	
// 	form.appendChild(idxInput);
	
// 	document.body.appendChild(form);
	
// 	form.submit();

// 	var $form = $("<form>").attr({
// 		action:"/member/delete.do",
// 		method:"post"
// 	});
	
// 	var $input = $("<input>").attr({
// 		type:"hidden",
// 		name:"idx",
// 		value:idx
// 	});
	
// 	$form.append($input)
// 		.appendTo($(document.body));
	
	var $form = null;
	$(document.body).append(
		$form=$("<form>").attr({
			action:"/member/delete.do",
			method:"post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"idx",
				value:idx
			})
		)
	);
	
	$form.submit();
}

$(document).ready(function(){
// 	$(".updateBtn").click(function(){
	$("tr").on("click", "td .updateBtn", function(){
		var id = $(this).attr("id");
		$.ajax({
			type:"post",
			url:"/member/update.do",
			data:{
				idx:$(this).attr("id"),
				name:$("#name").val(),
				email:$("#email").val(),
				phone:$("#phone").val()
			}, dataType:"json",
			success:function(d){
				$("#tr"+d.idx).css("color", "red");
				$("#tr"+d.idx+" td").eq(1).html($(d.name));
				$("#tr"+d.idx+" td").eq(2).html($(d.email));
				$("#tr"+d.idx+" td").eq(3).html($(d.phone));
			}, error:function(){
				alert("AJAX 통신 실패(비정상적인 응답)");
			}
		});
	});
});
</script>
</head>
<body>
<h1>멤버 메인</h1>
<hr>
<form action="/member/insert.do" method="post">
<table border="1px solid">
	<thead>
		<tr>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><input type="text" name="name" id="name"/></td>
			<td><input type="text" name="email" id="email"/></td>
			<td><input type="text" name="phone" id="phone"/></td>
			<td><input type="submit" value="가입"/></td>
	</tbody>
</table>
</form>
<hr>
<c:if test="${list.size() eq 0 }">
	<h3>데이터가 없습니다</h3>
</c:if>
<c:if test="${list.size() ne 0}">
<table border="1px solid">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="data">
		<tr id="tr${data.idx }">
			<td>${data.idx }</td>
			<td>${data.name }</td>
			<td>${data.email }</td>
			<td>${data.phone }</td>
			<td><fmt:formatDate value="${data.join_date }" pattern="yyyy-MM-dd" /></td>
			<td>
				<button class="updateBtn" id="${data.idx }">수정</button>
				<button onclick="deleteAct(${data.idx});">삭제</button>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
</body>
</html>