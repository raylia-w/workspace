package Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PostDAO;
import DTO.Member;
import DTO.PostDTO;

public class PostWrite implements PostCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html;charset=utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		
//		String p_name = request.getParameter( "p_name" );
//
////		String uno = request.getParameter("uno").trim();
////		int u_no = Integer.parseInt(uno);
//		
//		String p_main = request.getParameter( "p_main" );
//		
//		System.out.println("[Test] p_name: "+p_name);
//		System.out.println("[Test] p_main: "+p_main);
//		
//		
//		PostDAO dao = new PostDAO();
//		dao.write( p_name, p_main );
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String p_name = request.getParameter( "p_name" );

		MemberService mService = new MemberService();
		
		Member m = mService.selectMember(id);
		
		int uno = m.getuNo();
		
		String p_main = request.getParameter( "p_main" );
		
		PostDAO dao = new PostDAO();
		dao.write( p_name, p_main, uno );
		
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response, String id, int s_id_no) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html;charset=utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		
		String p_name = request.getParameter( "p_name" );

		MemberService mService = new MemberService();
		
		Member m = mService.selectMember(id);
		
		int uno = m.getuNo();
		
		String p_main = request.getParameter( "p_main" );
		
		PostDAO dao = new PostDAO();
		dao.write( p_name, p_main, uno, s_id_no );
		
	}
		
}
