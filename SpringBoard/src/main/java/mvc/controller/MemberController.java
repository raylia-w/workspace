package mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.dto.User;
import mvc.service.LoginService;

@Controller
public class MemberController {
	
	@Autowired LoginService loginService;
	
	@RequestMapping(value="/member/main.do")
	public void main() {
		
	}
	
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String join() {
		return "member/joinForm";
	}
	
	@RequestMapping(value="/member/join.do", method=RequestMethod.POST)
	public String joinProc(User user) {
		loginService.join(user);
		return "redirect:/member/main.do";
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String loginProc(User user, HttpSession session) {
		User u = loginService.login(user);
		if(u!=null) {
			session.setAttribute("userid", u.getUserid());
			session.setAttribute("usernick", u.getUsernick());

			return "true";
		}else {
			session.invalidate();
			return "false";
		}
	}
	
	@RequestMapping(value="/member/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/main.do";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/idCheck.do")
	public String idCheck() {
		return "true";
	}
	
}
