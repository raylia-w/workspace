package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDao;
import DAO.PaymentBoardDaoImpl;
import DTO.PaymentDTO;
import Service.Paging;

@SuppressWarnings("serial")
@WebServlet("/manager/paymentlist.do")
public class PaymentBoardList extends HttpServlet {
	
	private BoardDao dao = new PaymentBoardDaoImpl();
	Paging paging = null;	// 페이징 객체

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PaymentDTO> list = null;	// 게시물 리스트
		
		// 요청파라미터에서 페이징 번호 얻기
		String pageParam = req.getParameter("pageNo");
		int pageNo = 0;
		if(pageParam != null)	pageNo = Integer.parseInt(pageParam);
	
		// 페이징 로직 처리
		int totalCount = dao.getTotal();	// 총 게시물 수
		if(totalCount != 0) {
			paging = new Paging(totalCount, pageNo);	// 총 게시물수와 페이지번호를 이용한 페이징 객체 생성
			list = dao.getList(paging);	// 페이지에 맞는 게시물 가져오기
		}

		// 페이징 정보와 게시물 정보 모델로써 전달하기 
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		// list 페이지 불러오기
		req.getRequestDispatcher("/manager/list/paymentboard/list.jsp")
			.forward(req, resp);
	}
}
