package com.edk24.jsapiweichatlogin.domain;

/**
 * 微信接口返回数据基本结构
 */
public class WeixinJsApiBaseResultDomain {
    /**
     * 错误代码
     */
    private Integer errcode;

    /**
     * 错误文本
     */
    private String errmsg;


    public Integer getErrcode() {
        return this.errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
