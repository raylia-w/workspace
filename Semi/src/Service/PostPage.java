package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PostDAO;
import DTO.PageDTO;

public class PostPage implements PostCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int curPage = 1;	// 현재 페이지, 기본값은 1

		if( request.getParameter("curPage") != null ) {
			curPage = Integer.parseInt( request.getParameter("curPage"));
		}
		
		PostDAO dao = new PostDAO();
		PageDTO list = dao.Postpage(curPage);
		
		// 게시물 목록 리스트 저장
		request.setAttribute("list", list.getList());
		
		request.setAttribute("page", list);
		
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
