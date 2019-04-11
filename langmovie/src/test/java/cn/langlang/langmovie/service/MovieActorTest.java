package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.MovieActor;
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
public class MovieActorTest {
    @Autowired
    private MovieActorService movieActorService;

    @Test
    public void add() {
//        for (int i = 0; i < 6; i++) {
            MovieActor movieActor = new MovieActor();
            movieActor.setGmtCreate(new Date());
            movieActor.setGmtModified(new Date());
            movieActor.setActorUrl("sgg");
            movieActor.setRoleName("dgdgg");
            movieActor.setActorName("dgdgg");
            movieActor.setFkMovieid(1L);
            System.out.println(movieActorService.insertActor(movieActor));
//        }
    }
    @Test
    public void getById() {
        MovieActor movieActor = new MovieActor();
        movieActor.setPkActorid(11L);
        System.out.println(movieActorService.getMovieActorById(movieActor).getGmtCreate());
    }

    @Test
    public void list() {
        List<MovieActor> list = movieActorService.listMovieAction(1,5);
        for (MovieActor actor:list) {
            System.out.println(actor.getPkActorid());
        }
    }

    @Test
    public void update() {
        MovieActor movieActor = new MovieActor();
        movieActor.setPkActorid(11L);
        movieActor.setRoleName("fddggg");
        movieActor.setActorName("gsssssssss");
        movieActor.setGmtCreate(new Date());
        System.out.println(movieActorService.updateMovieAction(movieActor));
    }

    @Test
    public void deleteById() {
        MovieActor movieActor = new MovieActor();
        movieActor.setPkActorid(1L);
        movieActorService.deleteActorById(movieActor);
    }

    @Test
    public void deleteByMovie() {
        MovieActor movieActor = new MovieActor();
        movieActor.setFkMovieid(1L);
        System.out.println(movieActorService.deleteActorByMovie(movieActor));
    }
}
