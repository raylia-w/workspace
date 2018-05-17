package DAO;

import java.util.List;

import Service.Paging;

public interface BoardDao {
	
	// 총 게시물 수 반환
	public int getTotal();
	
	public int getTotal(String s);
	// 페이징 처리하여 게시물 리스트 가져오기
	public List getList(Paging paging);

	public int getTotal(int uno);

	List getList(Paging paging, String s);

	List getList(Paging paging, int uno);
}
