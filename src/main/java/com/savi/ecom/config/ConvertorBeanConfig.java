package com.savi.ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.savi.ecom.convertor.ProductConvertor;
import com.savi.ecom.convertor.UserConvertor;

@Configuration
public class ConvertorBeanConfig {

	
	 @Bean
	   public UserConvertor userConvertor(){
		   
		   return new UserConvertor();
	   }

	   @Bean
	   public ProductConvertor productConvertor(){
		   
		   return new ProductConvertor();
	   }
}
