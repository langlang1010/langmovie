package cn.langlang.langmovie.util;

import cn.langlang.langmovie.bean.UserVO;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.entity.UserInfo;

public class UserVOUtil {
    public UserVO makeUserVO(User user, UserInfo userInfo) {
        UserVO userVO = new UserVO();

        userVO.setCity(userInfo.getCity());
        userVO.setHeadimage(userInfo.getAvatarUrl());
        userVO.setNickname(userInfo.getNickname());
        userVO.setGender(userInfo.getGender());
        userVO.setMoney(user.getMoney());
        userVO.setOpenid(userInfo.getOpenid());
        userVO.setUserid(user.getPkUserid());
        userVO.setProvince(userInfo.getProvince());

        return userVO;
    }
}
