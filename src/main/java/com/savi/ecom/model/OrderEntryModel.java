package com.savi.ecom.model;

/**
 * The Class OrderEntryModel.
 */
public class OrderEntryModel {
	
	/** The product. */
	public ProductModel product;
	
	/** The quantity. */
	public Long quantity;
	
	/** The price. */
	public double price;

	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public ProductModel getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(ProductModel product) {
		this.product = product;
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
