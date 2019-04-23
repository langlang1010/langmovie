package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.bean.City;
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

    /**
     * 展示所有城市的省名和市名
     * @return
     */
    List<City> listAlllCity();

    /**
     * 根据城市显示所有影院
     * @param mcity
     * @return
     */
    List<Cinema> listCinemaByCity(@Param("mcity") String mcity);

    /**
     * 查询city城市里，播放movieid电影的影院
     * @param movieid
     * @param city
     * @return
     */
    List<Cinema> listCinemaByMovie(@Param("movieid")Long movieid,
                                   @Param("city") String city);

    /**
     * 根据roomid查询电影院
     * @param roomid
     * @return
     */
    Cinema getCinemaByRoom(@Param("roomid") long roomid);
}
