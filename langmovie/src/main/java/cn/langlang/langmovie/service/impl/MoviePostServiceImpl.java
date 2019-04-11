package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.MoviePostDao;
import cn.langlang.langmovie.entity.MoviePost;
import cn.langlang.langmovie.service.MoviePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviePostServiceImpl implements MoviePostService {
    @Autowired
    private MoviePostDao moviePostDao;
    @Override
    public Long insertPost(MoviePost moviePost) {
        if(moviePostDao.insertPost(moviePost) > 0) {
            return moviePost.getPkPostid();
        }
        return -1L;
    }

    @Override
    public MoviePost getPostById(MoviePost moviePost) {
        return moviePostDao.getPostById(moviePost);
    }

    @Override
    public List<MoviePost> getPostByMovie(MoviePost moviePost) {
        return moviePostDao.getPostByMovie(moviePost);
    }

    @Override
    public int deleteById(MoviePost moviePost) {
        return moviePostDao.deletePostById(moviePost);
    }

    @Override
    public int deleteByMovie(MoviePost moviePost) {
        return  moviePostDao.deletePostByMovie(moviePost);
    }

    @Override
    public int updatePost(MoviePost moviePost) {
        return moviePostDao.updatePost(moviePost);
    }

    @Override
    public List<MoviePost> listMoviePost(int page1, int num) {
        return moviePostDao.listMoviePost(page1-1,num);
    }
}
