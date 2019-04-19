package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.bean.UserDetailVO;
import cn.langlang.langmovie.bean.UserVO;
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

    /**
     * 根据用户名和密码进行查找
     * @param username
     * @param password
     * @return
     */
    User getUserLogin(@Param("username")String username,@Param("password") String password);

    /**
     * 根据用户ID查询USERVO
     * @param userid
     * @return
     */
    UserVO getUserVOByUserid(@Param("userid")Long userid);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<UserDetailVO> listUserDetail(@Param("page1") int page1,
                                      @Param("num") int num);
}
