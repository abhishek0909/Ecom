package com.savi.ecom.user.api;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

@XmlRootElement
public class LoginRequest {
	 	@NotNull
	    private String username;

	    @Length(min=8, max=30)
	    @NotNull
	    private String password;

	    public LoginRequest(){}

	    public LoginRequest(String uname, String passwd) {
			
	    	username =uname;
	    	password = passwd;
		}

		public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	
	
}
