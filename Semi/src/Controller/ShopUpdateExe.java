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

@WebServlet("/ShopUpdateExe.do")
public class ShopUpdateExe extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		ShopDTO dto = new ShopDTO();
		ShopService service = new ShopService();
		PrintWriter out = response.getWriter();
		
		System.out.println("id:" + request.getParameter("s_id_no"));
		
		dto.setS_name(request.getParameter("sName"));
		dto.setS_addr(request.getParameter("sAddress"));
		dto.setS_p_no(request.getParameter("sPhone_#"));
		dto.setS_type(request.getParameter("sType"));
		dto.setS_price(Integer.parseInt(request.getParameter("sPrice")));
		dto.setOp_time(request.getParameter("sOpen_time"));
		dto.setCl_time(request.getParameter("sClose_time"));
		dto.setRes_poss(request.getParameter("sPoss"));
		dto.setS_holiday(request.getParameter("sHoli"));
		dto.setS_id_no(Integer.parseInt(request.getParameter("sID")));
						
		service.updateShopExe(dto);
		
		out.println("<script>");
		out.println("alert('음식점 정보가 수정되었습니다')");
		out.println("location.replace('/manager/shoplist.do')");
		out.println("</script>");
		
		
	}

}
