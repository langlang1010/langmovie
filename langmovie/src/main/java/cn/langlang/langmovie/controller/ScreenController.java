package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.CinemaScreenVO;
import cn.langlang.langmovie.bean.ScreenVO;
import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.entity.Movie;
import cn.langlang.langmovie.entity.Screen;
import cn.langlang.langmovie.service.CinemaService;
import cn.langlang.langmovie.service.MovieService;
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
    private static final String NULL_MOVIEID = "电影编号不能为空";
    private static final String NULL_CINEMAID = "影院编号不能为空";

    @Autowired
    private ScreenService screenService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaService cinemaService;
    private RestControllerHelper helper = new RestControllerHelper();

    @ApiOperation(value = "根据电影和电影院获得场次")
    @ApiParam(name = "cinemaid/movieid",value="电影院id/电影id")
    @GetMapping("/search/{cinemaid}/{movieid}")
    private Map<String,Object> listScreenByMovieAndCinema(@PathVariable("cinemaid") Long cinemaid,
                                                          @PathVariable("movieid") Long movieid) {
        if(cinemaid==null) {
            helper.setData(NULL_CINEMAID);
            helper.setMsg("FAILURE");
            return helper.toJsonMap();
        }
        if(movieid==null) {
            helper.setData(NULL_MOVIEID);
            helper.setMsg("FAILURE");
            return helper.toJsonMap();
        }
        List<ScreenVO> screens = screenService.listScreenVOByMovieAndCinema(movieid,cinemaid);
        Movie m = new Movie();
        m.setPkMovieid(movieid);
        Movie movie = movieService.getMovieById(m);
        Cinema c = new Cinema();
        c.setPkCinemaid(cinemaid);
        Cinema cinema = cinemaService.getCinemaById(c);
        CinemaScreenVO cinemaScreenVO = new CinemaScreenVO();
        cinemaScreenVO.setCinema(cinema);
        cinemaScreenVO.setMovie(movie);
        cinemaScreenVO.setScreens(screens);
        helper.setData(cinemaScreenVO);
        helper.setMsg("SUCCESS");
        return helper.toJsonMap();
    }

}
