package com.savi.ecom.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savi.ecom.form.UserCreateForm;
import com.savi.ecom.model.UserModel;
import com.savi.ecom.service.UserService;
import com.savi.ecom.service.impl.VerificationTokenServiceImpl;
import com.savi.ecom.web.WelcomeController;

@RequestMapping("/user")
@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	private final UserService userService;
	
	@Autowired
	private VerificationTokenServiceImpl verificationTokenService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Gets the copy rule.
	 *
	 * @param userCreateForm the user create form
	 * @param request the request
	 * @param model the model
	 * @return the copy rule
	 * @throws Exception 
	 */
	@RequestMapping( method = RequestMethod.POST)
	public String createUser(
			@ModelAttribute("userCreateForm") final UserCreateForm userCreateForm,
			final HttpServletRequest request, final Model model) throws Exception{
		System.out.println(userCreateForm.getUserDTO());
		
		UserModel user =new UserModel();
	
		
		user = userService.createUser(userCreateForm.getUserDTO());
		model.addAttribute("useremail", user.getEmail());
		
		verificationTokenService.sendEmailRegistrationToken(user.getEmail());
		return "home";
//		return new ModelAndView(new RedirectView("home", true, false));
	}

}
