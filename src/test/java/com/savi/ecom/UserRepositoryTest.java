package com.savi.ecom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.savi.ecom.dao.impl.UserRepository;
import com.savi.ecom.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=  "classpath:spring-dbtest-config.xml")

public class UserRepositoryTest {
	
	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void testGetUser(){
		
		UserModel user = userRepository.findByEmail("abhishek123@abc.com");
		
		if(user != null){
			String userid =  user.getEmail();
			
			System.out.println(userid);
		}
		
	}
	
	@Test
	public void createUser(){
		
		UserModel user = new UserModel();
		
		user.setEmail("gaurav@abc.com");
		user.setFirstName("gaurav");
		user.setLastName("garg");
		try {
			user.setPassword(user.hashPassword("test123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserModel dbuser = userRepository.save(user);
		
		
		System.out.println(dbuser.getEmail());
		
	}

}
