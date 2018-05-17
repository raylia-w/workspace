package web.controller;

import java.io.IOException;
import java.io.Writer;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import web.dto.User;
import web.service.UserService;

@Controller
public class UserController {

	@Autowired UserService userService;
	
	@RequestMapping(value="/user/main")
	public void userMain() {
		
	}
	
	@RequestMapping(value="/user/join")
	public void userJoin() {
		
	}
	
	@RequestMapping(value="/user/idCheck")
	@ResponseBody
	public String idCheck(User user) {
		if(userService.isNew(user)==1) {
			System.out.println("idcheck="+userService.isNew(user));
			return "false";
		}else {
			return "true";
		}
	}
	
	@RequestMapping(value="/user/joinProc", method=RequestMethod.POST)
	public String userJoinProc(User user) {
		if(userService.isNew(user)==0) {
			userService.memberJoin(user);
		}else {
			
			return "redirect:/user/join.do";
		}
		
		return "redirect:/user/main.do";
	}
	
	@RequestMapping(value="/user/login")
	public void userlogin() {
		
	}
	
	@RequestMapping(value="/user/loginProc", method=RequestMethod.POST)
	@ResponseBody
	public String userLoginProc(User user, HttpSession session) {
		User u = userService.isMember(user);
		if(u!=null) {
			session.setAttribute("id", u.getId());
			session.setAttribute("pw", u.getPw());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("phone", u.getPhone());

			return "true";
		}else {
			session.invalidate();
			return "false";
		}
		
	}
	
	@RequestMapping(value="/user/mypage")
	public void userMyPage() {
		
	}
	
	@RequestMapping(value="/user/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/user/main.do";
	}
	
}
