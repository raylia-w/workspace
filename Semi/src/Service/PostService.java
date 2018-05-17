package Service;

import DAO.PostDAO;
import DTO.PostDTO;

public class PostService {
	
	public PostDTO deletePost(int i) {
		
		PostDAO dao = new PostDAO();
		return dao.deletePost(i);
				
	}

//	public PostDTO updatePost(int p_no) {
//		PostDAO dao = new PostDAO();
//		return dao.updatePost(p_no);
//	}

}