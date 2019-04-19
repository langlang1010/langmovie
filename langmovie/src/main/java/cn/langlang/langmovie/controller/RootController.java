package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.UserDetailVO;
import cn.langlang.langmovie.service.UserService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api
@CrossOrigin
@RestController
@RequestMapping("/root")
public class RootController {
    private RestControllerHelper helper = new RestControllerHelper();

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获得用户信息列表")
    @GetMapping("/user_info/{page}")
    private Map<String,Object> listUserDetail(String num,
                                              @PathVariable(name = "page") int page) {
        int n=10;
        if(num == null || num.equals("")) {

        }else {
           try {
               n = Integer.parseInt(num);
           }catch (Exception e) {
               if(e instanceof java.lang.NumberFormatException) {
                   n = 10;
               }
           }
        }
        List<UserDetailVO> list = userService.listUserDetail(page, n);
        helper.setData(list);
        helper.setMsg("SUCCESS");
        return helper.toJsonMap();
    }
}
