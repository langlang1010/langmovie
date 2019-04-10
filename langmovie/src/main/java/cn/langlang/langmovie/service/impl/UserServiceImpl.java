package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.UserDao;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author smileyan
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
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
}
