<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnWrite").click(function(){
		$(location).attr("href", "/board/write.do");
	});
	$("#btnMain").click(function(){
		$(location).attr("href", "/member/main.do");
	});
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes
		 = $("input:checkbox[name='checkRow']:checked");
		
		//방법1
		// 체크된 대상들을 하나씩 꺼내서 문자열로 합치기
// 		var names = "";
// 		var len = $checkboxes.length;
// 		$checkboxes.each( function(idx) {
// 			names += $(this).val();
			
// 			if( len-1 != idx ) {
// 				names += ",";
// 			}
// 		});
// 		console.log(names);
	
		//방법2
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
		console.log("names : " + names);

// 		console.log( "map:" + map );	// 맵
// 		console.log( "map->array : " + map.get() );	// 맵->배열
// 		console.log( "array tostring : " + map.get().join(",") ); // toString
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/board/deleteList.do")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
});

// 전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
};
</script>
</head>
<body>
<h1>게시글 리스트</h1>
<hr>
<c:if test="${list.size() eq 0 }">
	<h3>데이터가 없습니다</h3>
</c:if>
<c:if test="${list.size() ne 0}">
<form action="/board/search.do" method="get">
<input type="text" id="keyword" name="keyword">
<button>검색</button>
</form>
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>
				<input type="checkbox" id="checkAll" onclick="checkAll();" />
			</th>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>추천수</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="data">
		<tr>
			<td><input type="checkbox" name="checkRow" value="${i.boardno }" /></td>
			<td>${data.boardNo }</td>
			<td><a href="/board/view.do?boardNo=${data.boardNo }">${data.title }</a></td>
			<td>${data.writer }</td>
			<td>${data.hit }</td>
			<td>${data.recommend }</td>
			<td><fmt:formatDate value="${data.writtenDate }" pattern="yy-MM-dd" /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<button id="btnMain" class="btn pull-right">메인으로</button>
<button id="btnDelete" class="btn btn-warning pull-left">삭제</button>
<button id="btnWrite" class="btn pull-right">글쓰기</button>
<jsp:include page="../util/paging.jsp"></jsp:include>
</c:if>
</body>
</html>