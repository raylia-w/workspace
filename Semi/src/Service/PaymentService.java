package Service;

import java.util.ArrayList;

import DAO.MemberDAOImpl;
import DAO.PaymentDAO;
import DAO.PaymentDAOImpl;
import DTO.Member;
import DTO.PaymentDTO;

public class PaymentService implements PaymentCommand{
	
	PaymentDAO mpayment = new PaymentDAOImpl();

	@Override
	public ArrayList<PaymentDTO> selectPayment(String id){
		MemberDAOImpl mMember = new MemberDAOImpl();
		Member m = new Member();
		m = mMember.selectMember(id);
		String u_name = m.getuName();
		String u_pno = m.getuPNo();
		return mpayment.selectPayment(u_name, u_pno);
	}
	
	public void insertPayment(PaymentDTO p) {
		mpayment.insertPayment(p);
	}
	public void refundPayment(String uid) {
		mpayment.refundPayment(uid);
	}

	public void refundReqPayment(String uid) {
		mpayment.refundReqPayment(uid);
	}
	
}
