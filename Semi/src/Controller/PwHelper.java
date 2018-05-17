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

@WebServlet("/PwHelper.do")
public class PwHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberService();
		Member m = new Member();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("pw_name");
		String pno = request.getParameter("pw_phone");
		m = mService.selectMember(id, name, pno);
		String resultPw = m.getPassword();
		
		if(resultPw!=null){
			out.println("<script>");
			out.println("alert('비밀번호 : "+resultPw+"');");
			out.println("location.href='/mypage/help.jsp';");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('회원 정보가 없습니다');");
			out.println("location.href='/mypage/help.jsp';");
			out.println("</script>");
		}
	}
}
