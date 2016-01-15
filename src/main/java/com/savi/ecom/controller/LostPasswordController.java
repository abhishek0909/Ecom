package com.savi.ecom.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savi.ecom.form.LostPasswordForm;
import com.savi.ecom.model.VerificationToken;
import com.savi.ecom.service.impl.VerificationTokenServiceImpl;


@Controller
@RequestMapping("/password")
public class LostPasswordController {
	
	private final Logger logger = LoggerFactory.getLogger(LostPasswordController.class);
	
	@Autowired
	private VerificationTokenServiceImpl verificationTokenService;
	
	@RequestMapping(value="/token",method=RequestMethod.POST)
	public String sendPasswordToken(
			@ModelAttribute("lostPasswordForm") final LostPasswordForm lostPasswordForm,
			final HttpServletRequest request, final Model model){
		
		String email = lostPasswordForm.getLostPasswordDTO().getEmail();
		VerificationToken token = verificationTokenService.sendLostPasswordToken(email);
		
		model.addAttribute("token", token.getToken());
		model.addAttribute("forgotPasswordEmail", email);
		return "forgotPasswordConfirmation";
	}
	
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword( Map<String, Object> model) {

		logger.debug("login() is executed!");
		
		return "forgotPasswordView";
		
	}

}
