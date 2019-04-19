package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.City;
import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.entity.Room;

import java.util.List;

/**
 * @author Smileyan
 */
public interface CinemaService {
    /**
     * @param cinema
     * @return
     */
    Long insertCinema(Cinema cinema);

    /**
     *
     * @param cinema
     * @return
     */
    Cinema getCinmaById(Cinema cinema);

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
    List<Cinema> listCinema(int page1,int num);

    /**
     *
     * @return
     */
    List<City> listAllCity();

    /**
     *
     * @param city
     * @return
     */
    List<Cinema> listCinemaByCity(String city);
}
