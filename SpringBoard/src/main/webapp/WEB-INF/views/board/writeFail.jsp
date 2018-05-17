<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function list(){
	history.back(-1);
}
function login(){
	location.href="/member/login.do";
}
function join(){
	location.href="/member/join.do";
}
</script>
</head>
<body>
<h1>로그인한 회원만 가능합니다</h1>
<button onclick="login()">로그인</button>
<button onclick="join()">회원가입</button>
<button onclick="list()">목록으로</button>
</body>
</html>