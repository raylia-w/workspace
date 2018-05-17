package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.ShopDAO;
import DTO.ShopDTO;

public class ShopService {
	
	public Boolean isNew(ShopDTO s) {
		ShopDAO sJoin = new ShopDAO();
		boolean flag = sJoin.isNew(s);
		
		return flag;
	}
	
	public void addShop(ShopDTO s) {
		ShopDAO dao = new ShopDAO();
		dao.addShop(s);
	}
	
	public ShopDTO deleteShop(int s) {
		ShopDAO dao = new ShopDAO();
		return dao.deleteShop(s);
	}
	
	public ShopDTO updateShop(int s) {				
		ShopDAO dao = new ShopDAO();
		return dao.updateShop(s);
	}
	
	public ShopDTO selectShop(int s_id_no) {
		ShopDAO dao = new ShopDAO();
		return dao.selectShop(s_id_no);
	}
	
	public void updateShopExe(ShopDTO s) {				
		ShopDAO dao = new ShopDAO();		
		dao.updateShopExe(s);
	}
	
	public ArrayList<ShopDTO> selectShopList(String type){
		ShopDAO dao = new ShopDAO();
		return dao.selectShopList(type);
	}
	
}