package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.bean.City;
import cn.langlang.langmovie.dao.CinemaDao;
import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Smileyan
 */
@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaDao cinemaDao;
    @Override
    public Long insertCinema(Cinema cinema) {
        if(cinemaDao.insertCinema(cinema)>0) {
            return cinema.getPkCinemaid();
        }
        return Long.valueOf(-1);
    }

    @Override
    public Cinema getCinemaById(Cinema cinema) {
        return cinemaDao.getCinemaById(cinema);
    }

    @Override
    public int updateCinema(Cinema cinema) {
        return cinemaDao.updateCinema(cinema);
    }

    @Override
    public int deleteCinema(Cinema cinema) {
        return cinemaDao.deleteCinema(cinema);
    }

    @Override
    public List<Cinema> listCinema(int page1, int num) {
        return cinemaDao.listCinema(page1-1,num);
    }

    @Override
    public List<City> listAllCity() {
        return cinemaDao.listAlllCity();
    }

    @Override
    public List<Cinema> listCinemaByCity(String city) {
        return cinemaDao.listCinemaByCity(city);
    }

    @Override
    public List<Cinema> listCinemaByMoiveName(Long movieid, String city) {
        return cinemaDao.listCinemaByMovie(movieid,city);
    }

    @Override
    public Cinema getCinemaById(long cinemaid) {
        Cinema cinema = new Cinema();
        cinema.setPkCinemaid(cinemaid);
        return cinemaDao.getCinemaById(cinema);
    }
}
