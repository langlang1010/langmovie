package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.entity.Manager;
import cn.langlang.langmovie.service.ManagerService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Api
@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {
    private static final Log LOGGER = LogFactory.getLog(ManagerController.class);
    @Autowired
    private ManagerService managerService;

    private RestControllerHelper helper = new RestControllerHelper();

    @ApiOperation("添加管理员")
    @PostMapping("/add/")
    private Map<String,Object> addManager(Long userid,Long cinemaid) {
        if(userid==null) {
            helper.setData("userid不能为空！");
            return helper.toJsonMap();
        }
        if(cinemaid==null) {
            helper.setData("cinemaid不能为空！");
            return helper.toJsonMap();
        }
        // 设置manager
        Manager manager = new Manager();
        manager.setFkUser(userid);
        manager.setFkCinema(cinemaid);
        manager.setGmtCreate(new Date());
        manager.setGmtModified(new Date());

        // 是否添加成功
        if(managerService.insertManager(manager)>0) {
            helper.setData("添加成功！");
            return helper.toJsonMap();
        }
        helper.setData("此记录已经添加过！");
        return helper.toJsonMap();
    }

    @ApiOperation("根据用户id查询他所管辖的影院")
    @GetMapping("/list/{userid}")
    private Map<String,Object> listManagerByUserid(@PathVariable("userid") Long userid) {
        List<Manager> list = managerService.listManagerByUserid(userid);
        return helper.toJsonMap();
    }

}
