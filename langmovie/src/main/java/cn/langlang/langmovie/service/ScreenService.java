package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Screen;

import java.util.List;

public interface ScreenService {
    /**
     *
     * @param screen
     * @return
     */
    Long insertScreen(Screen screen);

    /**
     *
     * @param screen
     * @return
     */
    Screen getScreenById(Screen screen);

    /**
     *
     * @param screen
     * @return
     */
    int updateScreen(Screen screen);

    /**
     *
     * @param screen
     * @return
     */
    int deleteScreen(Screen screen);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<Screen> listScreen(int page1,int num);
}
