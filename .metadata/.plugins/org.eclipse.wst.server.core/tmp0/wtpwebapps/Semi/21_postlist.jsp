<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>

<h2>게시물 리스트</h2>
<hr><br>
<table border="1">
	<tr>
		<td colspan="5">
		 <form action="/postsearch.do" >
		  <input type="hidden"  name="action" value="search">
				<select name="searchName" size="1">
					<option value="shopSearch">음식점명</option>
					<option value="foodSearch">음식명</option>
					
            </select>
				<input type="text"  name="searchValue" >
				<input type="submit" value="검색">
          </form>
		</td>
	</tr>
    <tr>
	   <td>번호</td>
	   <td>제목</td>
	   <td>작성자</td>
	   <td>날짜</td>
	   <td>평점</td>
	</tr>
<c:forEach items="${list}" var="dto">
   	<tr>
	   <td>${dto.p_no}</td>
	   <td><a href="postDetail.do?p_no=${dto.p_no}">${dto.p_name}</a></td>
	   <td>${dto.u_no}</td>
	   <td>${dto.p_date}</td>
	   <td>${dto.p_score}</td>
	</tr>
</c:forEach>

	 </table>
<hr>
<a href="/postwrite.do">글쓰기</a>
<a href="/postlist.do">목록</a>

</div>


</body>
</html>