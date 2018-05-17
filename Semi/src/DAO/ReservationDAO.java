package DAO;

import java.util.ArrayList;
import java.util.List;

import DTO.ReservationDTO;
import DTO.ShopDTO;
import Service.Paging;

public interface ReservationDAO {
	public ShopDTO s_list(String shop);
	
	public ShopDTO shopList(String shop);
	
	public ReservationDTO resList(String res);

	public void insertRes(ReservationDTO res);

	// 총 게시물 수 반환
	public int getTotal();
	
	// 페이징 처리하여 게시물 리스트 가져오기
	public List getList(Paging paging, String id);
	
	public void deleteRes(String res_id);
	
}
