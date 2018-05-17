package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.MenuDTO;
import DTO.PostDTO;
import DTO.ShopDTO;
import Service.MenuService;
import Service.PostList;
import Service.ReservationService;
import Service.ReservationServiceImpl;
import Service.ShopService;

@WebServlet("/restaurantsinfo.do")
public class InfoPage extends HttpServlet {
	private ShopDTO shop = new ShopDTO();
	private ArrayList<MenuDTO> menu = new ArrayList<>();
	private  ShopService sService = new ShopService();
	private MenuService mService = new MenuService();
	private PostDTO post = new PostDTO();
	private PostList pList = new PostList();
	private ArrayList<PostDTO> list = new ArrayList<>();
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int s_id_no = Integer.parseInt(request.getParameter("restaurant"));
		shop = sService.selectShop(s_id_no);
//		int s_id_no = Integer.parseInt(shop.getS_id_no());
		menu = mService.menuList(s_id_no);
		list = pList.execute(request, response, s_id_no);
		
		request.setAttribute("menu", menu);
		request.setAttribute("s", shop);
		request.setAttribute("pList", list);
		
		request.getRequestDispatcher("/restaurants.jsp").forward(request, response);
	}
}
