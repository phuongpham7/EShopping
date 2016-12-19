package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {

 
	@RequestMapping({"/","/welcome"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to our community, Newyork Sports!!");
		model.addAttribute("welcomeimage", "resources/images/ny.jpg");
		model.addAttribute("tagline", "Best Sports Shoping Place in Newyork");
		
		return "welcome";
	}
 
}
