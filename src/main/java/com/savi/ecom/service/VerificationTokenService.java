package com.savi.ecom.service;

import com.savi.ecom.model.VerificationToken;

public interface VerificationTokenService {
	
	 public VerificationToken sendEmailVerificationToken(String userId);

	    public VerificationToken sendEmailRegistrationToken(String userId);

	    public VerificationToken sendLostPasswordToken(String userId);

	    public VerificationToken verify(String base64EncodedToken);

	    public VerificationToken generateEmailVerificationToken(String emailAddress);

	    public VerificationToken resetPassword(String base64EncodedToken, String password);

}
