<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style>
#wrapper{
	margin: 0 auto;
}
#contents{
	width: 70%;
	height: 450px;
	padding: 10px;
	margin-left: 15%;
 	margin-top: 20px; 
 	/* overflow: auto; */
}
p{
	margin-bottom:10px;
}
</style>
</head>
<body>


<div id="wrapper">
	<jsp:include page="/main/top.jsp" />

	<div id="contents">
		<h1>
<!-- 		&nbsp;제&nbsp;&nbsp;&nbsp;목 :&nbsp; -->
		${postshop.p_name }</h1><br>
<%-- 		<label>&nbsp;제&nbsp;&nbsp;&nbsp;목 :&nbsp;${postDetail.p_name }</label> --%>
 		<label>&nbsp;작 성 자 :&nbsp;${postshop.id}</label>
		<label style="float:right; margin-right:60px;">업데이트 일자 : ${postshop.p_date }</label>
 		<hr style="width:95%; margin-top:15px; margin-bottom:15px;">
 		<p>&nbsp;내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용 : </p>
 		&nbsp;&nbsp;${postshop.p_main }
	<br>	
	</div>
<!-- 	<a href="/postlist.do"><input type="button" id="golist" name="golist" value="리뷰목록"></a> -->
	<c:if test="${sessionScope.id eq postshop.id }">
<%-- 	<a href="/postDetail.do?p_no=${postshop.p_no }"><input type="button" id="edit" name="edit" value="수정"></a> --%>
	</c:if>	<br><br><br>
	
	<div id="footer">
		<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>