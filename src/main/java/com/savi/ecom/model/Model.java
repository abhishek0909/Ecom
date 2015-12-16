package com.savi.ecom.model;

import java.util.Date;

/**
 * The Class Model.
 */
public abstract class Model {
	
	/** The pk. */
	private Long pk;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified date. */
	private Date modifiedDate;

	/**
	 * Gets the pk.
	 *
	 * @return the pk
	 */
	public Long getPk() {
		return pk;
	}

	/**
	 * Sets the pk.
	 *
	 * @param pk the new pk
	 */
	public void setPk(Long pk) {
		this.pk = pk;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
