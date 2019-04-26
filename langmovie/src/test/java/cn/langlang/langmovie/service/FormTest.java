package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.FormVO;
import cn.langlang.langmovie.bean.RoomSeat;
import cn.langlang.langmovie.dao.FormDao;
import cn.langlang.langmovie.entity.Form;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormTest {
    /*
    @Autowired
    private FormService formService;
    @Test
    public void add() {
        for (int i = 0; i < 6; i++) {
            Form form = new Form();
            form.setFkScreen(2L);
            form.setCode("dgdgdhhh");
            form.setGmtCreate(new Date());
            form.setGmtModified(new Date());
            form.setFkUser(1L);
            form.setSeatX((short) 1);
            form.setSeatY((short) 1);
            System.out.println("insertId:" + formService.insertForm(form));
        }
    }

    @Test
    public void search() {
        Form form = new Form();
        form.setPkFormid(2L);
        Form form1 = formService.getFormById(form);
        System.out.println(form1.getGmtCreate());
    }

    @Test
    public void update() {
        Form form = new Form();
        form.setGmtCreate(new Date());
        form.setPkFormid(2L);
        System.out.println(formService.updateForm(form));
    }

    @Test
    public void delete() {
        Form form = new Form();
        form.setPkFormid(5L);
        System.out.println(formService.deleteForm(form));
    }

    @Test
    public void list() {
        List<Form> list = formService.listForm(1,5);
        for(Form form:list) {
            System.out.println(form.getPkFormid());
        }
    }

    @Autowired
    private FormDao formDao;
    @Test
    public void listOrdered() {
//        System.out.println(formService.listRoomSeatsOrdered(2L).size());
        List<RoomSeat> list = formDao.listSeatOrdered(2L);
        System.out.println(list.size());
//        RoomSeat roomSeat = list.get(0);
        for(RoomSeat roomSeat:list) {
            System.out.println("("+roomSeat.getX()+","+roomSeat.getY()+")");
        }
    }

    @Test
    public void getFormidBySeat() {
        System.out.println(formService.existFormidBySeat(1L,(short)1,(short)2));
    }

    @Test
    public void testCode() {
        List<String> codes = formDao.listCodeByUserid(25L);
        System.out.println(codes.size());
    }

    @Test
    public void testCode2() {
        String code = "fffaf75bb4cb401a987fc330e9166862626cd6b248af4cbe808517a0261feaf9";
        FormVO formVOByCode = formDao.getFormVOByCode(code);
        if(formVOByCode!=null) {
            System.out.println(formVOByCode.getCinemaName());
        }
//        List<RoomSeat> seats = formDao.listRoomSeatByCode(code);
//        for(RoomSeat seat:seats) {
//            System.out.println(seat.getX()+","+seat.getY());
//        }

    }*/
}
