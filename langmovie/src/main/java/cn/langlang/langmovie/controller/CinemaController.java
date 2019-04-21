package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.City;
import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.service.CinemaService;
import cn.langlang.langmovie.util.ProvinceCityUtil;
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
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;
    private RestControllerHelper helper = new RestControllerHelper();
    @ApiOperation(value = "显示所有省份和城市")
    @GetMapping("/listcity")
    private Map<String,Object> listCity() {
        List<City> cities = cinemaService.listAllCity();
        helper.setData(cities);
        helper.setData(ProvinceCityUtil.listProvinceCity(cities));
        return helper.toJsonMap();
    }

    @ApiOperation(value = "显示此城市的所有影院")
    @GetMapping("/all/{city}")
    private Map<String,Object> listAllCinema( @PathVariable(name = "city") String city) {
        if(city==null || city.equals("")) {
            helper.setData("城市名不能为空！");
            return helper.toJsonMap();
        }
        List<Cinema> cinemas = cinemaService.listCinemaByCity(city);
        helper.setData(cinemas);
        return helper.toJsonMap();
    }
    @ApiOperation(value = "显示该城市上映此电影的所有影院")
    @GetMapping("/{city}/{movieid}")
    private Map<String,Object> listCinemaByMovie( @PathVariable(name = "city") String city,
                                                  @PathVariable(name = "movieid") String movieid) {
        long id = Long.parseLong(movieid);
        List<Cinema> cinemas = cinemaService.listCinemaByMoiveName(id, city);
        helper.setData(cinemas);
        return helper.toJsonMap();
    }

    @ApiOperation("更新影院信息")
    @PostMapping("/update")
    private Map<String,Object> update(Cinema cinema) {
        cinema.setGmtModified(new Date());
        if(cinemaService.updateCinema(cinema) > 0) {
            helper.setData("更改成功");
            helper.setMsg("SUCCESS");
        }
        return helper.toJsonMap();
    }
}
