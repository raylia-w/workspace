package Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PostDAO;
import DTO.PostDTO;
import DTO.ShowPostDTO;

public class PostShop implements PostCommand {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      
      String sidno = request.getParameter("p_no");
      int s_id_no = Integer.parseInt(sidno);
      PostDAO dao = new PostDAO();
      PostDTO pto = dao.PostShopDt(s_id_no);
       
      request.setAttribute("postshop", pto);
   }

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response, String id) {
      
   }

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response, String id, int s_id_no) {
      
   }
   

}