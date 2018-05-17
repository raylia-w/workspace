package web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InterceptorTestController {
	private static final Logger logger = LoggerFactory.getLogger(InterceptorTestController.class);
	
	@RequestMapping(value="/interceptor/main.do", method=RequestMethod.GET)
	public void main() {
		logger.info("메인페이지 활성화");
	}
	
	@RequestMapping(value="/interceptor/login.do", method=RequestMethod.GET)
	public void login() {
		logger.info("로그인 페이지 활성화");		
	}
	
	@RequestMapping(value="/interceptor/loginProc.do", method=RequestMethod.POST)
	public String loginProcess(String id, String pw, HttpSession session) {
		logger.info("로그인 처리 활성화");
		if("abc".equals(id)) {
			session.setAttribute("login", true);
			session.setAttribute("nick", "lia");
		}else if("admin".equals(id)) {
			session.setAttribute("login", true);
			session.setAttribute("nick", "admin");
		}else {
			session.setAttribute("login", false);
		}
		return "redirect:/interceptor/main.do";
	}
	
	@RequestMapping(value="/interceptor/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("로그아웃 페이지 활성화");	
		session.invalidate();
		return "redirect:/interceptor/main.do";
	}
}
