package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.MemberService;
import Service.PaymentService;

@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MemberService mService = new MemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		
		int result = mService.updateMember(id, pw, name, nick, phone, email, addr);
		
		if(result>0) {
			out.println("<script>");
			out.println("alert('회원 정보가 수정되었습니다')");
			out.println("location.replace('/mypage.do')");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 정보 수정에 실패했습니다')");
			out.println("location.replace('/mypage.do')");
			out.println("</script>");
		}
		
	}
}
