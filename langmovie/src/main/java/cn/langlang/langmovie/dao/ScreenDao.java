package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.bean.FormVO;
import cn.langlang.langmovie.bean.ScreenInfoVO;
import cn.langlang.langmovie.bean.ScreenVO;
import cn.langlang.langmovie.entity.Screen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScreenDao {
    /**
     *
     * @param screen
     * @return
     */
    int insertScreen(Screen screen);

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
    List<Screen> listScreen(@Param("page1") int page1, @Param("num") int num);

    /**
     * 根据电影和电影院查询场次
     * @param movieid
     * @param cinemaid
     * @return
     */
    List<Screen> listScreenByMovieAndCinema(@Param("movieid") long movieid,
                                            @Param("cinemaid") long cinemaid);

    /**
     *
     * @param movieid
     * @param cinemaid
     * @return
     */
    List<ScreenVO> listScreenVOByMovieAndCity(@Param("movieid")long movieid,
                                              @Param("cinemaid")long cinemaid);

    /**
     *
     * @param screenid
     * @return
     */
    FormVO getFormVOByScreenid(@Param("screenid") long screenid);

    /**
     *
     * @param screenid
     * @return
     */
    ScreenInfoVO getScreenInfoByScreenid(@Param("screenid") long screenid);
}
