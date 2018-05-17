package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReservationDAO;
import DAO.ReservationDAOImpl;
import DTO.ReservationDTO;
import DTO.ShopDTO;
import Service.Paging;

@WebServlet("/mypage/myreservation.do")
public class ReservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReservationDAO resDao = new ReservationDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Paging paging = null; // 페이징 객체
		List<ReservationDTO> resList = null; // 예약 리스트
		ShopDTO shop = null;
		String id = (String) session.getAttribute("id");
		String pageParam = request.getParameter("pageNo");
		int pageNo = 0;
		if(pageParam != null) pageNo = Integer.parseInt(pageParam);
		
		// 페이징 로직 처리
		int totalCount = resDao.getTotal();
		if(totalCount != 0) {
			paging = new Paging(totalCount, pageNo); // 총 게시물 수와 페이지 번호를 이용한 페이지 생성
			resList = resDao.getList(paging, id); // 페이지에 맞는 게시물 가져오기
			
		}
		
		// 페이지 정보와 게시물 정보 모델로써 전달하기
		request.setAttribute("paging", paging);
		request.setAttribute("resList", resList);
		
		// resList 페이지 불러오기
		request.getRequestDispatcher("/mypage/reservationList.jsp").forward(request, response);
	}

}

