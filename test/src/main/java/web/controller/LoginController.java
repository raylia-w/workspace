package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.dto.UserVo;

@Controller
public class LoginController {
		
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value="/login/login.do", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	@RequestMapping(value="login/main.do", method=RequestMethod.GET)
	public String main() {
		logger.info("main method() STARTED");
		return "/login/main";
	}
	
	@RequestMapping(value="/login/login.do", method=RequestMethod.POST)
	public ModelAndView loginProcess(UserVo uservo, String id, String pw) {
		logger.info("id="+id+", pw="+pw);
		logger.info(uservo.toString());
		
		ModelAndView mav = new ModelAndView();
		
		//model.addAttribute("user", uservo) 역할
		mav.addObject("user", uservo);
		
		//return
//		mav.setViewName("login/result");
		
		//response.sendRedirect("login/main.do) 역할
		mav.setViewName("redirect:/login/main.do");
		
		return mav;
	}
}
