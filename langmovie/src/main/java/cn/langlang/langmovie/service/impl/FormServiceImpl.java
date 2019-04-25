package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.bean.RoomSeat;
import cn.langlang.langmovie.dao.CinemaDao;
import cn.langlang.langmovie.dao.FormDao;
import cn.langlang.langmovie.dao.ScreenDao;
import cn.langlang.langmovie.dao.UserDao;
import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.entity.Form;
import cn.langlang.langmovie.entity.Screen;
import cn.langlang.langmovie.entity.User;
import cn.langlang.langmovie.service.FormService;
import cn.langlang.langmovie.util.TicketCodeHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    private static final Log LOGGER = LogFactory.getLog(FormServiceImpl.class);
    @Autowired
    private FormDao formDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ScreenDao screenDao;
    @Autowired
    private CinemaDao cinemaDao;
    @Override
    public Long insertForm(Form form) {
        if(formDao.insertForm(form)>0) {
            return form.getPkFormid();
        }
        return -1L;
    }

    @Override
    public Form getFormById(Form form) {
        return formDao.getFormById(form);
    }

    @Override
    public int updateForm(Form form) {
        return formDao.updateForm(form);
    }

    @Override
    public int deleteForm(Form form) {
        return formDao.deleteForm(form);
    }

    @Override
    public List<Form> listForm(int page1, int num) {
        return formDao.listForm(page1-1,num);
    }

    @Override
    public List<RoomSeat> listRoomSeatsOrdered(long screenid) {
        return formDao.listSeatOrdered(screenid);
    }

    @Override
    public int insertForms(long userid, long screenid, List<RoomSeat> seats) {
        // 查询用户的余额是否充足
        User user = userDao.getUserById(userid);
        Screen temp = new Screen();
        temp.setPkScreenid(screenid);
        Screen screen = screenDao.getScreenById(temp);
        float total = screen.getPrice()*seats.size();
        // 余额不足
        if(user.getMoney()<total) {
            LOGGER.info("not enough money return "+NOT_ENOUGH_MONEY);
            return NOT_ENOUGH_MONEY;
        }
        // 判断位置是否已经购买
        for(int i=0; i<seats.size(); i++) {
            RoomSeat roomSeat = seats.get(i);
            if(this.existFormidBySeat(screenid,roomSeat.getX(),roomSeat.getY())) {
                return SEAT_ORDERED;
            }
        }


        Cinema cinema = cinemaDao.getCinemaByRoom(screen.getFkRoom());

        int count = 0;
        Form form = new Form();
        form.setFkUser(userid);
        form.setFkScreen(screenid);
        form.setGmtCreate(new Date());
        form.setGmtModified(new Date());
        form.setCode(TicketCodeHelper.getTicketCode());

        // 循环insert
        for(RoomSeat seat:seats) {
            form.setSeatX(seat.getX());
            form.setSeatY(seat.getY());
            formDao.insertForm(form);
            user.setMoney(user.getMoney()-screen.getPrice());
            userDao.updateUser(user);
            cinema.setMoney(cinema.getMoney()+screen.getPrice());
            cinemaDao.updateCinema(cinema);
            count++;
        }
        return count;
    }

    @Override
    public boolean existFormidBySeat(long screenid,short x, short y) {
        return formDao.getFormidBySeat(screenid,x,y)!=null;
    }

    @Override
    public List<Form> listFormByUserid(Long userid, int page1, int num) {
        return formDao.listFormByUserid(userid,page1-1,num);
    }

    @Override
    public List<String> listCodesByUserid(Long userid) {
        return formDao.listCodeByUserid(userid);
    }

    @Override
    public List<Form> listFormByCode(String code) {
        return formDao.listFormByCode(code);
    }


}
