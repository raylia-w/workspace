package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ShopDTO;
import Service.ShopService;

@WebServlet("/ShopDelete.do")
public class ShopDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ShopDTO dao = new ShopDTO();
		ShopService ss = new ShopService();
		PrintWriter out = response.getWriter();
		
		String sidno = request.getParameter("s_id_no");
		int s_id_no = Integer.parseInt(sidno);
	
		dao = ss.deleteShop(s_id_no);
		
		out.println("<script>");
		out.println("alert('음식점이 삭제되었습니다')");
		out.println("location.replace('/manager/shoplist.do')");
		out.println("</script>");		
		
	}

}