package com.spring.mvc.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMVCController {
@RequestMapping("/Hello")
	public ModelAndView helloWorld(){
	String message="Welcome to Spring MVC";
		return new ModelAndView("HelloPage","message",message);
	}
}
