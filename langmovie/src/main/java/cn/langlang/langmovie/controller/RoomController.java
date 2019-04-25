package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.RoomSeat;
import cn.langlang.langmovie.service.FormService;
import cn.langlang.langmovie.util.RestControllerHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Api
@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private FormService formService;

    private RestControllerHelper restControllerHelper = new RestControllerHelper();

    @ApiOperation("展示已经选好的座位")
    @GetMapping("/ordered/{screenid}")
    private Map<String,Object> listSeatOrdered(@PathVariable("screenid") long screenid) {
        List<RoomSeat> list = formService.listRoomSeatsOrdered(screenid);
        restControllerHelper.setData(list);
        restControllerHelper.setMsg("SUCCESS");
        return restControllerHelper.toJsonMap();
    }
}
