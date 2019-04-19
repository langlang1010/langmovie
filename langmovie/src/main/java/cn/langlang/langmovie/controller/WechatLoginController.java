package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.UserVO;
import cn.langlang.langmovie.entity.UserInfo;
import cn.langlang.langmovie.service.RedisService;
import cn.langlang.langmovie.service.UserInfoService;
import cn.langlang.langmovie.service.UserService;
import cn.langlang.langmovie.util.RestControllerHelper;
import cn.langlang.langmovie.util.WechatUserUtil;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
@RequestMapping("/wechat")
public class WechatLoginController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.appsecret}")
    private String appsecret;

    @Value("${wechat.login_url}")
    private String loginUrl;

    @Value("${wechat.success_login_url}")
    private String successLoginUrl;
    private WxMpService wxMpService;

    @GetMapping("/welcome")
    private String welcome() {
        // 1.根据appid和appsecret和回调地址配置微信授权
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(appid);
        wxMpConfigStorage.setSecret(appsecret);
        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
        // 完成配置后进行跳转
        String oauth2buildAuthorizationUrl = wxMpService.oauth2buildAuthorizationUrl(
                loginUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO,  null);

        return "redirect:" + oauth2buildAuthorizationUrl;
    }

    /**
     * 通过code拿到数据openid
     * @param code
     * @param returnUrl
     * @return 进行网站跳转
     */
    @GetMapping("/login")
    public String login(@RequestParam("code") String code,
                        @RequestParam("state") String returnUrl) {
        // 2.根据code换取AccessToken
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        // 3.进一步获取用户信息
        String openId = wxMpOAuth2AccessToken.getOpenId();
        /**
         * 写入数据库
         * 1. 查询openid 是否已经存在
         * 2. 如果不存在，首先插入user表，再插入user_info表
         *    如果存在，说明已经注册，不需要进行表的操作。
         */
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid(openId);

        /**
         * 如果是已经注册过，跳过获得用户信息
         * 将用户token写入redis
         * 跳转
         */
        UserInfo userInfoByOpenid = userInfoService.getUserInfoByOpenid(userInfo);
        if(userInfoByOpenid != null) {
            long pkUserid = userInfoByOpenid.getPkUserid();
            String token = UUID.randomUUID().toString().replace("-", "");
            redisService.insertUserToken(pkUserid,token);
            return "redirect:" + successLoginUrl;
        }

        /**
         * 再次提交请求
         * 拿到用户的基本信息
          */
        WxMpUser wxMpUser=null;
        try {
            wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        /**
         * 将用户信息存储到userInfo表中
         * 将用户的登录状态存储到redis中
         * 跳转
         */
        UserInfo userInfo1 = WechatUserUtil.createUserInfoFromWechatUser(wxMpUser);
        long userid = userService.insertNewUser(userInfo1);
        redisService.insertUserToken(userid,wxMpOAuth2AccessToken.getAccessToken());
        return "redirect:" + successLoginUrl;
    }
    private RestControllerHelper helper = new RestControllerHelper();


    @GetMapping("/user/{userid}/{token}")
    @ResponseBody
    private Map<String,Object> getUserInfo(@PathVariable(name = "userid") Long userid,
                                           @PathVariable(name = "token") String token) {
        if(userid==null) {
            helper.setData("用户id不能为空");
            helper.setMsg("NULL_USERID");
            return helper.toJsonMap();
        }
        if(token==null || token.equals("")) {
            helper.setData("token不能为空");
            helper.setMsg("NULL_TOKEN");
            return helper.toJsonMap();
        }
        // 1. id和token是否匹配
        boolean b = redisService.checkLoginState(userid, token);
        if(b == false) {
            helper.setData("用户id和token不匹配");
            helper.setMsg("ERROR_LOGIN");
            return helper.toJsonMap();
        }
        // 2. 获得用户信息VO
        UserVO userVO = userService.getUserVO(userid);

        // 3. 返回UserVO
        helper.setData(userVO);
        helper.setMsg("SUCCESS");
        return helper.toJsonMap();
    }

}
