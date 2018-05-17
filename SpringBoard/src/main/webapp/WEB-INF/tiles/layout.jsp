<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
<style type="text/css">
.wrap{
	width:1200px;
}
.header{
	border:1px solid red;
}
.footer{
	border:1px solid blue;
}
</style>
</head>
<body>
<div class="wrap">
<!-- header -->
<tiles:insertAttribute name="header"/>
<!-- body -->
<tiles:insertAttribute name="body"/>
<!-- footer -->
<tiles:insertAttribute name="footer"/>
</div>
</body>
</html>