<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="/SE2/js/HuskyEZCreator.js" charset="UTF-8"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>



<script type="text/javascript">

$(function(){
    //전역변수선언
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "p_main",
        sSkinURI: "/SE2/SmartEditor2Skin.html",
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,            
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,    
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true,
        }
    });
     
    $("btn_confirm").click(function(){
    	
    	
    })
	
    //전송버튼 클릭이벤트
    $("#submit_btn").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["p_main"].exec("UPDATE_CONTENTS_FIELD", []);
         
        //폼 submit
        $("#frm").submit();
    })
    
	// textArea에 이미지 첨부
	$(function pasteHTML(filepath) {
    	var sHTML = '<img src="/E:/testFolder'+filepath+'">';
    	editor_object.getById["p_main"].exec("PASTE_HTML", [sHTML]);
	})
})

</script>
<title>푸드뷰</title>
<h2>게시물 작성</h2>
<form id="frm" action="/reviewwrite.do?s_id_no=${no }&name=${name}" method="post">
	제목<input type="text" id="p_name" name="p_name"><br />

	내용
	<textarea id="p_main" name="p_main" rows="5" style="width:100%; height:600px; min-width:900px; display:none;"></textarea>
	<br>
	<br>

	<input id="submit_btn" name="submit_btn" type="submit" value="저장">
</form>
<hr>
<!-- <a href="/postwrite.do">글쓰기</a> -->
<!-- <a href="/postlist.do">목록</a> -->

