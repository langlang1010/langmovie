package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Movie;
import cn.langlang.langmovie.entity.MoviePost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviePostTest {
    @Autowired
    private MoviePostService moviePostService;
    @Test
    public void add() {
        for (int i = 0; i < 6; i++) {
            MoviePost moviePost = new MoviePost();
            moviePost.setGmtCreate(new Date());
            moviePost.setGmtModified(new Date());
            moviePost.setPostUrl("dd");
            moviePost.setFkMovieid(1L);
            System.out.println(moviePostService.insertPost(moviePost));
        }
    }

    @Test
    public void search() {
        MoviePost moviePost = new MoviePost();
        moviePost.setPkPostid(1L);
        System.out.println(moviePostService.getPostById(moviePost).getPostUrl());
    }

    @Test
    public void searchByMovie() {
        MoviePost moviePost = new MoviePost();
        moviePost.setFkMovieid(1L);
        List<MoviePost> moviePostList = moviePostService.getPostByMovie(moviePost);
        for(MoviePost moviePost1:moviePostList) {
            System.out.println(moviePost1.getPkPostid());
        }
    }

    @Test
    public void deleteById() {
        MoviePost moviePost = new MoviePost();
        moviePost.setPkPostid(1L);
        System.out.println(moviePostService.deleteById(moviePost));
    }

    @Test
    public void deleteByMovie() {
        MoviePost moviePost = new MoviePost();
        moviePost.setFkMovieid(1L);
        System.out.println(moviePostService.deleteByMovie(moviePost));
    }

    @Test
    public void update() {
        MoviePost moviePost = new MoviePost();
        moviePost.setPkPostid(9L);
        moviePost.setFkMovieid(2L);
        moviePostService.updatePost(moviePost);
    }

    @Test
    public void list() {
        List<MoviePost> list = moviePostService.listMoviePost(1,5);
        for(MoviePost moviePost:list) {
            System.out.println(moviePost.getPkPostid());
        }
    }
}
