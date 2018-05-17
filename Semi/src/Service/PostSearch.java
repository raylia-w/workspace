package Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PostDAO;
import DTO.PostDTO;

public class PostSearch implements PostCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 검색 분류
		String searchName = request.getParameter("searchName");
		// 검색창에 입력한 내용
		String searchValue = request.getParameter("searchValue");

		// 테스트 코드
		System.out.println("[Test] 검색분류: "+searchName);
		System.out.println("[Test] 검색어: "+searchValue);
		
		
		PostDAO dao = new PostDAO();
		
		ArrayList<PostDTO> list = dao.search(searchName, searchValue);
		
		request.setAttribute("list", list);
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id, int s_id_no) {
		// TODO Auto-generated method stub
		
	}
	
}
