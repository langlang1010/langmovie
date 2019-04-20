package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.UserDetailVO;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.service.RedisService;
import cn.langlang.langmovie.service.UserService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author Smileyan
 */
@Api
@CrossOrigin
@RestController
@RequestMapping("/back")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JdbcRealm jdbcRealm;

    private static final String NULL_USERNAME="用户名不能为空";
    private static final String NULL_PASSWORD="用户名不能为空";
    private static final String ERROR_USERNAME="用户名不存在";
    private static final String ERROR_PASSWORD="密码错误";

    private RestControllerHelper helper = new RestControllerHelper();
    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "后台登录地址")
    @PostMapping("/login")
    private Map<String,Object> login(String username,String password) {
        // 1. 检查是否为空
        if(username==null || username.equals("")) {
            helper.setData(NULL_USERNAME);
            return helper.toJsonMap();
        }
        if(password==null || password.equals("")) {
            helper.setData(NULL_PASSWORD);
            return helper.toJsonMap();
        }

        // 2. 数据库中查询
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (Exception e) {
            if(e instanceof org.apache.shiro.authc.IncorrectCredentialsException) {
                helper.setMsg("ERROR_PASSWORD");
                helper.setData(ERROR_PASSWORD);
            }else if(e instanceof org.apache.shiro.authc.UnknownAccountException) {
                helper.setMsg("ERROR_USERNAME");
                helper.setData(ERROR_USERNAME);
            }
        }
        if(subject.isAuthenticated()==false) {
            return helper.toJsonMap();
        }
        User user = userService.getUserLogin(username,password);
        helper.setData(user);
        helper.setMsg("SUCCESS");

        // 3. 写入redis缓存
        String userToken = UUID.randomUUID().toString()+UUID.randomUUID().toString().replace("-","");;
        redisService.insertUserToken(user.getPkUserid(),userToken);
        // 4. 返回并跳转

        return helper.toJsonMap();
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/update")
    private Map<String,Object> updateUser(UserDetailVO userDetailVO) {
        userService.updateUserDetail(userDetailVO);
        helper.setData("更改成功！");
        helper.setMsg("SUCCESS");
        helper.setCode(200);
        return helper.toJsonMap();
    }
}
