package com.edk24.jsapiweichatlogin.domain;

/**
 * 微信用户数据实体
 */
public class WeixinUserInfoDomain {

    /**
     * 用户微信唯一标识 (同公众号下)
     */
    private String openid;

    /**
     * 微信昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String headimgurl;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 城市
     */
    private String city;

    /**
     * 国家
     */
    private String country;

    /**
     * 语言
     */
    private String language;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
