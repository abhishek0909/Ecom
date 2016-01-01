package com.savi.ecom.model;

import java.security.MessageDigest;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.savi.ecom.util.HashUtil;

/**
 * The Class UserModel.
 */

@Entity
@Table(name="rest_user")
public class UserModel extends Model {

    protected static final String HASH_SALT = "d8a8e885-ecce-42bb-8332-894f20f0d8ed";

    protected static final int HASH_ITERATIONS = 1000;
	
	
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


	
	
    public String hashPassword(String passwordToHash) throws Exception {
        return hashToken(passwordToHash, getEmail() + HASH_SALT );
    }


    private String hashToken(String token, String salt) throws Exception {
        return HashUtil.byteToBase64(getHash(HASH_ITERATIONS, token, salt.getBytes()));
    }

    public byte[] getHash(int numberOfIterations, String password, byte[] salt) throws Exception {
       MessageDigest digest = MessageDigest.getInstance("SHA-256");
       digest.reset();
       digest.update(salt);
       byte[] input = digest.digest(password.getBytes("UTF-8"));
       for (int i = 0; i < numberOfIterations; i++) {
           digest.reset();
           input = digest.digest(input);
       }
       return input;
   }
	
	
}
