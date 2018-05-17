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
import Service.PaymentService;


@WebServlet("/IdHelper.do")
public class IdHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService mService = new MemberService();
	private Member m = new Member();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		String name = request.getParameter("id_name");
		String pno = request.getParameter("id_phone");
		m = mService.selectMember(name, pno);
		String resultId = m.getID();
		
		if(resultId!=null){
			out.println("<script>");
			out.println("alert('아이디 : "+resultId+"');");
			out.println("location.href='/01_help.jsp';");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('회원 정보가 없습니다');");
			out.println("location.href='/01_help.jsp';");
			out.println("</script>");
		}
	}
}
