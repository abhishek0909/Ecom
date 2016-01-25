package com.savi.ecom.convertor;

import java.util.HashSet;
import java.util.Set;

import com.savi.ecom.dto.OrderDTO;
import com.savi.ecom.dto.OrderEntryDTO;
import com.savi.ecom.model.OrderEntryModel;
import com.savi.ecom.model.OrderModel;

public class OrderConvertor implements IConvertor<OrderModel, OrderDTO>{

	public OrderModel convert(OrderDTO input) {
		
		OrderModel order = new OrderModel();
		
		order.setUserId(input.getOrderId());
		
		Set<OrderEntryModel> items = new HashSet<OrderEntryModel>();
		
		for(OrderEntryDTO dto : input.getItems()){
             			
			OrderEntryModel item =  new OrderEntryModel();
			
			item.setProductId(dto.getProductId());
			item.setQuantity(dto.getQuantity());
			item.setPrice(dto.getPrice());
			items.add(item);
			
		}
		order.setEntries(items);
		
		return order;
	}

}
