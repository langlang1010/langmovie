package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.bean.UserDetailVO;
import cn.langlang.langmovie.bean.UserVO;
import cn.langlang.langmovie.dao.UserDao;
import cn.langlang.langmovie.dao.UserInfoDao;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.entity.UserInfo;
import cn.langlang.langmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author smileyan
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Value("${init_money}")
    private float initMoney;
    @Override
    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }


    @Override
    public Long insertUser(User user) {
        if(userDao.insertUser(user)>0) {
          return user.getPkUserid();
        }
        return Long.valueOf(-1);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public List<User> listUser(int page1, int num) {
        return userDao.listUser(page1-1,num);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public long insertNewUser(UserInfo userInfo) {
        // 1. 插入user表，返回用户ID
        User user = new User();
        user.setGmtModified(new Date());
        user.setGmtCreate(new Date());
        user.setMoney(initMoney);
        if(userDao.insertUser(user)<=0) {
            return -1;
        }
        long userid = user.getPkUserid();
        userInfo.setPkUserid(userid);
        userInfoDao.insertUserInfo(userInfo);
        return userid;
    }

    @Override
    public User getUserLogin(String username, String password) {
        return userDao.getUserLogin(username,password);
    }

    @Override
    public UserVO getUserVO(Long userid) {
        return userDao.getUserVOByUserid(userid);
    }

    @Override
    public List<UserDetailVO> listUserDetail(int page1, int num) {
        return userDao.listUserDetail(page1-1,num);
    }

    @Override
    public int updateUserDetail(UserDetailVO userDetailVO) {
        userDetailVO.setGmtModified(new Date());
        return userDao.updateUserDetail(userDetailVO);
    }

}
