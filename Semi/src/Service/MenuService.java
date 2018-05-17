package Service;

import java.util.ArrayList;

import DAO.MenuDAO;
import DAO.MenuDAOImpl;
import DTO.MenuDTO;

public class MenuService {
	MenuDAO dao = new MenuDAOImpl();
	public ArrayList<MenuDTO> menuList(int s_id_no){
		return dao.menuList(s_id_no);
	}
}
