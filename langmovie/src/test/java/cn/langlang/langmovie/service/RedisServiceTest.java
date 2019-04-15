package cn.langlang.langmovie.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void set() {
        redisService.insertUserToken("token",1333232L);
//        redisService.checkLoginState("token",1333232L);
    }

    @Test
    public void check() {
        System.out.println(redisService.checkLoginState("token",1333232L));
    }
}
