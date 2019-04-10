package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void add() {
        User user = new User();
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        user.setMoney(0.0F);
        userService.insertUser(user);
        System.out.println(user.getPkUserid());
    }

    @Test
    public void search() {
        User user = userService.getUserById(1);
        System.out.println("username == "+ user.getUsername());
        System.out.println("create_time=="+ user.getGmtCreate());
    }

    @Test
    public void edit() {
        User user = new User();
        user.setPkUserid((long) 1);
        user.setMoney(98.5F);
        user.setGmtModified(new Date());
        System.out.println("update == "+userService.updateUser(user));
    }

    @Test
    public void delete() {
        User user = new User();
        user.setPkUserid((long) 2);
        System.out.println(userService.deleteUser(user));
    }

    @Test
    public void list() {
        List<User> list = userService.listUser(1,10);
        for(User user:list) {
            System.out.println("userid=="+user.getPkUserid());
        }

    }
}
