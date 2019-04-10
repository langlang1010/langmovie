package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author smileyan
 */
public interface UserDao {

    /**
     * 根据id查询user
     * @param user_id
     * @return TestUser
     */
    User getUserById(Integer user_id);

    /**
     *
     * @param user
     * @return 用户ID
     */
    int insertUser(User user);

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
    List<User> listUser(@Param("page1") int page1, @Param("num") int num);
}
