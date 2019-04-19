package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.entity.Screen;
import cn.langlang.langmovie.service.ScreenService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api
@CrossOrigin
@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    private RestControllerHelper helper = new RestControllerHelper();

    @ApiOperation(value = "根据电影和电影院获得场次")
    @ApiParam(name = "cinemaid/movieid",value="电影院id/电影id")
    @GetMapping("/search/{cinemaid}/{movieid}")
    private Map<String,Object> listScreenByMovieAndCinema(@PathVariable("cinemaid") long cinemaid,
                                                          @PathVariable("movieid") long movieid) {
        List<Screen> screens = screenService.listScreenByMovieAndCinema(movieid, cinemaid);
        helper.setData(screens);
        helper.setMsg("SUCCESS");
        return helper.toJsonMap();
    }

}
