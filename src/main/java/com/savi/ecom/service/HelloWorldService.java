package com.savi.ecom.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

    private static final List<String> users= new ArrayList<String>();
    
    public HelloWorldService(){
    	
    	users.add("abhishek");
    	users.add("gaurav");
    }
	
	public boolean validate(String userid, String passwd) {
		// TODO Auto-generated method stub
		
		return users.contains(userid);
		
		
	}

}