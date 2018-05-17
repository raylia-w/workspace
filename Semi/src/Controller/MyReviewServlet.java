package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDao;
import DAO.MemberDAO;
import DAO.MemberDAOImpl;
import DAO.MyReviewBoardDaoImpl;
import DTO.Member;
import DTO.PaymentDTO;
import DTO.PostDTO;
import Service.Paging;
import Service.PostList;


@WebServlet("/mypage/myreview.do")
public class MyReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDao dao = new MyReviewBoardDaoImpl();
	private MemberDAO member = new MemberDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		Paging paging = null;	// 페이징 객체
		List<PostDTO> list = null;	// 게시물 리스트
		String pageParam = request.getParameter("pageNo");
		int pageNo = 0;
		if(pageParam != null)	pageNo = Integer.parseInt(pageParam);
		int uno = member.selectMemberNo(id);

		int totalCount = dao.getTotal(uno);	// 총 게시물 수
		if(totalCount != 0) {
			paging = new Paging(totalCount, pageNo);	// 총 게시물수와 페이지번호를 이용한 페이징 객체 생성
			list = dao.getList(paging, uno);	// 페이지에 맞는 게시물 가져오기
		}
		request.setAttribute("paging", paging);
		request.setAttribute("list", list);
//		PaymentService pService = new PaymentService();
//		list = pService.selectPayment(id);
		request.setAttribute("list", list);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/mypage/review.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
