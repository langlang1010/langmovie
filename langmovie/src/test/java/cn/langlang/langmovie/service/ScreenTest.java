package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.ScreenInfoVO;
import cn.langlang.langmovie.bean.ScreenVO;
import cn.langlang.langmovie.dao.ScreenDao;
import cn.langlang.langmovie.entity.Screen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScreenTest {
    @Autowired
    private ScreenService screenService;
    @Test
    public void add() {
        for (int i = 0; i <6 ; i++) {
            Screen screen = new Screen();
            Date date = new Date();
            screen.setBeginTime(date);
            screen.setEndTime(date);
            screen.setGmtCreate(date);
            screen.setGmtModified(date);
            screen.setFkMovie(1L);
            screen.setFkRoom(1L);
            screen.setPrice(50F);
            System.out.println("insertId:" + screenService.insertScreen(screen));
        }
    }

    @Test
    public void search() {
        Screen screen = new Screen();
        screen.setPkScreenid(1L);
        Screen screen1 = screenService.getScreenById(screen);
        System.out.println(screen1.getGmtCreate());
    }

    @Test
    public void update() {
        Screen screen = new Screen();
        screen.setPkScreenid(1L);
        screen.setGmtCreate(new Date());
        System.out.println("update:"+screenService.updateScreen(screen));
    }

    @Test
    public void delete() {
        Screen screen = new Screen();
        screen.setPkScreenid(1L);
        System.out.println("delete:"+screenService.deleteScreen(screen));
    }

    @Test
    public void list() {
        List<Screen> screens = screenService.listScreen(1, 3);
        for(Screen screen:screens) {
            System.out.println(screen.getPkScreenid());
        }
    }

    @Test
    public void listScreen() {
        List<Screen> screens = screenService.listScreenByMovieAndCinema(1L,1L);
        System.out.println("总共有 "+screens.size()+" 场");
        for(Screen screen:screens) {
            System.out.println(screen.getBeginTime());
        }
    }

    @Test
    public void listScreenVO() {
        List<ScreenVO> screens = screenService.listScreenVOByMovieAndCinema(1L,1L);
        System.out.println("总共有 "+screens.size()+" 场");
        for(ScreenVO screen:screens) {
            System.out.println(screen.getBeginTime());
        }
    }

    @Autowired
    private ScreenDao screenDao;
    @Test
    public void screenInfo() {
        ScreenInfoVO screenInfoVO = screenDao.getScreenInfoByScreenid(2L);
        System.out.println(screenInfoVO.getCinemaName()+":"+screenInfoVO.getRoomName());
    }
}
