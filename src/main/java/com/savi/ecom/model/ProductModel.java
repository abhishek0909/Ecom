package com.savi.ecom.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Product.
 */
@Entity
@Table(name="product")
public class ProductModel extends Model {
	
	/** The name. */
	private String name;
	
	/** The code. */
	private String code;
	
	/** The unit. */
	private String unit;
	
	/** The description. */
	private String description;
	
	/** The qualtity. */
	private Integer quality;
	
	/** The price. */
	private Double price;
	
	/** The expiry date. */
	private Date expiryDate;
	
	/** The active. */
	private boolean active;

	private String slug;
	
	private String sku;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the qualtity.
	 *
	 * @return the qualtity
	 */
	public Integer getQuality() {
		return quality;
	}

	/**
	 * Sets the qualtity.
	 *
	 * @param qualtity the new qualtity
	 */
	public void setQuality(Integer qualtity) {
		this.quality = qualtity;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Gets the expiry date.
	 *
	 * @return the expiry date
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Sets the expiry date.
	 *
	 * @param expiryDate the new expiry date
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	
}
