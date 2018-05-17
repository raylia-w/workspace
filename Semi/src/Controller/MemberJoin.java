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

@WebServlet("/MemberJoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Member m = new Member();
	private MemberService mService = new MemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		String g = request.getParameter("gender");
		int gender;
		if(g=="M") {
			gender = 0;
		}else {
			gender = 1;
		}
		
		m.setuName(request.getParameter("uName"));
		m.setuId(request.getParameter("uIdNum"));
		m.setID(request.getParameter("uId"));
		m.setPassword(request.getParameter("pw"));
		m.setuPNo(request.getParameter("pno"));
		m.setuAddr(request.getParameter("addr"));
		m.setuEmail(request.getParameter("email"));
		m.setuNick(request.getParameter("nick"));
		m.setuGender(gender);

		mService.addMember(m);
		
		out.println("<script>");
		out.println("alert('회원가입이 완료되었습니다')");
		out.println("location.replace('/00_Main.jsp')");
		out.println("</script>");
	}
}
