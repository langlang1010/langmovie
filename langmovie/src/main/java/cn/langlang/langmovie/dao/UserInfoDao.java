package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Smileyan
 */
public interface UserInfoDao {
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
     * @return
     */
    List<UserInfo> listUserInfo(@Param("page1") int page1, @Param("num") int num);

    /**
     *
     * @param userInfo
     * @return
     */
    int deleteUserInfo(UserInfo userInfo);
}
