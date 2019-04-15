package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.service.UserService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author Smileyan
 */
@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private RestControllerHelper helper = new RestControllerHelper();

    @GetMapping("/login")
    private Map<String,Object> login(String code) {

        return helper.toJsonMap();
    }
}
