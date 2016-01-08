package com.savi.ecom.model;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.savi.ecom.convertor.IConvertor;
import com.savi.ecom.dto.UserDTO;
import com.savi.ecom.util.HashUtil;

/**
 * The Class UserModel.
 */

@Entity
@Table(name="rest_user")
public class UserModel extends Model implements IConvertor<UserModel,UserDTO> {

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
	
	private boolean isVerified;
	
	/** The addresses. */
	@OneToMany(mappedBy="user",
            targetEntity=AddressModel.class,
            cascade= CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<AddressModel> addresses;
	
	/** The cart. */
	private CartModel cart;
	
	/** The orders. */
	@OneToMany(mappedBy="user",
            targetEntity=OrderModel.class,
            cascade= CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<OrderModel> orders;
	
    @OneToMany(mappedBy="user",
            targetEntity=VerificationToken.class,
            cascade= CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VerificationToken> verificationTokens = new ArrayList<VerificationToken>();
    
	
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
	
	 public boolean isVerified() {
	        return isVerified;
	 }

	 public void setVerified(boolean verified) {
	        isVerified = verified;
	 }
	
	 public synchronized void addVerificationToken(VerificationToken token) {
	        verificationTokens.add(token);
	 }

	 public synchronized List<VerificationToken> getVerificationTokens() {
	        return Collections.unmodifiableList(this.verificationTokens);
	 }
	
	
    public VerificationToken getActiveLostPasswordToken() {
        return getActiveToken(VerificationToken.VerificationTokenType.lostPassword);
    }

    public VerificationToken getActiveEmailVerificationToken() {
        return getActiveToken(VerificationToken.VerificationTokenType.emailVerification);
    }

    public VerificationToken getActiveEmailRegistrationToken() {
        return getActiveToken(VerificationToken.VerificationTokenType.emailRegistration);
    }

    private VerificationToken getActiveToken(VerificationToken.VerificationTokenType tokenType) {
         VerificationToken activeToken = null;
        for (VerificationToken token : getVerificationTokens()) {
            if (token.getTokenType().equals(tokenType)
                    && !token.hasExpired() && !token.isVerified()) {
                activeToken = token;
                break;
            }
        }
        return activeToken;
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

	public UserModel convert(UserDTO userDto) throws Exception {
		
			this.setFirstName(userDto.getFirstName());
			this.setLastName(userDto.getLastName());
			this.setEmail(userDto.getEmail());
			this.setPassword(hashPassword(userDto.getPassword()));
			return this;
		
	}
	
	
}
