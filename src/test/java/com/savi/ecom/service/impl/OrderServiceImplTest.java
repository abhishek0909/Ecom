package com.savi.ecom.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.savi.ecom.dto.OrderDTO;
import com.savi.ecom.dto.OrderEntryDTO;
import com.savi.ecom.model.OrderModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dbtest-config.xml")
public class OrderServiceImplTest {

	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	OrderServiceImpl orderService;
	
	@Test
	public void createOrder(){
		
		OrderDTO orderDto = new OrderDTO();
		
		orderDto.setUserId("af174629-9242-410b-af85-139adf12e3ad");
		
		Set<OrderEntryDTO> dtos = new HashSet<OrderEntryDTO>();
		orderDto.setItems(dtos);
		
		OrderEntryDTO dto1 = new OrderEntryDTO();
		dto1.setProductId("d4b56979-951c-4d55-a28b-c3d57900a943");
		dto1.setPrice(150);
		dto1.setQuantity(3);
		
		dtos.add(dto1);
		OrderEntryDTO dto2 = new OrderEntryDTO();
		dto2.setProductId("757416b1-1938-4676-9b97-3702f3658799");
		dto2.setPrice(240);
		dto2.setQuantity(2);
		
		dtos.add(dto2); 
		
		orderService.createOrder(orderDto);
		
	}
	
	@Test
	public void getOrder(){
		
		OrderModel order = orderService.getOrder("a6084b4b-b07b-4161-b5d3-7591a1d8bc41");
		
		System.out.println(order.getUserId() + "::" + order.getTotalPrice());
		
		System.out.println(order.getEntries().size());
		
	}
	
	
	
	
	
	
}
