package cn.langlang.langmovie.service;

public interface RedisService {
    /**
     * 添加用户的token
     * @param userid
     * @param userToken
     * @return
     */
    void insertUserToken(long userid,String userToken);

    /**
     *
     * @param userToken
     * @param userid
     * @return
     */
    boolean checkLoginState(long userid,String userToken);
}
