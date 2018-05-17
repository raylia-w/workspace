package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.PostAlter;
import Service.PostCommand;
import Service.PostDetail;
import Service.PostList;
import Service.PostPage;
import Service.PostSearch;
import Service.PostShop;
import Service.PostWrite;
import Service.Search;

@WebServlet("*.do")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost( request, response );
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String address = requestURI.substring(contextPath.length());
		
		RequestDispatcher rd = null;
		
		PostCommand command = null;
		String page = null;
		
//		// 게시물 작성 폼으로
//		if(address.equals("/postwrite.do")) {
//			page = "/21_postWrite.jsp";
//			rd = request.getRequestDispatcher(page);
//			rd.forward(request, response);
//		}
//		
		if(address.equals("/reviewform.do")) {
			page = "/21_postWrite.jsp";
			int s_id_no = Integer.parseInt(request.getParameter("s_id_no"));
			String name = request.getParameter("name");
			request.setAttribute("no", s_id_no);
			request.setAttribute("name", name);
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
//		
//		// 작성 후엔 다시 리스트로
//		if(address.equals("/write.do")) {
//			command = new PostWrite();
//			HttpSession session = request.getSession();
//			String id = (String) session.getAttribute("id");
//			command.execute(request, response, id);
//			page = "/postlist.do";
//		}
		
		if(address.equals("/reviewwrite.do")) {
			command = new PostWrite();
			HttpSession session = request.getSession();
			int s_id_no = Integer.parseInt(request.getParameter("s_id_no"));
			String id = (String) session.getAttribute("id");
			command.execute(request, response, id, s_id_no);
			response.sendRedirect("/restaurantsinfo.do?restaurant="+s_id_no);
		}
		
		// 리스트 클릭 후 상세 리뷰로
		if(address.equals("/postDetail.do")) {
			command = new PostDetail();
			command.execute(request, response);
			page = "/21_postDetail.jsp";
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		// 상세 리뷰 페이지에서 글수정 가능
		if(address.equals("/postAlter.do")) {
			command = new PostAlter();
			command.execute(request, response);
			page = "/postlist.do";
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}
		
		// 게시물 리스트에 페이지 넘기기 추가
		if(address.equals("/postlist.do")) {
			command = new PostPage();
			command.execute(request, response);
			page = "/21_postPage.jsp";
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		// 게시물 검색 기능(음식점 이름, 음식 이름으로 게시물 검색)
		if(address.equals("/postsearch.do")) {
			command = new PostSearch();
			command.execute(request, response);
			page = "/main/searchResult.jsp";
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		if(address.equals("/search.do")) {
			command = new Search();
			command.execute(request, response);
			page = "/main/searchResult.jsp";
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		if(address.equals("/PostShopDt.do")) {
          command = new PostShop();
          command.execute(request, response);
          page = "/reviewDetail.jsp";
          rd = request.getRequestDispatcher(page);
          rd.forward(request, response);
		}
	}

}
