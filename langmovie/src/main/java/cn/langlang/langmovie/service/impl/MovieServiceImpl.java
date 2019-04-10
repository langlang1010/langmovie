package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.MovieDao;
import cn.langlang.langmovie.entity.Movie;
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
}
