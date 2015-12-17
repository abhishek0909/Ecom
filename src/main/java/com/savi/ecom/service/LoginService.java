package com.savi.ecom.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    private static final List<String> users= new ArrayList<String>();
    
    public LoginService(){
    	
    	users.add("abhishek");
    	users.add("gaurav");
    }
	
	public boolean validate(String userid, String passwd) {
		// TODO Auto-generated method stub
		
		return users.contains(userid);
		
		
	}

	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return true;
	}

}