package com.savi.ecom.service.impl;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dbtest-config.xml")
public class VerificationTokenServiceImplTest {
	
	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	VerificationTokenServiceImpl verificationService;
	
	@Test
	public void testSendRegistrationtoken(){
		
		
		verificationService.sendEmailRegistrationToken("gaurav@abc.com");
		
	}
	
	@Test
	public void verifyToken(){
		
		String token = "37a9f39d-7d6f-4969-ae6a-5892014dfab3";
		
		verificationService.verify(new String(Base64.encodeBase64(token.getBytes())));
		
		
	}
	

}
