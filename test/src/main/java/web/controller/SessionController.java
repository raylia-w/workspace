package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	@RequestMapping(value="/session/create.do")
	public void sessionCreate(HttpSession session) {
		session.setAttribute("test1", "Apple");
		session.setAttribute("test2", "Banana");
		session.setAttribute("test3", "Cherry");
	}
	
	@RequestMapping(value="/session/info.do")
	public void sessionInfo() {
		
	}
	
	@RequestMapping(value="/session/delete.do")
	public void sessionDelete(HttpSession session) {
		session.invalidate();
	}
}
