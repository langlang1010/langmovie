package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.MovieActor;
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
        int movie_num=6;
        long movie=6L;
        MovieActor movieActor = new MovieActor();
        movieActor.setFkMovieid(movie);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/1.jpg");
        movieActor.setRoleName("袁元");
        movieActor.setActorName("俞飞鸿");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/2.jpg");
        movieActor.setRoleName("森岛富哉");
        movieActor.setActorName("大泽隆夫");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/3.jpg");
        movieActor.setRoleName("木下彩音");
        movieActor.setActorName("keiko");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/4.jpg");
        movieActor.setRoleName("小森岛富哉");
        movieActor.setActorName("前田公辉");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/5.jpg");
        movieActor.setRoleName("卢洋洋");
        movieActor.setActorName("小袁元");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/6.jpg");
        movieActor.setRoleName("星由里子");
        movieActor.setActorName("美千代");
        movieActorService.insertActor(movieActor);

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

    @Test
    public void listName() {
        MovieActor movieActor = new MovieActor();
        movieActor.setFkMovieid(1L);
        List<String> list = movieActorService.listActorNameByMovie(1L);
        for(String s:list) {
            System.out.println(s);
        }
    }
}
