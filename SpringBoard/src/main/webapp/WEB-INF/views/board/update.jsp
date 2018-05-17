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
<form action="/board/update.do" method="post" id="form">
<div class="form-group">
<label for="title">제목 : <input type="text" id="title" name="title" value="${board.title }" readonly="readonly"></label>
</div>
<div class="form-group">
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
<div class="form-group">
<textarea id="content" name="content" cols="40" rows="20"></textarea><br>
</div>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "content",
    sSkinURI: "/resources/smarteditor/SmartEditor2Skin.html",
    fCreator: "createSEditor2",
    htParams : {
    	bUseToolbar: true, // 툴바 사용여부
    	bUseVerticalResizer: false, //입력창 크기 조절바
    	bUseModeChanger: true //모드 탭
    }
});

//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents(elClickedObj) {
    // 에디터의 내용이 textarea에 적용된다.
    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

    // 에디터의 내용에 대한 값 검증은 이곳에서
    // document.getElementById("ir1").value를 이용해서 처리한다.
    try {
        $("#form").submit();
    } catch(e) {}
}

$(document).ready(function() {
	$("#update").click(function() {
		submitContents($(this));
	});
	$("#return").click(function(){
		history.back(-1);
	});
});
</script>
</form>
<button id="update">제출</button>
<button id="return">목록으로</button>
</body>
</html>