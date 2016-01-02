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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.savi.ecom.convertor.UserConvertor;
import com.savi.ecom.form.UserCreateForm;
import com.savi.ecom.model.UserModel;
import com.savi.ecom.service.UserService;
import com.savi.ecom.web.WelcomeController;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	private final UserService userService;
	
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
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String getCopyRule(
			@ModelAttribute("userCreateForm") final UserCreateForm userCreateForm,
			final HttpServletRequest request, final Model model){
		System.out.println(userCreateForm.getUserDTO());
		UserConvertor userConvertor = new UserConvertor();
		UserModel user = userConvertor.convert(new UserModel(), userCreateForm.getUserDTO());
		user.setPassword("1234");
		userService.createUser(user);
		return "home";
//		return new ModelAndView(new RedirectView("home", true, false));
	}

}
