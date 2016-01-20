package com.savi.ecom.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class OrderEntryModel.
 */
@Entity
@Table(name="order_entry")
public class OrderEntryModel extends Model{
	
	 @ManyToOne(targetEntity=OrderModel.class)
	 @JoinColumn(name = "order_id")
	public OrderModel orderId;
	 
	/** The product. */	 
	 
	public String productId;
	
	public String productName;
	
	/** The quantity. */
	public Long quantity;
	
	/** The price. */
	public double price;

	

	public OrderModel getOrderId() {
		return orderId;
	}

	public void setOrderId(OrderModel orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
