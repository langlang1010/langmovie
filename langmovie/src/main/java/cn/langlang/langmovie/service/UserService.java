package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.UserDetailVO;
import cn.langlang.langmovie.bean.UserVO;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.entity.UserInfo;

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

    /**
     *
     * @return userid
     */
    long insertNewUser(UserInfo userInfo);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User getUserLogin(String username,String password);

    /**
     *
     * @param userid
     * @return
     */
    UserVO getUserVO(Long userid);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<UserDetailVO> listUserDetail(int page1,int num);

    /**
     *
      * @param userDetailVO
     * @return
     */
    int updateUserDetail(UserDetailVO userDetailVO);
}
