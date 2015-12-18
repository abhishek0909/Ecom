package com.savi.ecom.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.savi.ecom.service.LoginService;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final LoginService helloWorldService;

	@Autowired
	public WelcomeController(LoginService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/loginNew", method = RequestMethod.POST)
	public String index(@RequestParam("username") String userid,
			@RequestParam("password") String passwd, Map<String, Object> model) {

		logger.debug("login() is executed!");

		String success = helloWorldService.validate(userid,passwd);
		
		
		model.put("username", success);
		
		return "home";
		
		
	}

	
	@RequestMapping(value = "validateEmail", method = RequestMethod.POST)
	public String validateEmail(@RequestParam("email") String email,
			 Map<String, Object> model) {

		logger.debug("validateEmail() is executed!");

		boolean success = helloWorldService.validateEmail(email);
		
		model.put("forgotPasswordEmail", email);
		
		return "forgotPasswordConfirmation";
		
	}

	@RequestMapping(value = "forgotPassword", method = RequestMethod.GET)
	public String forgotPassword( Map<String, Object> model) {

		logger.debug("login() is executed!");

		
		return "forgotPasswordView";
		
	}
	
	
	
	
}