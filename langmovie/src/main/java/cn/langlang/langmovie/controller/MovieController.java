package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.MovieShortInfo;
import cn.langlang.langmovie.entity.Movie;
import cn.langlang.langmovie.entity.MovieActor;
import cn.langlang.langmovie.entity.MoviePost;
import cn.langlang.langmovie.service.MovieActorService;
import cn.langlang.langmovie.service.MoviePostService;
import cn.langlang.langmovie.service.MovieService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api
@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieActorService movieActorService;
    @Autowired
    private MoviePostService moviePostService;

    private RestControllerHelper helper = new RestControllerHelper();

    @Value("${page_count}")
    private int page_count;

    @ApiOperation(value = "电影首页",notes = "默认放回第一页内容")
    @GetMapping("/index")
    private Map<String,Object> index() {
        helper.setCode(RestControllerHelper.SUCCESS);
        helper.setMsg("success");
        List<MovieShortInfo> list = movieService.listShortInfo(1,page_count);
        helper.setData(list);
        return helper.toJsonMap();
    }

    @ApiOperation(value = "添加page页内容")
    @ApiParam(name="page",value="页号")
    @GetMapping("/add/{page}")
    private Map<String,Object> add(@PathVariable(name = "page") String page) {
        if(page==""||page.equals("") || page==null) {
            return null;
        }
        helper.setCode(RestControllerHelper.SUCCESS);
        helper.setMsg("success");
        int p = Integer.parseInt(page);
        int page1 = page_count * (p-1) + 1;
        List<MovieShortInfo> list = movieService.listShortInfo(page1,page_count);
        helper.setData(list);
        return helper.toJsonMap();
    }

    @ApiOperation(value = "电影详情")
    @ApiParam(name = "movieid",value = "电影id")
    @GetMapping("/detail/{movieid}")
    private Map<String,Object> detail(@PathVariable(name = "movieid") String movieid) {
        if(movieid==""||movieid.equals("") || movieid==null) {
            return null;
        }
        long id = Long.parseLong(movieid);
        Movie temp = new Movie();
        temp.setPkMovieid(id);
        Movie movie = movieService.getMovieById(temp);
        helper.setData(movie);
        helper.setMsg("success");
        return helper.toJsonMap();
    }

    @ApiOperation(value = "电影剧照图片")
    @ApiParam(name = "movieid",value = "电影id")
    @GetMapping("/post/{movieid}")
    private Map<String,Object> post(@PathVariable(name = "movieid") String movieid) {
        if(movieid==""||movieid.equals("") || movieid==null) {
            return null;
        }
        Long id = Long.parseLong(movieid);
        MoviePost moviePost =  new MoviePost();
        moviePost.setFkMovieid(id);
        List<MoviePost> list = moviePostService.getPostByMovie(moviePost);
        helper.setData(list);
        helper.setMsg("success");
        return helper.toJsonMap();
    }

    @ApiOperation(value = "此电影演员列表")
    @ApiParam(name = "movieid",value = "电影id")
    @GetMapping("/role/{movieid}")
    private Map<String,Object> role(@PathVariable(name = "movieid") String movieid) {
        if(movieid==""||movieid.equals("") || movieid==null) {
            return null;
        }
        Long id = Long.parseLong(movieid);
        MovieActor movieActor = new MovieActor();
        movieActor.setFkMovieid(id);
        List<MovieActor> list = movieActorService.listMovieActorByMovie(movieActor);
        helper.setData(list);
        helper.setMsg("success");
        return helper.toJsonMap();
    }

}
