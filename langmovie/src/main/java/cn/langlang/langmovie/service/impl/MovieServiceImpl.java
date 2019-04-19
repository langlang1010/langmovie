package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.bean.MovieShortInfo;
import cn.langlang.langmovie.dao.MovieActorDao;
import cn.langlang.langmovie.dao.MovieDao;
import cn.langlang.langmovie.entity.Movie;
import cn.langlang.langmovie.entity.MovieActor;
import cn.langlang.langmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Smileyan
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private MovieActorDao movieActorDao;
    @Override
    public Long insertMovie(Movie movie) {
        if(movieDao.insertMovie(movie)>0) {
            return movie.getPkMovieid();
        }
        return Long.valueOf(-1);
    }

    @Override
    public Movie getMovieById(Movie movie) {
        return movieDao.getMovieById(movie);
    }

    @Override
    public int updateMovie(Movie movie) {
        return movieDao.updateMovie(movie);
    }

    @Override
    public int deleteMovie(Movie movie) {
        return movieDao.deleteMovie(movie);
    }

    @Override
    public List<Movie> listMovie(int page1, int num) {
        return movieDao.listMovie(page1-1,num);
    }

    @Override
    public MovieShortInfo getMovieShortInfoById(Long movieid) {
        MovieShortInfo movieShortInfo = movieDao.getMovieShortInfoById(movieid);
        List<String> actors_name = movieActorDao.listActorNameByMovie(movieid);
        movieShortInfo.setRoles_name(actors_name);
        return movieShortInfo;
    }

    @Override
    public List<MovieShortInfo> listShortInfo(int page1, int num) {
        List<MovieShortInfo> list = movieDao.listShortInfo(page1-1,num);
        for (int i = 0; i < list.size(); i++) {
            List<String> names = movieActorDao.listActorNameByMovie(list.get(i).getPkMovieid());
            list.get(i).setRoles_name(names);
        }
        return list;
    }

    @Override
    public List<MovieShortInfo> listMovieByName(String name) {
        String param = name + "%";
        List<MovieShortInfo> movies = movieDao.listMovieByName(param);
        for (int i = 0; i < movies.size(); i++) {
            List<String> names = movieActorDao.listActorNameByMovie(movies.get(i).getPkMovieid());
            movies.get(i).setRoles_name(names);
        }
        return movies;
    }

}
