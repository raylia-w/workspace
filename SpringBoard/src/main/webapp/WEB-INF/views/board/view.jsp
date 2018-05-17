<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/resources/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
<h1>상세글 조회</h1>
<hr>
<div class="form-group">
<label for="title">제목 : <input type="text" id="title" name="title" value="${board.title }" readonly="readonly"></label>
</div>
<div class="form-group">
<input type="hidden" id="id" name="id" value="${sessionScope.usernick }">
<label for="writer">작성자<input type="text" id="writer" name="writer" value="${board.writer }" readonly="readonly"></label>
</div>
<div class="form-group">
<label for="writtenDate">작성일 : <fmt:formatDate value="${board.writtenDate }" pattern="yy/MM/dd" /></label>
</div>
<div class="form-group">
<label for="hit">조회 수 : ${board.hit }</label>
</div>
<div class="form-grout">
<label for="recommend">추천 수 : ${board.recommend }</label>
</div>
<hr>
<div class="form-grout">첨부파일<br>
<a href="/board/download.do?fileno=${boardFile.fileno }">${boardFile.original_filename }</a>
</div>
<h3>본문</h3>
<div class="form-group" id="content">
</div>
<script type="text/javascript">
document.getElementById('content').innerHTML='${board.content}';

$(document).ready(function() {
	
	$("#update").click(function() {
		$(location).attr("href", "/board/update.do?boardNo=${board.boardNo}");
	});
	$("#return").click(function(){
		$(location).attr("href", "/board/list.do");
	});
	$("#delete").click(function(){
		$(location).attr("href", "/board/delete.do?boardNo=${board.boardNo}");
	});
	$("#recommend").click(function(){
		$.ajax({
			type:"post",
			url:"/board/recommendCheck.do",
			data:{
				boardNo:"${board.boardNo}",
				writerId:"${sessionScope.userid}"
			}, success:function(data){
				if(data.trim()=="true"){
					$(location).attr("href", "/board/recommend.do?boardNo=${board.boardNo}&writerId=${sessionScope.userid}");
					alert("추천되었습니다.");
				}else{
					alert("이미 추천한 글입니다.");
				}
			}
		});
	});
	function deleteComment(commentNo) {
		$.ajax({
			type: "post"
			, url: "/board/deleteComment.do"
			, dataType: "json"
			, data: {
				commentNo: commentNo
			}
			, success: function(data){
				if(data.success) {
					
					$("[data-commentno='"+commentNo+"']").remove();
					
				} else {
					alert("댓글 삭제 실패");
				}
			}
			, error: function() {
				console.log("error");
			}
		});
	}
});
</script>
<button id="return">목록으로</button>
<c:if test="${sessionScope.usernick eq board.writer }">
<button id="update">수정</button>
<button id="delete">삭제</button>
<br>
</c:if>
<c:if test="${sessionScope.usernick ne board.writer }">
<button id="recommend">추천</button>
<br>
</c:if>
<form action="/board/comments.do" method="post">
	<input type="text" id="comments" name="comments">
	<input type="hidden" id="boardNo" name="boardNo" value=${board.boardNo }>
	<input type="hidden" id="userid" name="userid" value=${sessionScope.userid }>
	<input type="submit" value="작성">
</form>
<c:if test="${list.size() eq 0 }">
	<h3>댓글이 없습니다</h3>
</c:if>
<c:if test="${list.size() ne 0}">
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="data">
		<tr>
			<td>${data.comments }</td>
			<td>${data.userid }</td>	
			<td>
				<c:if test="${sessionScope.writerid eq comment.userid }">
				<button class="btn btn-default" onclick="deleteComment(${comment.commentNo });">삭제</button>
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
</body>
</html>