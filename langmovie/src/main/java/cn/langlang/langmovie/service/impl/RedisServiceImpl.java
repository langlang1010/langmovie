package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Value("${redis-timeout}")
    private int redisTimeout;

    @Override
    public boolean checkLoginState(long userid,String userToken) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String s = stringStringValueOperations.get(userid+"");
        String s2 = userToken + "";
        return s2.equals(s);
    }

    @Override
    public void insertUserToken(long userid, String userToken) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(userid+"",userToken,redisTimeout,TimeUnit.SECONDS);
    }
}
