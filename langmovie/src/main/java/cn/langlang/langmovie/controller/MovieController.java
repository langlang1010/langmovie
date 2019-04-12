package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.MovieShortInfo;
import cn.langlang.langmovie.service.MovieService;
import cn.langlang.langmovie.util.RestControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    /**
     *
     */
    RestControllerHelper helper = new RestControllerHelper();

    @RequestMapping("/index")
    private Map<String,Object> index() {
        helper.setCode(RestControllerHelper.SUCCESS);
        helper.setMsg("success");
        List<MovieShortInfo> list = movieService.listShortInfo(6,5);
        helper.setData(list);
        return helper.toJsonMap();
    }
}
