package Service;

import java.util.ArrayList;

import DAO.ReservationDAO;
import DAO.ReservationDAOImpl;
import DTO.ReservationDTO;
import DTO.ShopDTO;

public class ReservationServiceImpl implements ReservationService {

	private ReservationDAO shopDao = new ReservationDAOImpl();
	
	@Override
	public ShopDTO s_list(String shop) {
//		ArrayList<ShopDTO> s_list = shopDao.s_list(shop);
		
		return shopDao.s_list(shop);
	}
	
	@Override
	public ShopDTO shopList(String shop) {
		
		return shopDao.shopList(shop);
	}
	
	@Override
	public ReservationDTO resList(String res) {
		
		return shopDao.resList(res);
	}

	@Override
	public void insertRes(ReservationDTO reservation) {
		shopDao.insertRes(reservation);
	}

	@Override
	public void deleteRes(String res_id) {
		shopDao.deleteRes(res_id);
	}
	
}
