<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="DTO.PageDTO" %>

<%
	PageDTO pto = (PageDTO)request.getAttribute("page");
	int curPage = pto.getCurPage();	// 현재 페이지(기본값=1)
	int perPage = pto.getPerPage();	// 한 페이지당 보여줄 게시물 수
	int totalPost = pto.getTotalPost();	// DB에 저장된 게시물 수
	
	int totalPage = totalPost / perPage;	// 한번에 표시될 페이지 수
	
	if(totalPost % perPage != 0) {
		totalPage++;
	}
	
	// for문으로 1~최대 페이지까지 생성
	for( int i=1; i <= totalPage; i++) {
		
		if(curPage == i) {
			out.print("<font color='red'>"+i+"</font>");
		} else {
			out.print("<a href='postlist.do?curPage="+i+"'>"+i+"</a>&nbsp;&nbsp;&nbsp;");
		}
		
	}
%>	