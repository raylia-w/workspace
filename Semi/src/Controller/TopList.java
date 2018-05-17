package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ShopDTO;
import Service.ShopService;

@SuppressWarnings("serial")
@WebServlet("/toplist.do")
public class TopList extends HttpServlet {
	private ShopService sService = new ShopService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		ArrayList<ShopDTO> s = sService.selectShopList(type);
		
		req.setAttribute("list", s);
		
		// list 페이지 불러오기
		req.getRequestDispatcher("/topList/topList.jsp").forward(req, resp);
	}
}
