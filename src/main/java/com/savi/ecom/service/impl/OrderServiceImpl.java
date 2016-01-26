package com.savi.ecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savi.ecom.convertor.OrderConvertor;
import com.savi.ecom.domain.repo.OrderRepository;
import com.savi.ecom.dto.OrderDTO;
import com.savi.ecom.model.OrderEntryModel;
import com.savi.ecom.model.OrderModel;
import com.savi.ecom.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
	private OrderConvertor orderConvertor;
	
	public OrderModel createOrder(OrderDTO orderdto) {
		// TODO Auto-generated method stub
		OrderModel order = orderConvertor.convert(orderdto);
		
		double totalPrice = calculateTotalPrice(order);
		
		order.setTotalPrice(totalPrice);
		order = orderRepository.save(order);
		
		return order;
	}
	
	
	private double calculateTotalPrice(OrderModel order){
		
		double total = 0;
		
		for(OrderEntryModel entry : order.getEntries()){
			
			total += entry.getQuantity()*entry.getPrice();
			
		}
		
		
		return total;
		
	}


	public OrderModel getOrder(String str) {
		// TODO Auto-generated method stub
		return orderRepository.findByUuid(str);
	}

}
