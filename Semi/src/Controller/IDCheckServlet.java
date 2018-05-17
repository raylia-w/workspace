package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Member;
import Service.MemberService;

@WebServlet("/idCheck.do")
public class IDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService mService = new MemberService();
	private Member m = new Member();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json; charset=utf-8;");
		
		m.setID(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		
		if(mService.isNew(m)) {
			out.print("true");
		}else {
			out.print("false");
		}
	}
}
