package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoTest {
    /*
    @Autowired
    private UserInfoService userInfoService;
    @Test
    public void add() {
        UserInfo userInfo = new UserInfo();
        for(long i=26; i<=46; i++) {
            userInfo.setPkUserid( i);
            userInfo.setOpenid(i+"OPEN");
            userInfo.setGmtCreate(new Date());
            userInfo.setGmtModified(new Date());
            userInfoService.insertUserInfo(userInfo);
        }
        System.out.println();
    }

    @Test
    public void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPkUserid(3L);
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
        System.out.println(userInfoService.updateUserInfo(userInfo));
    }

    @Test
    public void getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPkUserid((long) 1);
        UserInfo userInfo1 = userInfoService.getUserInfo(userInfo);
        System.out.println(userInfo1.getGmtCreate());
    }

    @Test
    public void getUserInfoByOpenid() {
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid("obXGhxLPQeDPD18cwudRYvZwUneo");
        UserInfo userInfo1 = userInfoService.getUserInfoByOpenid(userInfo);
        System.out.println(userInfo1.getPkUserid());
    }


    @Test
    public void listUserInfo() {
        List<UserInfo> list = userInfoService.listUserInfo(1,3);
        for(UserInfo userInfo:list) {
            System.out.println(userInfo.getGmtCreate());
        }
    }

    @Test
    public void deleteUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPkUserid((long) 1);
        System.out.println("deleted:"+userInfoService.deleteUserInfo(userInfo));
    }
    */
}
