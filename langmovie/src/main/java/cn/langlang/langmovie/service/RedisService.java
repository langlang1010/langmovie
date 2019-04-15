package cn.langlang.langmovie.service;

public interface RedisService {
    /**
     * 添加用户的token
     * @param userid
     * @param userToken
     * @return
     */
    void insertUserToken(String userToken,long userid);

    /**
     *
     * @param userToken
     * @param userid
     * @return
     */
    boolean checkLoginState(String userToken,long userid);
}
