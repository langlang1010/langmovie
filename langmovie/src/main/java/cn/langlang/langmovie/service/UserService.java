package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.TestUser;

/**
 * @author smileyan
 */
public interface UserService {
    /**
     * 根据id查询User
     * @param userId
     * @return user
     */
    TestUser getUserById(Integer userId);
}
