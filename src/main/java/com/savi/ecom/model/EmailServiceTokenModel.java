package com.savi.ecom.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Base64;

@Entity
@Table(name="email_token")
public class EmailServiceTokenModel extends Model {

    private final String emailAddress;
    private final String token;
    private final VerificationToken.VerificationTokenType tokenType;
    private final String hostNameUrl;


    public EmailServiceTokenModel(UserModel user, VerificationToken token, String hostNameUrl)  {
        this.emailAddress = user.getEmail();
        this.token = token.getToken();
        this.tokenType = token.getTokenType();
        this.hostNameUrl = hostNameUrl;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEncodedToken() {
        return new String(Base64.encodeBase64(token.getBytes()));
    }

    public String getToken() {
        return token;
    }

    public VerificationToken.VerificationTokenType getTokenType() {
        return tokenType;
    }

    public String getHostNameUrl() {
        return hostNameUrl;
    }
}
