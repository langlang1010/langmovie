package cn.langlang.langmovie.controller;

import cn.langlang.langmovie.bean.FormVO;
import cn.langlang.langmovie.bean.RoomSeat;
import cn.langlang.langmovie.bean.ScreenVO;
import cn.langlang.langmovie.entity.Form;
import cn.langlang.langmovie.entity.Movie;
import cn.langlang.langmovie.entity.Screen;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.service.FormService;
import cn.langlang.langmovie.service.MovieService;
import cn.langlang.langmovie.service.ScreenService;
import cn.langlang.langmovie.service.UserService;
import cn.langlang.langmovie.util.RestControllerHelper;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static cn.langlang.langmovie.service.FormService.NOT_ENOUGH_MONEY;
import static cn.langlang.langmovie.service.FormService.SEAT_ORDERED;

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
    @Autowired
    private MovieService movieService;
    @Value("${page_count}")
    private int page_count;

    private RestControllerHelper helper = new RestControllerHelper();
    private static final String NULL_SCREENID = "场次号screenid不能为空";
    private static final String NULL_USERID = "用户编号不能为空";
    private static final String NULL_SEAT = "座位号不能为空";
    private static final String NOT_ENOUGH_MONEY_NOTE = "用户余额不足。";
    private static final String SEAT_ORDERED_NOTE = "你所选择的座位已经被占。";

    private static final String NULL_USER_FORM = "用户表单为空";
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
        // 座位已经被占
        if(result==SEAT_ORDERED) {
            helper.setData(SEAT_ORDERED_NOTE);
            return helper.toJsonMap();
        }
        helper.setData("成功添加"+result+"个订单");
        LOGGER.info("Add "+result+" forms successfully !");
        return helper.toJsonMap();
    }

    @ApiOperation("展示用户的所有订单")
    @GetMapping("/user/{userid}")
    private Map<String,Object> listUserForm(@PathVariable("userid") Long userid) {
        if(userid == null) {
            helper.setData(NULL_USERID);

            return helper.toJsonMap();
        }

        List<FormVO> list = new LinkedList<>();
        /**
         *  1. 获得所有订单（不含重复code)
         *  2. 根据code查询对应的订单
         */
        List<String> codes = formService.listCodesByUserid(userid);
        if(codes==null) {
            helper.setData(NULL_USER_FORM);
            helper.setMsg("FAILURE");
            return helper.toJsonMap();
        }
        for (int i = 0; i < codes.size(); i++) {
            String code = codes.get(i);
            FormVO formVO = new FormVO();
            formVO.setCode(code);
            List<Form> forms = formService.listFormByCode(code);
            long screenid = forms.get(0).getFkScreen();

            for (int j = 0; j < forms.size(); j++) {

            }
        }
        return helper.toJsonMap();
    }
}
