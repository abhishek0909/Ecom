package com.savi.ecom.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressModel.
 */

@Entity
@Table(name="ecom_address")
public class AddressModel extends Model {

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "user_id")
	public String user;
	
	/** The house number. */
	public String houseNumber;
	
	/** The locality. */
	public String locality;
	
	/** The street name. */
	public String streetName;
	
	/** The state. */
	public String state;
	
	/** The country. */
	public String country;
	
	/** The active. */
	public String active;
	
	/** The default shipping. */
	public boolean defaultShipping;

	/**
	 * Gets the house number.
	 *
	 * @return the house number
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Sets the house number.
	 *
	 * @param houseNumber the new house number
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * Gets the locality.
	 *
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * Sets the locality.
	 *
	 * @param locality the new locality
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * Gets the street name.
	 *
	 * @return the street name
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the street name.
	 *
	 * @param streetName the new street name
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * Checks if is default shiping.
	 *
	 * @return true, if is default shiping
	 */
	public boolean isDefaultShipping() {
		return defaultShipping;
	}

	/**
	 * Sets the default shiping.
	 *
	 * @param defaultShiping the new default shiping
	 */
	public void setDefaultShipping(boolean defaultShiping) {
		this.defaultShipping = defaultShiping;
	}
	
	
}
