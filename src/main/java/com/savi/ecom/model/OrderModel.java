package com.savi.ecom.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * The Class OrderModel.
 */

@Entity
@Table(name="ecom_order")
public class OrderModel extends Model {
	
	 
	public String userId;
	
	
	
	/** The total price. */
	public double totalPrice;
	
	/** The entries. */
	@OneToMany(mappedBy="order",
            cascade= CascadeType.ALL)
	
	public Set<OrderEntryModel> entries = new HashSet<OrderEntryModel>();
	
	/** The active. */
	public boolean active;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	/** The status. */
	public boolean status;

	

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
	public Set<OrderEntryModel> getEntries() {
		return entries;
	}

	/**
	 * Sets the entries.
	 *
	 * @param entries the new entries
	 */
	public void setEntries(Set<OrderEntryModel> entries) {
		this.entries = entries;
	}
	
	

}
