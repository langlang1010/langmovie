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
        int movie_num=11;
        long movie=11L;
        MovieActor movieActor = new MovieActor();
        movieActor.setFkMovieid(movie);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/1.jpg");
        movieActor.setRoleName("孙义");
        movieActor.setActorName("罗立群");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/2.jpg");
        movieActor.setRoleName("孙礼");
        movieActor.setActorName("高赫一");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/3.jpg");
        movieActor.setRoleName("小红女");
        movieActor.setActorName("金琦茗");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/4.jpg");
        movieActor.setRoleName("汪大人");
        movieActor.setActorName("郑亚龙");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/5.jpg");
        movieActor.setRoleName("于洋");
        movieActor.setActorName("陈立唯");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/6.jpg");
        movieActor.setRoleName("齐云");
        movieActor.setActorName("张扬");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/7.jpg");
        movieActor.setRoleName("舅舅");
        movieActor.setActorName("陈姗姗");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/8.jpg");
        movieActor.setRoleName("福兴");
        movieActor.setActorName("杨作玖");
        movieActorService.insertActor(movieActor);

        movieActor.setGmtCreate(new Date());
        movieActor.setGmtModified(new Date());
        movieActor.setActorUrl("https://withyan.cn/images/role/"+movie_num+"/9.jpg");
        movieActor.setRoleName("宫二");
        movieActor.setActorName("邢晓岩");
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
