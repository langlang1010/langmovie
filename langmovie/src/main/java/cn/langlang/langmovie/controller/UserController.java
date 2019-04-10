package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    private Map<String,Object> findUserById(Integer userId){
        Map<String,Object> modelMap=new HashMap<>();
        User user = userService.getUserById(userId);
        modelMap.put("user",user);
        return modelMap;
    }

    @GetMapping("/")
    private String index(){
        return "hello world";
    }

}
