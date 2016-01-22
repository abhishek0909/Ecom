package com.savi.ecom.service.impl;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.savi.ecom.dto.UserDTO;
import com.savi.ecom.model.UserModel;
import com.savi.ecom.user.api.LoginRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dbtest-config.xml")
public class UserServiceImplTest {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	private UserServiceImpl userService;
	
	@Test
	public void testLogin(){
	
		UserModel user = new UserModel();
		String uuid = UUID.randomUUID().toString();
		String email = "abhishek" + "5c9ebb91-ed4d-47e2-ae27-61c3762e3bc5" + "@abc.com";
		String password = "test123";
		user.setEmail(email);
		user.setFirstName("abhishek");
		user.setLastName("Mittal");
		user.setPassword(password);
		
	//	userService.createUser(user);    
		boolean status = userService.login(new LoginRequest(email,password));
		
		System.out.println(status);
	
	}
	
	@Test
	public void createUser(){
		UserDTO user = new UserDTO();
		
		String uuid = UUID.randomUUID().toString();
		String email = "gaurav" + uuid + "@abc.com";
		user.setEmail(email);
		user.setFirstName("gaurav");
		user.setLastName("garg");
		user.setPassword("test123");
	
		UserModel newUser = userService.createUser(user);
		System.out.println(newUser.getFirstName() + "::" + newUser.getLastName());
		
		
	}
	
	
	
}
