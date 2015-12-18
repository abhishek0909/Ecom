package com.savi.ecom.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savi.ecom.dao.UserDao;
import com.savi.ecom.model.UserModel;

@Service
public class LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    private static final List<String> users= new ArrayList<String>();
    
    private UserDao userDao;
    
    @Autowired
    public void setUserDao(UserDao userdao){
    	
    	this.userDao = userdao;
    	
    }
    
    public LoginService(){
    	
    	users.add("abhishek");
    	users.add("gaurav");
    }
	
	public String validate(String userid, String passwd) {
		// TODO Auto-generated method stub
		
		UserModel user = userDao.getCurrentUser("");
		
		userid = user.getUserid() + "::" + user.getEmail();
		
		return userid;
		
		
	}

	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return true;
	}

}