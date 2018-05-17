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


@WebServlet("/reservation/terms.do")
public class ReservationTermsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String terms = (String) request.getParameter("terms");
		
		request.getRequestDispatcher("/reservation/"+terms+".jsp")
			.forward(request, response);
		
	}


}
