package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.PostDTO;
import Service.PostWrite;

@WebServlet("/Question.do")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostWrite postWriter = new PostWrite();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		PostDTO post = new PostDTO();
//		post.setP_name(request.getParameter("p_name"));
//		post.setP_main(request.getParameter("p_main"));
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		postWriter.execute(request, response, id);
		
		response.sendRedirect("/mypage/myfaqlist.do");
	}
}
