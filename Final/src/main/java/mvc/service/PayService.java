package mvc.service;

import java.util.List;

public interface PayService {
	
	public List getPayList();
	
	public void insertPay();
	
	public void deletePay();
	
	public void completePay();
	
	public void refundPay();
	
}
