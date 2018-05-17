package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Member;
import Service.MemberService;

@WebServlet("/LoginCheckServlet.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService mService = new MemberService();
	private Member m = new Member();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8;");
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		m.setID(id);
		m.setPassword(pw);
		PrintWriter out = response.getWriter();
		
		if (mService.isMember(m)){
			session.setAttribute("id", m.getID());
			session.setAttribute("pw", m.getPassword());
			
			out.print("true");

		}else {
			out.print("false");
		}
	}
}
