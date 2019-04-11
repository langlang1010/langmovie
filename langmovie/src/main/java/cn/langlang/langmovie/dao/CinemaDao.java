package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.Cinema;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaDao {
    /**
     *
     * @param cinema
     * @return
     */
    int insertCinema(Cinema cinema);

    /**
     *
     * @param cinema
     * @return
     */
    Cinema getCinemaById(Cinema cinema);

    /**
     *
     * @param cinema
     * @return
     */
    int updateCinema(Cinema cinema);

    /**
     *
     * @param cinema
     * @return
     */
    int deleteCinema(Cinema cinema);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<Cinema> listCinema(@Param("page1") int page1, @Param("num") int num);
}
