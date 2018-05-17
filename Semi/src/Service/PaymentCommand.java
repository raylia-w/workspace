package Service;

import java.util.ArrayList;

import DTO.PaymentDTO;

public interface PaymentCommand {

	public ArrayList<PaymentDTO> selectPayment(String id);
	
}
