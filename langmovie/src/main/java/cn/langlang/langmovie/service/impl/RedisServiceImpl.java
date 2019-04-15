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
    public void insertUserToken(String userToken, long userid) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(userToken,userid+"",redisTimeout,TimeUnit.SECONDS);
    }

    @Override
    public boolean checkLoginState(String userToken, long userid) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String s = stringStringValueOperations.get(userToken);
        String s2 = userid + "";
        return s2.equals(s);
    }
}
