package com.kwahsog.dwauthdemo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessTokenData {

    public AccessTokenData(){

    }

    @JsonProperty("issued_to")
    private String issuedTo;

    @JsonProperty
    private String audience;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty
    private String scope;

    @JsonProperty("expires_in")
    private String expiresIn;

    @JsonProperty("access_type")
    private String accessType;

    @JsonProperty("verified_email")
    private String verified_email;

    @JsonProperty("email")
    private String email;

    @JsonProperty("iss")
    private String iss;

    @JsonProperty("sub")
    private String sub;

    @JsonProperty("azp")
    private String azp;

    @JsonProperty("aud")
    private String aud;

    @JsonProperty("iat")
    private String iat;

    @JsonProperty("exp")
    private String exp;

    public String getEmail_verified() {
        return verified_email;
    }

    public void setEmail_verified(String email_verified) {
        this.verified_email = email_verified;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getAzp() {
        return azp;
    }

    public void setAzp(String azp) {
        this.azp = azp;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}
