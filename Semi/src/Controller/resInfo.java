package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DAO.MemberDAOImpl;
import DTO.Member;
import DTO.ReservationDTO;
import DTO.ShopDTO;

@WebServlet("/resInfo.do")
public class resInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO mm = new MemberDAOImpl();
	private Member m = new Member();
	private ShopDTO s = new ShopDTO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		String id = request.getParameter("id");
		m=mm.selectMember(id);
		String name = m.getuName();
		String tel = m.getuPNo();
		String addr = m.getuAddr();
		String email = m.getuEmail();
		
		int price = Integer.parseInt(request.getParameter("price"));
		String res_id = request.getParameter("res_id");
		String s_name = request.getParameter("s_name");
		String encoded = URLEncoder.encode(s_name, "UTF-8");
		out.println("<script>");
		out.println("location.replace('/pay.jsp?name="+name+"&tel="+tel+"&addr="+addr+"&email="+email+"&amount="+price+"&s_name="+URLEncoder.encode(encoded, "UTF-8")+"&res_id="+res_id+"');");
		out.println("</script>");
		
	}

}
