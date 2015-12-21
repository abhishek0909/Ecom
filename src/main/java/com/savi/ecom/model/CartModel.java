package com.savi.ecom.model;

import java.util.Set;


/**
 * The Class CartModel.
 */
public class CartModel extends Model {
	
	/** The order id. */
	public String orderId;
	
	/** The total price. */
	public double totalPrice;
	
	/** The entries. */
	public Set<ProductModel> entries;
	
	/** The active. */
	public boolean active;
	
	/** The status. */
	public boolean status;

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the total price.
	 *
	 * @return the total price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets the total price.
	 *
	 * @param totalPrice the new total price
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Gets the entries.
	 *
	 * @return the entries
	 */
	public Set<ProductModel> getEntries() {
		return entries;
	}

	/**
	 * Sets the entries.
	 *
	 * @param entries the new entries
	 */
	public void setEntries(Set<ProductModel> entries) {
		this.entries = entries;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
