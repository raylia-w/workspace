package Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DAO.MemberDAOImpl;
import DAO.PostDAO;
import DTO.PostDTO;

public class PostList implements PostCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id) {
		
		PostDAO dao = new PostDAO();
		ArrayList<PostDTO> list = dao.list();
		
		list = dao.list();
		
		request.setAttribute("list", list);
		
	}
	public ArrayList<PostDTO> execute(HttpServletRequest request, HttpServletResponse response, int s_id_no) {
		PostDAO dao = new PostDAO();
		MemberDAO mDao = new MemberDAOImpl();
		ArrayList<PostDTO> list = dao.list(s_id_no);
		ArrayList<PostDTO> rList = new ArrayList<>();
		PostDTO dto = new PostDTO();
		for(int i=0; i<list.size(); i++) {
			String id;
			dto = list.get(i);
			int uno = dto.getU_no();
			id = mDao.selectMemberId(uno);
			dto.setId(id);
			rList.add(dto);
		}
		return rList;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String id, int s_id_no) {
		// TODO Auto-generated method stub
		
	}

}
