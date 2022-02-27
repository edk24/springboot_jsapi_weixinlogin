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

    /**
     * 用户自带的参数, 仅支持英文数字. 最大 128 字节
     */
    private String scope;

    /**
     * 用户微信唯一标识 (同公众号下)
     */
    private String openid;

    /**
     * 刷新 Token
     */
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
