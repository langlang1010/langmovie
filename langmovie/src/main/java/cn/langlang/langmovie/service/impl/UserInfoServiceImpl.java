package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.UserInfoDao;
import cn.langlang.langmovie.entity.UserInfo;
import cn.langlang.langmovie.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public int insertUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfo(UserInfo userInfo) {
        return userInfoDao.getUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfoByOpenid(UserInfo userInfo) {
        return userInfoDao.getUserInfoByOpenid(userInfo);
    }

    @Override
    public List<UserInfo> listUserInfo(int page1, int num) {
        return userInfoDao.listUserInfo(page1-1,num);
    }

    @Override
    public int deleteUserInfo(UserInfo userInfo) {
        return userInfoDao.deleteUserInfo(userInfo);
    }
}
