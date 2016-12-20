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
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserCredentialsService credentialsService;

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

		for (Authority auth : validCredentials.getAuthority()) {
			if (auth.getAuthority().equals("ROLE_ADMIN")) {
				return "admin/admin";
			}
		}

		return "welcome";
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
}
