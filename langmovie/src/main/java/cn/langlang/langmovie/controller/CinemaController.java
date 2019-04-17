package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.City;
import cn.langlang.langmovie.service.CinemaService;
import cn.langlang.langmovie.util.ProvinceCityUtil;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
