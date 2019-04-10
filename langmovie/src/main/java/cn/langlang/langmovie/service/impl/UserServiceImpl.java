package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.UserDao;
import cn.langlang.langmovie.entity.TestUser;
import cn.langlang.langmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smileyan
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public TestUser getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
