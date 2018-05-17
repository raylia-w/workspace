package com.raylia.www;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HiController {
	
	@RequestMapping(value="/home/hi.do", method=RequestMethod.GET)
	public String hi(Model model) {
		System.out.println("Hi.do 요청");
		
		model.addAttribute("test", "Apple");
		//request.addAttribute("test", "Apple");
		
		return "home/hi";
	}
	
}
