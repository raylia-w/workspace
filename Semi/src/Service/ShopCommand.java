package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ShopCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
