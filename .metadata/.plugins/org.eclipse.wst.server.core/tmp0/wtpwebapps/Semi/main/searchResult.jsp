<%@page import="DTO.ShopDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.clear {height: 0px; clear: both;}
#wrapper{margin:0 auto 0 auto;}
#contents { width: 1000px; margin: 0 auto;}
li{
	text-decoration: none;
	list-style: none;
}

.info {
width: 850px;
height: 100px;
margin: 20px;
float: left; 
}
</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="/main/top.jsp"></jsp:include>
	</div>
	<div class="clear"></div>
	<div id="contents">
		<ul>
		<c:forEach items="${list}" var="dto">
		<li>
		<div class="info">
			<span class="title"><a href="/PostShopDt.do?p_no=${dto.p_no}">${dto.p_name}</a></span>&nbsp;&nbsp;&nbsp;
			<small class="writer">작성자 : ${dto.id }</small>&nbsp;&nbsp;
			<small class="date">작성일 : ${dto.p_date }</small>
		</div>
		</li>
		</c:forEach>
		</ul>
	</div>
</div>
<div class="clear"></div>
<div id="footer">
	<jsp:include page="/main/footer.jsp"></jsp:include>
</div>
</body>
</html>