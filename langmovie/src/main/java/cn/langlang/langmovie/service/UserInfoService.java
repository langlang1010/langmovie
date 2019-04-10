package cn.langlang.langmovie.service;


import cn.langlang.langmovie.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);

    /**
     *
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     *
     * @param userInfo
     * @return
     */
    UserInfo getUserInfo(UserInfo userInfo);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<UserInfo> listUserInfo(int page1,int num);

    /**
     *
     * @param userInfo
     * @return
     */
    int deleteUserInfo(UserInfo userInfo);
}
