package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.MemberService;

@WebServlet("/MmemberDelete.do")
public class MmemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService mService = new MemberService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("u_no");
		int mid = Integer.parseInt(id);
		
		int result = mService.deleteMember(mid);
		
		String message="삭제되지 않았습니다";
		
		if (result>0){
			message="삭제되었습니다";
		}
		
		out.println("<script>");
		out.println("alert('"+message+"');");
		out.println("location.replace('/manager/memberlist.do')");
		out.println("</script>");
	}
}
