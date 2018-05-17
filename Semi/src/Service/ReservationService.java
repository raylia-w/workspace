package Service;

import java.util.ArrayList;

import DTO.ReservationDTO;
import DTO.ShopDTO;

public interface ReservationService {
	public ShopDTO s_list(String shop);
	
	public ShopDTO shopList(String shop);
	
	public ReservationDTO resList(String res);
	
	public void insertRes(ReservationDTO res);

	public void deleteRes(String res_id);
}
