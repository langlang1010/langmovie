package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.UserDetailVO;
import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.entity.Movie;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.service.CinemaService;
import cn.langlang.langmovie.service.MovieService;
import cn.langlang.langmovie.service.UserService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @ApiOperation(value = "删除用户")
    @PostMapping("/user/delete")
    private Map<String,Object> deleteUser(String userid) {
        User user = new User();
        long id = Long.parseLong(userid);
        user.setPkUserid(id);
        if(userService.deleteUser(user)>0) {
            helper.setMsg("SUCCESS");
            helper.setData("成功删除！");
        }else {
            helper.setMsg("FAILURE");
            helper.setData("删除失败！");
        }
        return helper.toJsonMap();
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/user/update")
    private Map<String,Object> updateUser(UserDetailVO userDetailVO) {
        if(userDetailVO.getPhone()!=null&&userDetailVO.getPhone().length()<=0) {
            userDetailVO.setPhone(null);
        }
        userService.updateUserDetail(userDetailVO);
        helper.setData("更改成功！");
        helper.setMsg("SUCCESS");
        helper.setCode(200);
        return helper.toJsonMap();
    }


    @Autowired
    private CinemaService cinemaService;

    @ApiOperation("添加电影影院")
    @PostMapping("/cinema/add")
    private Map<String,Object> insertCinema(Cinema cinema) {
        cinema.setGmtCreate(new Date());
        cinema.setGmtModified(new Date());
        cinema.setMoney(0F);
        if(cinemaService.insertCinema(cinema)>0) {
            helper.setData("添加成功");
            helper.setMsg("SUCCESS");
        }
        return helper.toJsonMap();
    }

    @GetMapping("/cinema/all")
    private Map<String,Object> listAllCinema(String num) {
        int n;
        if(num==null || num.equals("")) {
            n = 50;
        }else {
            n = Integer.parseInt(num);
        }
        List<Cinema> cinemas = cinemaService.listCinema(1, n);
        helper.setData(cinemas);
        helper.setMsg("SUCCESS");
        return helper.toJsonMap();
    }

    @ApiOperation("删除影院")
    @PostMapping("/cinema/delete")
    private Map<String,Object> delete(String cinemaid) {
        long id = Long.parseLong(cinemaid);
        Cinema cinema = new Cinema();
        cinema.setPkCinemaid(id);
        if(cinemaService.deleteCinema(cinema)>0) {
            helper.setData("删除成功！");
            helper.setMsg("SUCCESS");
        }
        return helper.toJsonMap();
    }

    @Autowired
    private MovieService movieService;

    @ApiOperation("显示所有电影")
    @RequestMapping("/movie/all")
    private Map<String,Object> listAllMovie() {
        List<Movie> movies = movieService.listMovie(1, 1000);
        helper.setData(movies);
        helper.setMsg("SUCCESS");
        return helper.toJsonMap();
    }

}
