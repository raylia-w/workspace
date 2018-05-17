<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>푸드뷰</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#cafe").mouseenter(function(){
		$("#cafeTitle").css("display", "block");
	});
	$("#krFood").mouseenter(function(){
		$("#krFoodTitle").css("display", "block");
	});
	$("#jpFood").mouseenter(function(){
		$("#jpFoodTitle").css("display", "block");
	});
	$("#wsFood").mouseenter(function(){
		$("#wsFoodTitle").css("display", "block");
	});
	$("#chFood").mouseenter(function(){
		$("#chFoodTitle").css("display", "block");
	});
	$("#snack").mouseenter(function(){
		$("#snackTitle").css("display", "block");
	});
	$("#drink").mouseenter(function(){
		$("#drinkTitle").css("display", "block");
	});
	
	$("#cafe").mouseleave(function(){
		$("#cafeTitle").css("display", "none");
	});
	$("#krFood").mouseleave(function(){
		$("#krFoodTitle").css("display", "none");
	});
	$("#jpFood").mouseleave(function(){
		$("#jpFoodTitle").css("display", "none");
	});
	$("#wsFood").mouseleave(function(){
		$("#wsFoodTitle").css("display", "none");
	});
	$("#chFood").mouseleave(function(){
		$("#chFoodTitle").css("display", "none");
	});
	$("#snack").mouseleave(function(){
		$("#snackTitle").css("display", "none");
	});
	$("#drink").mouseleave(function(){
		$("#drinkTitle").css("display", "none");
	});
});
</script>
<style type="text/css">
table{
	clear:both;
	margin:auto;
}
#category{
	clear:both;
}
#aside{ 
	float:left;
 	background-color:#ffa12c; width:auto; height:auto; 
 } 

.img { 
	border : 0;
	width: 100%;
	height: 100%;
	background-size: 100% 100%;
 }

.img:hover {

	opacity:0.6;
	
	filter:alpha(opacity=60); /* For IE8 and earlier */

}
h1{
 	 position: relative;
     top:50%;
     left:50%;
 	 transform: translate(-50%, -50%);                                                       
/*      font-size:5rem; */
     color: white;
/*      z-index: 2; */
     text-align: center;
     display:none;
}

</style>
</head>
<body>
<div id="wrapper">
<!-- 	<div id="aside"> -->
<!-- 		좌측 메뉴 -->
<!-- 	</div> -->
	<div id="category">
		<table width="100%">
		  <tbody><tr>
		    <td height="585" bgcolor="#f5eedb"><table width="1000" align="center">
		    	<tbody><tr>
			        <td>&nbsp;</td>
			        <td width="195" height="195" style="vertical-align: middle;">
			        <div id="cafe" class="img" style="background-image: url(/img/mainPic/coffee2.jpg);" onclick="location.href='/toplist.do?type=카페'">
			        <h1 id="cafeTitle">카페</h1>
			        </div>
			        </td>
			        <td height="195" width="390" colspan="2">
			        <div id="krFood" class="img" style="background-image: url(/img/mainPic/KrFood.png);" onclick="location.href='/toplist.do?type=한식'">
					<h1 id="krFoodTitle">한식</h1>
			        </div>
			        </td>
			        <td>&nbsp;</td>
		      	</tr>
		      	<tr>
			        <td>&nbsp;</td>
			        <td width="195" height="195">
			        <div id="jpFood" class="img" style="background-image: url(/img/mainPic/susi.jpg);" onclick="location.href='/toplist.do?type=일식'">
			        <h1 id="jpFoodTitle">일식</h1>
			        </div>
			        </td>
			        <td width="195" height="195">
			        <div id="drink" class="img" style="background-image: url(/img/mainPic/drink.jpg)" onclick="location.href='/toplist.do?type=술집'">
			        <h1 id="drinkTitle">술집</h1>
			        </div>
			        </td>
			        <td width="195" height="195">
			        <div id="wsFood" class="img" style="background-image: url(/img/mainPic/meat.jpg);" onclick="location.href='/toplist.do?type=양식'">
			        <h1 id="wsFoodTitle">양식 </h1>
			        </div>
			        </td>
			        <td>&nbsp;</td>
		      	</tr>
		     	<tr>
			        <td>&nbsp;</td>
			        <td height="195" width="390" colspan="2">
			        <div id="chFood" class="img" style="background-image: url(/img/mainPic/china2.jpg);" onclick="location.href='/toplist.do?type=중식'">
			        <h1 id="chFoodTitle">중식</h1>
			        </div>
			        </td>
			        <td width="195" height="195">
			        <div id="snack" class="img" style="background-image: url(/img/mainPic/snack.jpg);" onclick="location.href='/toplist.do?type=분식'">
			        <h1 id="snackTitle">분식 </h1>
			        </div>
			        </td>
			        <td>&nbsp;</td>
		      	</tr>
				</tbody>
			</table></td>
		  </tr></tbody>
		</table>
	</div>
</div>
</body>
</html>