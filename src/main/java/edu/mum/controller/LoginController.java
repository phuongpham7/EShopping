package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.Authority;
import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.AuthorityService;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private UserCredentialsService credentialsService;
	
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model) {

		UserCredentials validCredentials = null;
		try {
			validCredentials = credentialsService.authenticate(credentials.getUsername(), credentials.getPassword());
		} catch (Exception e) {
			model.addAttribute("error", "Username/Password not found");
			return "login";
		}
		if (validCredentials == null)
		{
			model.addAttribute("error", "Username/Password not found");
			return "login";
		}
			
		model.addAttribute("user", validCredentials.getUser());
		
		if (authorityService.isAdmin(validCredentials.getUsername()))	return "admin/admin";

		return "user/userFrontPage";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin/admin";
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category() {
		return "admin/category";
	}
}
