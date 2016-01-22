package com.savi.ecom.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.savi.ecom.dto.ProductDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dbtest-config.xml")
public class ProductServiceImplTest {

	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	ProductServiceImpl productService;
	
	
	

	@Test
	public void createProduct(){
		
		ProductDTO prodDto = new ProductDTO();
		prodDto.setName("Link 50mm PadLock");
		prodDto.setSlug("Link-50mm-PadLock");
		prodDto.setPrice(180.00);
		
		productService.createProduct(prodDto);
		
	}
	
	
}
