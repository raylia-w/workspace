package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Manager;
import Service.MemberService;

@WebServlet("/ManagerLoginCheckServlet.do")
public class ManagerLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Manager dto = new Manager();
	private MemberService Service = new MemberService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();	
		
		dto.setID(id);
		dto.setPassword(pw);
		
		if (Service.isManager(dto)) {
			session.setAttribute("id", dto.getID());
			session.setAttribute("pw", dto.getPassword());
			out.print("true");
			
		} else {
			out.print("false");
		}
	
	
	
	
	}

}
