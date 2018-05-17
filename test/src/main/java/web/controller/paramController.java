package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Person;

@Controller
public class paramController {
	@RequestMapping(value="/param/param.do", method=RequestMethod.GET)
	public String main() {
		return "param/parameterForm";
	}
	
	@RequestMapping(value="/param/param.do", method=RequestMethod.POST)
	public String result(Person p) {
		
		return "param/paramResult";
	}
}
