package com.savi.ecom.service;

import com.savi.ecom.dto.OrderDTO;
import com.savi.ecom.model.OrderModel;

public interface OrderService {
	
	
	public OrderModel createOrder(OrderDTO orderdto);

}
