<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>

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
    
            editor_object.getById["p_main"].exec("LOAD_CONTENTS_FIELD", []);

            $("#submit_btn").click(function(){
                editor_object.getById["p_main"].exec("SET_IR", [""]); //내용초기화
                editor_object.getById["p_main"].exec("PASTE_HTML", [tmpContent]); //내용밀어넣기
                $("#frm").submit();
            })
            
})

</script>	
	

<h2>게시물 수정</h2>
  <form id="frm" name="frm" action="postAlter.do" method="post">
   <input type="hidden" name="p_no" value="${postDetail.p_no}">
	글번호: ${postDetail.p_no} <br>
	제목<input type="text" name="p_name" value="${postDetail.p_name}"><br>
	작성자<input type="number" name="u_no" value="${postDetail.u_no}"><br>
	내용<textarea id="p_main" name="p_main" rows="10" style="width:100%; height:600px; min-width:900px; display:none;">${postDetail.p_main}</textarea><br>
	
	
  </form>
 <a href="alter.do">수정</a>
 <a href="postlist.do">취소</a>

</body>
</html>