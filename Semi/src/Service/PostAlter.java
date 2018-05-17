package Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PostDAO;
import DTO.PostDTO;

public class PostAlter implements PostCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String pno = request.getParameter("p_no");
		
		String pname = request.getParameter( "p_name" );
		String pmain = request.getParameter( "p_main" );
		
//		System.out.println("[Test] p_no: "+pno);
//		System.out.println("[Test] p_name: "+pname);
		System.out.println("[Test] p_main: "+pmain);
		
		PostDAO dao = new PostDAO();
		dao.postAlter( pno, pname, pmain );
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id) {
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id, int s_id_no) {
		// TODO Auto-generated method stub
		
	}
		
}
