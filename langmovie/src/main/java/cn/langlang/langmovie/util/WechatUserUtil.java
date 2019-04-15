package cn.langlang.langmovie.util;

import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.entity.UserInfo;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.Date;

public class WechatUserUtil {
    /**
     * 根据userid和mpUser创建UserInfo对象
     * @param mpUser
     * @return
     */
    public static UserInfo createUserInfoFromWechatUser(WxMpUser mpUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setGmtModified(new Date());
        userInfo.setGmtCreate(new Date());
        userInfo.setAvatarUrl(mpUser.getHeadImgUrl());
        userInfo.setCity(mpUser.getCity());
        userInfo.setCountry(mpUser.getCountry());
        userInfo.setNickname(mpUser.getNickname());
        userInfo.setGender(mpUser.getSex()+"");
        userInfo.setOpenid(mpUser.getOpenId());
        userInfo.setProvince(mpUser.getProvince());
        return userInfo;
    }

}
