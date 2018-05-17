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

    		// 상세리뷰 페이지 접근시 DB에서 내용을 불러온다.
			window.onload = function() {
				
            editor_object.getById["p_main"].exec("LOAD_CONTENTS_FIELD", []);
			}
            
    		// 스마트 에디터 폼으로 불러오기 때문에 수정은 언제나 가능하지만 적용은 수정버튼을 눌렀을 때만 가능하다.
    		// 따라서 수정버튼 생성에 대한 접근자 식별이 필요하다. ex) 강사님표 페이징
            $("#submit_btn").click(function(){
                editor_object.getById["p_main"].exec("UPDATE_CONTENTS_FIELD", []);
                 
                $("#frm").submit();
            })
})

</script>	
	

<h2>게시물 상세/수정</h2>
  <form id="frm" name="frm" action="/postAlter.do" method="post">
   <input type="hidden" name="p_no" value="${postDetail.p_no}">
	글번호: ${postDetail.p_no} <br>
	제목<input type="text" name="p_name" value="${postDetail.p_name}"><br>
	작성자<input type="number" name="u_no" value="${postDetail.u_no}"><br>
<!-- 	<input type="submit" id="submit_btn" name="submit_btn" value="수정" /><br><br> -->
	내용<textarea id="p_main" name="p_main" rows="10" style="width:100%; height:600px; min-width:900px; display:none;">${postDetail.p_main}</textarea><br>
	
	
  </form>
<!--  <a href="postlist.do">목록</a> -->
 
 
</body>
</html>