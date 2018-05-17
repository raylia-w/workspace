package DAO;

import java.util.ArrayList;

import DTO.PaymentDTO;

public interface PaymentDAO {
	public ArrayList<PaymentDTO> selectPayment(String u_name, String u_pno);
	public void updatePayment(String uid);
	public void insertPayment(PaymentDTO p);
	public void refundReqPayment(String uid);
	public void refundPayment(String uid);
}
