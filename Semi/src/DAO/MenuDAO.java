package DAO;

import java.util.ArrayList;

import DTO.MenuDTO;

public interface MenuDAO {
	public ArrayList<MenuDTO> menuList(int s_id_no);
}
