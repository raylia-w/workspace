package mvc.DAO;

import java.util.List;

public interface PaymentDAO {
	
	public List getPayList();
	
	public void insertPay();
	
	public void deletePay();
	
	public void completePay();
	
	public void refundPay();
	
}
