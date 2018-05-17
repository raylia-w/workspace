package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Member;
import DTO.ReservationDTO;
import DTO.ShopDTO;
import Service.MemberCommand;
import Service.MemberService;
import Service.ReservationService;
import Service.ReservationServiceImpl;


@WebServlet("/reservation/reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberCommand memberComm = new MemberService(); 
	private ReservationService shopService = new ReservationServiceImpl();
	
	Member mem = new Member();
	ShopDTO shop = new ShopDTO();
	
	// 예약페이지 띄우기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		// 로그인 상태 검증
		if( session.getAttribute("id") != null ) {
			// 로그인 - 아이디가 세션에 있을 때
			
			// 음식점 이름
			String sName = request.getParameter("s_name");
			shop = shopService.s_list(sName);
			
			// 예약하려는 가게의 정보를 shopList로 jsp에 전송한다
			request.setAttribute("shop", shop);
			
			// 회원 ID
			String id = (String) session.getAttribute("id");
			mem = memberComm.selectMember(id);
			
			//할인
			int discount = memberComm.memberDiscount(id);
			request.setAttribute("mem", mem);
			request.setAttribute("dis", discount);
//			System.out.println("USER ID : " + id);
//			System.out.println("SHOP NAME : " + shop.getS_name());

			request.getRequestDispatcher("/reservation/reservation.jsp").forward(request, response);
		
			
		} else {
//			System.out.println("ㅁㅁ");
			// 비로그인 - 세션에 아이디 값이 null일 때
			out.println("<script>");
			out.println("alert('로그인 해주세요');");
			request.getRequestDispatcher("/reservation/reservation.jsp").forward(request, response);
			out.println("</script>");
		}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		ReservationDTO res = new ReservationDTO();
		PrintWriter out = response.getWriter();
		
		//		System.out.println(dNum);
		String res_id = request.getParameter("uId")+request.getParameter("s_id_no")+request.getParameter("timeSelect");
		String s_name = request.getParameter("s_name");
		res.setRes_id(res_id); // 예약 해당일
		res.setS_id_no(request.getParameter("s_id_no")); // 사업자 번호
		res.setU_id(request.getParameter("uId")); // 예약한 회원 아이디		
		res.setRes_time(request.getParameter("timeSelect"));
		res.setRes_person(request.getParameter("rPerson"));
		res.setRes_date(request.getParameter("dNum"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		ReservationService resService = new ReservationServiceImpl();
		resService.insertRes(res);
		out.println("<script>");
		out.println("window.open('/resInfo.do?id="+request.getParameter("uId")+"&price="+amount+"&s_name="+s_name+"&res_id="+res_id+"', '결제화면', 'width=1000, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=no');");
		out.println("</script>");
	}

}
