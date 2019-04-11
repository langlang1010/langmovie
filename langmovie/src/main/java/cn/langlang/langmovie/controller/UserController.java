package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.util.RestControllerHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author Smileyan
 */
@RestController
public class UserController {

    @RequestMapping("/test")
    private Map<String,Object> test(HttpServletResponse response) {
        RestControllerHelper helper = new RestControllerHelper();
        helper.setCode(RestControllerHelper.SUCCESS);
        helper.setMsg("success");
        // 这里setData可以是某个类的对象，可以是链表等等
        helper.setData(new Date());
        return  helper.toJsonMap();
    }
}
