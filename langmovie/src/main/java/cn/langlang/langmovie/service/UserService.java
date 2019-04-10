package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.User;

import java.util.List;

/**
 * @author smileyan
 */
public interface UserService {
    /**
     * 根据id查询User
     * @param userId
     * @return user
     */
    User getUserById(Integer userId);

    /**
     * @param user
     * @return
     */
    Long insertUser(User user);

    /**
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     *
     * @param user
     * @return
     */
    int deleteUser(User user);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<User> listUser(int page1,int num);
}
