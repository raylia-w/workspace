package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.PostDTO;
import Service.PostService;

@WebServlet("/PostDelete.do")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PostService Service = new PostService();
		PrintWriter out = response.getWriter();
				
		String pno = request.getParameter("p_no");
		String id = (String) request.getSession().getAttribute("id");
		int p_no = Integer.parseInt(pno);
		
//		System.out.println(request.getParameter("p_no"));
//		System.out.println(p_no);
				
		Service.deletePost(p_no);
		
		out.println("<script>");
		out.println("alert('게시글이 삭제되었습니다')");
		if(!id.equals("admin")) {
			if(p_no>5000) {
				out.println("location.replace('/mypage/myfaqlist.do')");
			}else {
				out.println("location.replace('/mypage/myreview.do')");
			}
		}else {
			if(p_no>5000) {
				out.println("location.replace('/manager/faqlist.do')");
			}else {
				out.println("location.replace('/manager/postlist.do')");
			}
		}
		out.println("</script>");
		
		
	}

}
