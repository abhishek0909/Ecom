package com.savi.ecom;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.savi.ecom.dao.impl.UserDaoImpl;
import com.savi.ecom.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dbtest-config.xml")
public class UserDaoTest {

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	private UserDaoImpl userDao;
	
	
	@Test
	public void testGetUser(){
		
		UserModel user = userDao.getCurrentUser("abhishek");
		
		String userid = user.getUserid() + "::" + user.getEmail();
		
		System.out.println(userid);
		
	}
	
	@Test
	public void testCreateUser(){
		
		UserModel user = new UserModel();
		user.setUserid("abhishek0909");
		
		user.setEmail("abc@xyz.com");
		
		Date date = new Date();
		user.setCreatedDate(date);
		user.setModifiedDate(date);
		
		userDao.create(user);
	
	}
	
	@Test
	public void testUpdateUser(){
		
		UserModel user = new UserModel();
		user.setUserid("abhishek0909");
		
		user.setEmail("abc@alpha.com");
		
		Date date = new Date();
		user.setCreatedDate(date);
		user.setModifiedDate(date);
		
		userDao.update(user);
	
	}
	
	
}
