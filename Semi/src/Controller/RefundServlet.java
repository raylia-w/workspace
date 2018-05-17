package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siot.IamportRestHttpClientJava.IamportClient;
import com.siot.IamportRestHttpClientJava.request.CancelData;
import com.siot.IamportRestHttpClientJava.response.IamportResponse;
import com.siot.IamportRestHttpClientJava.response.Payment;

import Service.PaymentService;
import Service.ReservationService;
import Service.ReservationServiceImpl;

@WebServlet("/refund.do")
public class RefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CancelData cancelData;
	private IamportClient client = new IamportClient("4404294394442286", "xYCKnNoMdrbroGKlbcOnuE2XeuQhdoLKnouLbTxpkJQJpA5AMTYhy0eMv54ItPtRdXCpRaPbTFVjf0U2");
	private IamportResponse<Payment> cancelPayment = new IamportResponse<>();
	private PaymentService pService = new PaymentService();
	private ReservationService rService = new ReservationServiceImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		String uid=request.getParameter("uid");
		String res_id = request.getParameter("res_id");
		cancelData = new CancelData(uid, true);
		try {
			cancelPayment = client.cancelPayment(cancelData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		String message = cancelPayment.getMessage();
		if(message!=null) {
			out.println("<script>");
			out.println("alert('"+message+"');");
			out.println("location.replace('/manager/paymentlist.do')");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('환불이 완료되었습니다');");
			out.println("location.replace('/manager/paymentlist.do')");
			out.println("</script>");
			pService.refundPayment(cancelPayment.getResponse().getImpUid());
			rService.deleteRes(res_id);
		}
	}

}
