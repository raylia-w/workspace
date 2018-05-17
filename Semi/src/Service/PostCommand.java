package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PostCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
	public void execute(HttpServletRequest request, HttpServletResponse response, String id);
	public void execute(HttpServletRequest request, HttpServletResponse response, String id, int s_id_no);
}
