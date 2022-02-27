## springboot 微信公众号授权

### 准备

- [沙盒测试环境申请](https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index)

### 坑


1. 沙盒环境 `功能服务`->`网页账号`->`网页授权获取用户基本信息` 处的域名设置, 不需要加 `http/s`


### 测试

**请使用微信浏览器打开**

http://局域网IP:8080/weixin/test


### uniapp / vue 等前后分离接入

1.将 `WeixinController` 中的 `test` 方法写在前端中;

示例

```javascript
wxlogin: function() {
    const appid = "你的 appid";
    // 授权方式, 获取用户基本信息. 需要用户同意授权
    const scope = "snsapi_userinfo";
    // 附带参数, 最大 128 字节, 限英文和数字
    const state = "10086";
    // 微信网页授权后带 code 重定向到后端地址
    const redirect_uri = encodeURIComponent('http://192.168.31.47:8080/weixin/login');
    // 重定向
    window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + redirect_uri + "&response_type=code&scope=" + scope + "&state="+state;
}
```


2.后端 `weixin/login` 接口获取用户信息后, 带 openid / 设置 cookie 方式 重定向回前端页面

示例: (重定向带 openid)

```java
String url = String.format("http://前端地址(测试可以用局域网地址)/home/index/index?openid=%s", weixinUserInfoDomain.getOpenid());
response.sendRedirect(url);
```