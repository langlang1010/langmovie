package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.UserDetailVO;
import cn.langlang.langmovie.bean.UserVO;
import cn.langlang.langmovie.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    /*
    @Autowired
    private UserService userService;
    @Test
    public void add() {
        User user = new User();
        for (long i = 1; i <= 20; i++) {
            user.setPkUserid(i);
            user.setGmtCreate(new Date());
            user.setGmtModified(new Date());
            user.setMoney(0.0F);
            userService.insertUser(user);
//            System.out.println(user.getPkUserid());
        }
    }

    @Test
    public void search() {
        User user = userService.getUserById(25L);
        System.out.println("username == "+ user.getUsername());
        System.out.println("create_time=="+ user.getGmtCreate());
    }

    @Test
    public void edit() {

        User user = new User();
        user.setPkUserid((long) 25);
        user.setMoney(95.5F);
        user.setGmtModified(new Date());
        System.out.println("update == "+userService.updateUser(user));
    }
    @Autowired
    private DataSource dataSource;

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

    @Autowired
    private JdbcRealm jdbcRealm;

    @Test
    public void login() {
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("we","ss");
        try {
            subject.login(token);
        }catch (Exception e) {
            if(e instanceof org.apache.shiro.authc.IncorrectCredentialsException) {
                System.out.println("密码错误");
            }else if(e instanceof org.apache.shiro.authc.UnknownAccountException) {
                System.out.println("用户名错误");
            }
            return ;
        }
        System.out.println(subject.isAuthenticated());
//        User user = userService.getUserLogin("aa","as");
//        System.out.println(user.getUsername());
    }

    @Test
    public void userInfo() {
        UserVO userVO = userService.getUserVO(1L);
        System.out.println(userVO.getNickname());

    }

    @Test
    public void listUserDetail() {
        List<UserDetailVO> list = userService.listUserDetail(1,10);
        for(UserDetailVO userDetailVO:list) {
            System.out.println(userDetailVO.getUserid());
        }
    }
    @Test
    public void testUpdate() {

    }
    */
}
