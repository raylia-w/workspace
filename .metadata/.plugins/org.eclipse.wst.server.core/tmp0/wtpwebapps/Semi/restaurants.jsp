<%@page import="DTO.MenuDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>푸드뷰</title>
<style type="text/css">
#wrapper{margin:0 auto 0 auto;}
#contents { width: 1000px; margin: 0 auto;}
.clear {height: 0px; clear: both;}
/* .slide_wrap { position:relative; width:100%; height:269px; float:left; margin-right:15px; overflow:hidden; } */
/* .slide_banner { width:100%; height:269px; position:absolute; } */
/* .slide_banner li { width:100%; float:left; } */
/* #slide_banner_navi { position:absolute; top:20px; right:20px; cursor:pointer; } */
/* #slide_banner_navi li { float:left; margin-left:5px; z-index:999; width:10px; height:10px; no-repeat; } */
/* #slide_banner_navi li.usl-current-parent { background-position:0 -10px; } */
#detail_info{float:left;}
.header {display: inline-block;}
table ul {list-style: none;}
caption {display: none;}
.center-croping{float:left;}
</style>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=YiJfocqY2V0PLgrqvSkF&submodules=geocoder"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/js/jquery.ulslide.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#reservation").click(function(){
		location.href="/reservation/reservation.do?s_name=${s.s_name}";
	});
});
// $(function() {
//     $('#slide_banner').ulslide({
//         statusbar: true,
//         width: 1250,    //슬라이드배너 가로사이즈
//         height: 440,     //슬라이드배너 세로사이즈
//         affect: 'slide',   //'fade'로 변경시 이미지가 투명하게 사라지면서 다음이미지가 보여짐
//         axis: 'x',        //슬라이드 방향 x=가로, y=세로
//         navigator: '#slide_banner_navi a',  //페이지네이션
//         duration: 400,
//         autoslide: 5000
//     });
// });
//지도를 삽입할 HTML 엘리먼트 또는 HTML 엘리먼트의 id를 지정합니다.
</script>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="/main/top.jsp"></jsp:include>
	</div>
	<div class="clear"></div>
	<div id="contents">
		<div class="slide_wrap">
			<div id="slide_banner">
				<img class="center-croping" src="/img/fooddetail/${s.s_name }/${s.s_name }1.jpg" width="206" height="206">
				<img class="center-croping" src="/img/fooddetail/${s.s_name }/${s.s_name }2.jpg" width="206" height="206">
				<img class="center-croping" src="/img/fooddetail/${s.s_name }/${s.s_name }3.jpg" width="206" height="206">
			</div>
			<ul id="slide_banner_navi">
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="restaurant_detail">
			<div class="header">
			<div>
			    <span class="title">
			    	<h1>${s.s_name } </h1>
			    	<p></p>
			    </span>
		    </div>
		<div class="status branch_none">
		    <span class="category"><span class="hidden">카테고리: </span>${s.s_type } </span>
