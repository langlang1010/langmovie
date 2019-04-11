package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.ScreenDao;
import cn.langlang.langmovie.entity.Screen;
import cn.langlang.langmovie.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {
    @Autowired
    private ScreenDao screenDao;
    @Override
    public Long insertScreen(Screen screen) {
        if(screenDao.insertScreen(screen)>0) {
            return screen.getPkScreenid();
        }
        return -1L;
    }

    @Override
    public Screen getScreenById(Screen screen) {
        return screenDao.getScreenById(screen);
    }

    @Override
    public int updateScreen(Screen screen) {
        return screenDao.updateScreen(screen);
    }

    @Override
    public int deleteScreen(Screen screen) {
        return screenDao.deleteScreen(screen);
    }

    @Override
    public List<Screen> listScreen(int page1, int num) {
        return screenDao.listScreen(page1-1,num);
    }
}
