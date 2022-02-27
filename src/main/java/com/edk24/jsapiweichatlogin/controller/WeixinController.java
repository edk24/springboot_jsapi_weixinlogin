package com.edk24.jsapiweichatlogin.controller;

import com.alibaba.fastjson.JSON;
import com.edk24.jsapiweichatlogin.domain.AccessTokenDomain;
import com.edk24.jsapiweichatlogin.domain.WeixinUserInfoDomain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信 JsApi
 */
@Controller
@RequestMapping("weixin")
public class WeixinController {

    /**
     * 公众号 appid
     */
    private String appid = "你的公众号 Appid";

    /**
     * 公众号 appsecret
     */
    private String appsecret = "你的公众号 AppSecret";

    @GetMapping("test")
    public void test(HttpServletResponse response) throws IOException {
        // 网页授权后回调地址, 会带 code 参数用于交换 access_token
        String redirect_url = "http://192.168.31.47:8080/weixin/login";

        // snsapi_base 用户无感知, 但不能获取用户信息,
        // snsapi_userinfo 可获取用户信息  需要用户同意授权
        String scope = "snsapi_userinfo";

        // 用户自带的参数, 仅支持英文数字. 最大 128 字节
        String state = "10086";

        String url = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s", this.appid, redirect_url, scope, state);
        response.sendRedirect(url);
    }

    /**
     * 微信登录回调 (/weixin/login)
     *
     * @param response
     * @param code
     * @throws IOException
     */
    @GetMapping("login")
    public void login(HttpServletResponse response, @RequestParam(name = "code") String code) throws IOException {

        // 获取 access_token
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", this.appid, this.appsecret, code);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).method("GET", null).build();
        Response resp = client.newCall(request).execute();
        String jsondata = resp.body().string();
        AccessTokenDomain accessTokenDomain = JSON.parseObject(jsondata, AccessTokenDomain.class);

        // 获取用户信息
        url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessTokenDomain.getAccessToken(), accessTokenDomain.getOpenid());
        request = new Request.Builder().url(url).method("GET", null).build();
        resp = client.newCall(request).execute();
        jsondata = resp.body().string();
        WeixinUserInfoDomain weixinUserInfoDomain = JSON.parseObject(jsondata, WeixinUserInfoDomain.class);

        System.out.println(weixinUserInfoDomain.getNickname());

        // 前后分离
        response.sendRedirect(String.format("http://192.168.31.232:8081/home/index/index?openid=%s", weixinUserInfoDomain.getOpenid()));
    }

}
