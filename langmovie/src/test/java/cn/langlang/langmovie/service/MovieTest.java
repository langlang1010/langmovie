package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieTest {
    @Autowired
    private MovieService movieService;
    @Test
    public void add() {
        for (int i = 0; i < 10; i++){
            Movie movie = new Movie();
        movie.setGmtCreate(new Date());
        movie.setGmtModified(new Date());
        movie.setMovieName("三个和尚");
        System.out.println("insert:" + movieService.insertMovie(movie));
        System.out.println("movie_id:" + movie.getPkMovieid());
    }
    }

    @Test
    public void search() {
        Movie movie = new Movie();
        movie.setPkMovieid((long) 1);
        Movie movie1 = movieService.getMovieById(movie);
        System.out.println(movie1.getMovieName());
    }

    @Test
    public void update() {
        Movie movie = new Movie();
        movie.setPkMovieid((long) 1);
        movie.setGmtModified(new Date());
        movie.setGrade(7.9F);
        movie.setPost("ddss");
        System.out.println("update:"+movieService.updateMovie(movie));
    }

    @Test
    public void delete() {
        Movie movie=new Movie();
        movie.setPkMovieid((long) 1);
        System.out.println("deleted:"+movieService.deleteMovie(movie));
    }

    @Test
    public void list() {
        List<Movie> list=movieService.listMovie(1,3);
        for(Movie movie:list) {
            System.out.println(movie.getPkMovieid());
        }
    }
}
