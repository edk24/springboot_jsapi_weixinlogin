package com.edk24.jsapiweichatlogin.domain;

/**
 * 微信 AccessToken 结构
 */
public class AccessTokenDomain extends WeixinJsApiBaseResultDomain {

    /**
     * 微信鉴权 token
     */
    private String accessToken;

    /**
     * 过期时间
     */
    private Integer expiresIn;

    private String scope;
    private String openid;
    private String refreshToken;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
