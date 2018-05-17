package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ShopDAO;
import DTO.ShopDTO;
import Service.ShopService;

@WebServlet("/ShopUpdate.do")
public class ShopUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
		ShopDTO dto = new ShopDTO();
		ShopService service = new ShopService();
				
		String sidno = request.getParameter("s_id_no");
		int s_id_no = Integer.parseInt(sidno);
	
		dto = service.updateShop(s_id_no);
		
//		ArrayList<Shop> list = new ArrayList<>();
//		list = dao.updateShop(s_id_no);
				
		request.setAttribute("s", dto);
		
		// list 페이지 불러오기
		request.getRequestDispatcher("/manager/list/shopboard/listmodified.jsp")
			.forward(request, response);
			
	}

}