package com.savi.ecom.service.impl;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


import com.savi.ecom.config.ApplicationConfig;
import com.savi.ecom.domain.repo.UserRepository;
import com.savi.ecom.domain.repo.VerificationTokenRepository;
import com.savi.ecom.exception.AlreadyVerifiedException;
import com.savi.ecom.exception.AuthenticationException;
import com.savi.ecom.exception.TokenHasExpiredException;
import com.savi.ecom.exception.TokenNotFoundException;
import com.savi.ecom.model.UserModel;
import com.savi.ecom.model.VerificationToken;



@Service("verificationTokenService")
public class VerificationTokenServiceImpl {
	
	private VerificationTokenRepository tokenRepository;
    private UserRepository userRepository;
    private ApplicationConfig config;

    @Autowired
    public VerificationTokenServiceImpl( UserRepository userRepo, VerificationTokenRepository tokenRepo){
    	this.tokenRepository = tokenRepo;
    	this.userRepository = userRepo;    	
    	
    }
    
    @Transactional
    public VerificationToken sendEmailRegistrationToken(String userId) {
        UserModel user = ensureUserIsLoaded(userId);
        VerificationToken token = new VerificationToken(user,
                VerificationToken.VerificationTokenType.emailRegistration,
                config.getEmailRegistrationTokenExpiryTimeInMinutes());
        user.addVerificationToken(token);
        userRepository.save(user);
     // @TODO Persist email message to database for Email sender to send
        return token;
    }
    
    private VerificationToken sendEmailVerificationToken(String userId) {
    	 UserModel user = ensureUserIsLoaded(userId);
        VerificationToken token = new VerificationToken(user, VerificationToken.VerificationTokenType.emailVerification,
                config.getEmailVerificationTokenExpiryTimeInMinutes());
        user.addVerificationToken(token);
        userRepository.save(user);
        return token;
    }
    
    @Transactional
    public VerificationToken sendLostPasswordToken(String userId) {
       
        VerificationToken token = null;
        UserModel user = userRepository.findByEmail(userId);
        if (user != null) {
            token = user.getActiveLostPasswordToken();
            if (token == null) {
                token = new VerificationToken(user, VerificationToken.VerificationTokenType.lostPassword,
                        config.getLostPasswordTokenExpiryTimeInMinutes());
                user.addVerificationToken(token);
                userRepository.save(user);
            }
         }

        return token;
    }
    
    @Transactional
    public VerificationToken resetPassword(String base64EncodedToken, String password) {
        Assert.notNull(base64EncodedToken);
        
        VerificationToken token = loadToken(base64EncodedToken);
        if (token.isVerified()) {
            throw new AlreadyVerifiedException();
        }
        token.setVerified(true);
        UserModel user = token.getUser();
        try {
            user.setPassword(user.hashPassword(password));
        } catch (Exception e) {
            throw new AuthenticationException();
        }
        //set user to verified if not already and authenticated role
        user.setVerified(true);
       
        userRepository.save(user);
        return token;
    }
    
    @Transactional
    public VerificationToken verify(String base64EncodedToken) {
        VerificationToken token = loadToken(base64EncodedToken);
        if (token.isVerified() || token.getUser().isVerified()) {
            throw new AlreadyVerifiedException();
        }
        token.setVerified(true);
        token.getUser().setVerified(true);
        userRepository.save(token.getUser());
        return token;
    }

    
    private VerificationToken loadToken(String base64EncodedToken) {
        Assert.notNull(base64EncodedToken);
        String rawToken = new String(Base64.decodeBase64(base64EncodedToken));
        VerificationToken token = tokenRepository.findByToken(rawToken);
        if (token == null) {
            throw new TokenNotFoundException();
        }
        if (token.hasExpired()) {
            throw new TokenHasExpiredException();
        }
        return token;
    }
    
    private UserModel ensureUserIsLoaded(String userIdentifier) {
        UserModel user = null;
        if (com.savi.ecom.util.StringUtil.isValidUuid(userIdentifier)) {
            user = userRepository.findByUuid(userIdentifier);
        } else {
            user = userRepository.findByEmail(userIdentifier);
        }
        if (user == null) {
            throw new com.savi.ecom.exception.UserNotFoundException();
        }
        return user;
    }
    
    @Autowired
    public void setConfig(ApplicationConfig config) {
        this.config = config;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApplicationConfig getConfig() {
        return this.config;
    }
    
}
