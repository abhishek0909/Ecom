package com.savi.ecom.model;

import java.util.Set;

/**
 * The Class UserModel.
 */
public class UserModel extends Model {

	/** The userid. */
	private String userid;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The initials. */
	private String initials;
	
	/** The sex. */
	private String sex;
	
	/** The addresses. */
	private Set<AddressModel> addresses;
	
	/** The cart. */
	private CartModel cart;
	
	/** The orders. */
	private Set<OrderModel> orders;
	
	/**
	 * Gets the userid.
	 *
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * Sets the userid.
	 *
	 * @param userid the new userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the initials.
	 *
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * Sets the initials.
	 *
	 * @param initials the new initials
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}

	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the addresses.
	 *
	 * @return the addresses
	 */
	public Set<AddressModel> getAddresses() {
		return addresses;
	}

	/**
	 * Sets the addresses.
	 *
	 * @param addresses the new addresses
	 */
	public void setAddresses(Set<AddressModel> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Gets the cart.
	 *
	 * @return the cart
	 */
	public CartModel getCart() {
		return cart;
	}

	/**
	 * Sets the cart.
	 *
	 * @param cart the new cart
	 */
	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	/**
	 * Gets the orders.
	 *
	 * @return the orders
	 */
	public Set<OrderModel> getOrders() {
		return orders;
	}

	/**
	 * Sets the orders.
	 *
	 * @param orders the new orders
	 */
	public void setOrders(Set<OrderModel> orders) {
		this.orders = orders;
	}
	
	
	
}
