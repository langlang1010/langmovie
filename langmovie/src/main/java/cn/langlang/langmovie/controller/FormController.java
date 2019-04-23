package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.RoomSeat;
import cn.langlang.langmovie.entity.Screen;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.service.FormService;
import cn.langlang.langmovie.service.ScreenService;
import cn.langlang.langmovie.service.UserService;
import cn.langlang.langmovie.util.RestControllerHelper;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import static cn.langlang.langmovie.service.FormService.NOT_ENOUGH_MONEY;

@Api
@RestController
@CrossOrigin
@RequestMapping("/form")
public class FormController {
    @Autowired
    private FormService formService;
    @Autowired
    private UserService userService;
    @Autowired
    private ScreenService screenService;

    private RestControllerHelper helper = new RestControllerHelper();
    private static final String NULL_SCREENID = "场次号screenid不能为空";
    private static final String NULL_USERID = "用户编号不能为空";
    private static final String NULL_SEAT = "座位号不能为空";
    private static final String NOT_ENOUGH_MONEY_NOTE = "用户余额不足。";

    private static final Log LOGGER = LogFactory.getLog(FormService.class);

    @ApiOperation(value = "添加订单",notes = "其中seatJson是指json格式的数组，例如：[{x:3,y:5},{x:3,y:4}] ，需要前端进行处理成这种格式")
    @PostMapping("/add")
    private Map<String,Object> add(Long screenid,Long userid,String seatJson,String token) {
        if(screenid==null) {
            helper.setData(NULL_SCREENID);
            return helper.toJsonMap();
        }
        if(userid==null) {
            helper.setData(NULL_USERID);
            return helper.toJsonMap();
        }
        if(seatJson==null) {
            helper.setData(NULL_SEAT);
            return helper.toJsonMap();
        }

        /**
         *  转换成JSONArray的格式，
         *  再转换成list格式，
         *  并且指定list的泛型
          */
        JSONArray jsonArray = JSONArray.parseArray(seatJson);
        List<RoomSeat> roomSeats = jsonArray.toJavaList(RoomSeat.class);
        LOGGER.info("Before add order when userid:"+userid+" and screenid:"+screenid+" and seats:"+seatJson);
        int result = formService.insertForms(userid, screenid, roomSeats);

        // 余额不足
        if(result==NOT_ENOUGH_MONEY) {
            helper.setData(NOT_ENOUGH_MONEY_NOTE);
            return helper.toJsonMap();
        }
        helper.setData("成功添加"+result+"订单");
        LOGGER.info("Add "+result+" forms successfully !");
        return helper.toJsonMap();
    }
}
