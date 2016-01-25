package com.savi.ecom.dto;

import java.util.Set;

public class OrderDTO {

	private String orderId;
	
	private String userId;
	
	private double totalPrice;
	
	private Set<OrderEntryDTO> items;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<OrderEntryDTO> getItems() {
		return items;
	}

	public void setItems(Set<OrderEntryDTO> items) {
		this.items = items;
	}
	
	
	
	
	
}
