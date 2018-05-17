package Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PostDAO;
import DTO.PostDTO;

public class PostDetail implements PostCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String pno = request.getParameter("p_no");
		int p_no = Integer.parseInt(pno);
		
		PostDAO dao = new PostDAO();
		PostDTO bto = dao.postDetail( p_no );
		
		request.setAttribute("postDetail", bto);
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id) {
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id, int s_id_no) {
		// TODO Auto-generated method stub
		
	}
		
}
