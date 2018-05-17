package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siot.IamportRestHttpClientJava.IamportClient;
import com.siot.IamportRestHttpClientJava.response.IamportResponse;
import com.siot.IamportRestHttpClientJava.response.Payment;

import DAO.PaymentDAOImpl;
import Service.PaymentService;

@WebServlet("/api.do")
public class api extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DTO.PaymentDTO p = new DTO.PaymentDTO();
	private IamportClient client = new IamportClient("4404294394442286", "xYCKnNoMdrbroGKlbcOnuE2XeuQhdoLKnouLbTxpkJQJpA5AMTYhy0eMv54ItPtRdXCpRaPbTFVjf0U2");
	private IamportResponse<Payment> payment = new IamportResponse<>();	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String uid = request.getParameter("imp_uid");
		String res_id = request.getParameter("res_id");
		String s_name = request.getParameter("s_name");
		System.out.println(res_id);
		try {
			payment = client.paymentByImpUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		p.setAmount(payment.getResponse().getAmount());
		p.setApply_num(payment.getResponse().getApplyNum());
		p.setBuy_tel(payment.getResponse().getBuyerTel());
		p.setBuyer_name(payment.getResponse().getBuyerName());
		p.setImp_uid(uid);
		p.setMerchant_uid(payment.getResponse().getMerchantUid());
		p.setPaid_at(payment.getResponse().getPaidAt());
		p.setPay_method(payment.getResponse().getPayMethod());
		p.setPg(payment.getResponse().getPgProvider());
		p.setPaid_at(payment.getResponse().getPaidAt());
		p.setStatus("결제완료");
		p.setS_name(s_name);
		p.setRes_id(res_id);
		PaymentService pService = new PaymentService();
		pService.insertPayment(p);
				
	}
}
