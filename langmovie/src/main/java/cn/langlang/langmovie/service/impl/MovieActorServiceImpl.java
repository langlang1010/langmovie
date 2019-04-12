package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.MovieActorDao;
import cn.langlang.langmovie.entity.MovieActor;
import cn.langlang.langmovie.service.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieActorServiceImpl implements MovieActorService {
    @Autowired
    private MovieActorDao movieActorDao;
    @Override
    public Long insertActor(MovieActor movieActor) {
        if(movieActorDao.insertActor(movieActor) > 0) {
            return movieActor.getPkActorid();
        }
        return -1L;
    }

    @Override
    public MovieActor getMovieActorById(MovieActor movieActor) {
        return movieActorDao.getMovieActorById(movieActor);
    }

    @Override
    public List<MovieActor> listMovieActorByMovie(MovieActor movieActor) {
        return movieActorDao.listMovieActorByMovie(movieActor);
    }

    @Override
    public List<MovieActor> listMovieAction(int page1, int num) {
        return movieActorDao.listMovieAction(page1-1,num);
    }

    @Override
    public int updateMovieAction(MovieActor movieActor) {
        return movieActorDao.updateMovieActor(movieActor);
    }

    @Override
    public int deleteActorById(MovieActor movieActor) {
        return movieActorDao.deleteActorById(movieActor);
    }

    @Override
    public int deleteActorByMovie(MovieActor movieActor) {
        return movieActorDao.deleteActorByMovie(movieActor);
    }

    @Override
    public List<String> listActorNameByMovie(Long movieid) {
        return movieActorDao.listActorNameByMovie(movieid);
    }
}
