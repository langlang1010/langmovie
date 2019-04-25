package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.ScreenInfoVO;
import cn.langlang.langmovie.bean.ScreenVO;
import cn.langlang.langmovie.entity.Screen;
import org.apache.ibatis.annotations.Param;

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

    /**
     *
     * @param movieid
     * @param cinemaid
     * @return
     */
    List<Screen> listScreenByMovieAndCinema(long movieid,long cinemaid);

    /**
     *
     * @param movieid
     * @param cinemaid
     * @return
     */
    List<ScreenVO> listScreenVOByMovieAndCinema(long movieid, long cinemaid);

    /**
     *
     * @param screenid
     * @return
     */
    ScreenInfoVO getScreenInfo(long screenid);
}