<!-- 		    <span class="cnt review"><span class="hidden">리뷰수: </span><span>102</span></span> -->
		</div>
		</div>
		<hr>
		<div class="detail_info" style="float: left;">
			<table class="info">
				<caption>레스토랑 상세 정보</caption>
				<tbody>
					<tr>
						<th>주소</th>
						<td>${s.s_addr }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${s.s_p_no }</td>
					</tr>
					<tr>
						<th>가격(1인)</th>
						<td>${s.s_price }원</td>
					</tr>
					<tr>
						<th>예약</th>
						<c:set var="poss" value="${s.res_poss }"/>
						<c:choose>
						<c:when test="${poss eq '0' }">
						<td>예약 가능</td>
						</c:when>
						<c:otherwise>
						<td>예약 불가</td>
						</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th style="vertical-align:top;">영업시간</th>
						<td>${s.op_time } - ${s.cl_time }</td>
					</tr>
					<tr>
					<th>메뉴</th>
					<td class="menu_td">
					<ul class="Restaurant_MenuList">
						<%
						List<MenuDTO> list = (List<MenuDTO>) request.getAttribute("menu");
						for(int i=0;i<list.size();i++){
							MenuDTO menu = new MenuDTO();
							menu = list.get(i);
						%>
						<li class="Restaurant_MenuItem">
							<span class="Restaurant_Menu"><%=menu.getF_name() %></span>
							<span class="Restaurant_MenuPrice"><%=menu.getF_price() %>원</span>
						</li>
						<%
						}
						%>
					</ul>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		<div class="side-wrap" style="float: right;">
			<div class="column-side">
			<!-- 지도 -->
				<div id="map" style="width:400px;height:328px;">
				</div>
			</div>
			<!-- class="column-side" -->
		</div>
		<script type="text/javascript">
		
		var map = new naver.maps.Map("map", {
		    center: new naver.maps.LatLng(37.3595316, 127.1052133),
		    zoom: 10,
		    mapTypeControl: true
		});

		var infoWindow = new naver.maps.InfoWindow({
		    anchorSkew: true
		});

		map.setCursor('pointer');

		// result by latlng coordinate
		function searchAddressToCoordinate(address) {
		    naver.maps.Service.geocode({
		        address: address
		    }, function(status, response) {
		        if (status === naver.maps.Service.Status.ERROR) {
		            return alert('Something Wrong!');
		        }

		        var item = response.result.items[0],
		            addrType = item.isRoadAddress ? '[도로명 주소]' : '[지번 주소]',
		            point = new naver.maps.Point(item.point.x, item.point.y);

		        infoWindow.setContent([
		                '<div style="padding:10px;min-width:20px;line-height:150%;">',
						'<h5>${s.s_name}</h5>',
		                '</div>'
		            ].join('\n'));


		        map.setCenter(point);
		        infoWindow.open(map, point);
		    });
		}

		function initGeocoder() {

		    searchAddressToCoordinate('${s.s_addr}');
		}

		naver.maps.onJSContentLoaded = initGeocoder;

		
		</script>
		<%
			if(session.getAttribute("id")==null||session.getAttribute("id").equals("")){
		%>
		<button id="reservation" style="width: 100%;" disabled="disabled" title="로그인 후 사용 가능합니다">예약하기</button>
		<%
			}else{
		%>
		<button id="reservation" style="width: 100%;">예약하기</button>
		<%
			}
		%>
		<p class="update_date">업데이트: 2018. 4. 2</p>
		<hr>
		</div>
		<h2 class="title">
		${s.s_name }의 리뷰
		
		<%
			if(session.getAttribute("id")==null||session.getAttribute("id").equals("")){
		%>
		<button id="review_write" disabled="disabled" title="로그인 후 사용 가능합니다">리뷰 작성</button>
		<%
			}else{
		%>
		<a href="/reviewform.do?s_id_no=${s.s_id_no }"><button id="review_write">리뷰 작성</button></a>
		<%
			}
		%>
		</h2>
		<hr>
		<div class="review-item">
		<c:forEach items="${pList }" begin="0" end="${pList.size() }" var="i">
			<div class="review-conten`t">
				<figure class="user big">
				<figcaption>${i.id }</figcaption>
				</figure>
				<div class="review_wraper">
					<span class="short_review more_review_bind review_content" data-language="kor">
					${i.p_name }
			        </span>
			        <span class="sub-info">
			        	<time datetime="">
			        	<span class="past-time ng-binding" ng-bind="from_date('2018-03-26 15:13:01')">${i.p_date }</span>
						<!-- 글 작성 시간 -->
			        	</time>
			        </span>
			        <div class="list-thumb-photos">
			        </div>
		    	</div>
		    	<a href="/PostShopDt.do?p_no=${i.p_no }">자세히 보기</a>
			</div>
		</c:forEach>
		</div>
		<hr>
	</div>
	<div class="clear"></div>
	<div id="footer">
			<jsp:include page="/main/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>