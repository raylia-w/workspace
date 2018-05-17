<%@page import="DTO.ShopDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>푸드뷰</title>
<link rel="stylesheet" type="text/css" href="/css/mypage.css" />
<style type="text/css">
/* .clear {height: 0px; clear: both;} */
#wrapper{margin:0 auto 0 auto;}
#contents { width: 1000px; margin: 0 auto;}
li{
	text-decoration: none;
	list-style: none;
}
small{float: right;} 
.thumb {
float: left;
}
.info {
width: 850px;
height: 250px;
margin: 40px;
/* float: left; */
}
.with-review {
    position: relative;
    min-height: 238px;
    overflow: hidden;
}

html, body, div, span, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, address, cite, code, del, dfn, em, font, img, ins, q, s, samp, strike, strong, sub, sup, dl, dt, dd, ol, ul, li, fieldset, form, label, legend {
    border: 0 none;
}

* {
    margin: 0;
    padding: 0;
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
<div class="basic-info-list">
	<div class="inner" style="padding-bottom: 10px; text-align: center;" >
	<%
	String type=request.getParameter("type");
	if(type.equals("카페")){
	%>
        <h1 class="title">카페 베스트</h1>
        <h2 class="desc">
        	“카페는 정해져있고 넌 따라오기만 해”
        </h2>
    <%
	}else if(type.equals("한식")){
    %>
    	<h1 class="title">한식</h1>
        <h2 class="desc">
        	“어느 나라든 따뜻한 가정식이 최고야!”
        </h2>
        <%
	}else if(type.equals("일식")){
    %>
    	<h1 class="title">일식</h1>
        <h2 class="desc">
        	“일본을 제대로 느끼고 싶다면 이곳!”
        </h2>
        <%
	}else if(type.equals("중식")){
    %>
    	<h1 class="title">중식</h1>
        <h2 class="desc">
        	“여기가 중국이로구나~”
        </h2>
        <%
	}else if(type.equals("양식")){
    %>
    	<h1 class="title">양식</h1>
        <h2 class="desc">
        	“이게 다 무어란~? ( ͡° ͜ʖ ͡°)”
        </h2>
        <%
	}else if(type.equals("분식")){
    %>
    	<h1 class="title">분식</h1>
        <h2 class="desc">
        	“올해는 나도 인플루언서”
        </h2>
        <%
	}else if(type.equals("술집")){
    %>
    	<h1 class="title">술집</h1>
        <h2 class="desc">
        	“술이 안주를 부르고, 안주가 술을 부르는”
        </h2>
	<%
	}
	%>
	</div>
	<hr>
	<br>
	<br>
	<ul>
	<%
		List<ShopDTO> s = (List<ShopDTO>) request.getAttribute("list");
		for(int i=0;i<s.size();i++){
			ShopDTO shop = new ShopDTO();
			shop = s.get(i);
	%>
	<li class="toplist_list">
		<div class="with-review">
			<figure class="restaurant-item">
			<div class="thumb" style="display:inline-block; float:left; margin-right: 30px;">
				<a href="/restaurantsinfo.do?restaurant=<%=shop.getS_id_no() %>"><img src="/img/foodPic/<%=shop.getS_name()%>.jpg" width="206" height="206"></a>
			</div>
			<figcaption>
			<div class="info">
				<!-- 식당이름 -->
				<br>
				<span class="title"><a href="/restaurantsinfo.do?restaurant=<%=shop.getS_id_no() %>" onclick=""><h2><%=shop.getS_name() %></h2></a></span>
				<!-- 식당주소 -->
				<br><br><br>
				<p class="etc"><%=shop.getS_addr() %></p>
				<p class="etc"><%=shop.getS_p_no() %></p>
			<br><br><br><br>
			<a href="/restaurantsinfo.do?restaurant=<%=shop.getS_id_no() %>" class="btn-detail" onclick=""><small><%=shop.getS_name() %> 더보기 &gt;</small></a>
			
			</div>
			</figcaption>
			</figure>
			
		</div>
		<hr>
		<br>
	</li>
	
	<%
		}
	%>
	</ul>
	</div>
</div>
</div>
<div class="clear"></div>
<div id="footer">
	<jsp:include page="/main/footer.jsp"></jsp:include>
</div>
</body>
</html>