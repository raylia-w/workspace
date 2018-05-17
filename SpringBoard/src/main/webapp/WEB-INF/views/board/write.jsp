<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>글쓰기</h1>
<hr>
<form id="form" action="/board/write.do" method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="title">제목 : <input type="text" id="title" name="title"></label>
</div>
<div class="form-group">
<input type="hidden" id="id" name="id" value=${sessionScope.userid }>
<label for="writer">작성자<input type="text" id="writer" name="writer" value="${writer }" readonly="readonly"></label>
</div>
<hr>
<div class="form-group">
<input type="file" id="file" name="file"/>
<textarea id="content" name="content" cols="40" rows="8"></textarea><br>
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
	$("#btnWrite").click(function() {
		submitContents($(this));
		console.log("버튼 클릭");
	});
});
</script>
<input type="button" id="btnWrite" class="center-block" value="작성 완료">
</form>
</body>
</html>