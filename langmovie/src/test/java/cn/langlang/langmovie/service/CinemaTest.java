package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Cinema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaTest {
    @Autowired
    private CinemaService cinemaService;
    @Test
    public void add() {
        Cinema cinema = new Cinema();
        cinema.setCinemaName("第一影院");
        cinema.setMoney(0F);
        cinema.setGmtCreate(new Date());
        cinema.setGmtModified(new Date());
        System.out.println("insertId:"+cinemaService.insertCinema(cinema));
    }

    @Test
    public void search() {
        Cinema cinema = new Cinema();
        cinema.setPkCinemaid(1L);
        Cinema cinema1 = cinemaService.getCinmaById(cinema);
        System.out.println(cinema1.getCinemaName());
    }

    @Test
    public void update() {
        Cinema cinema = new Cinema();
        cinema.setPkCinemaid(1L);
        cinema.setGmtModified(new Date());
        System.out.println(cinemaService.updateCinema(cinema));
    }

    @Test
    public void delete() {
        Cinema cinema = new Cinema();
        cinema.setPkCinemaid(2L);
        System.out.println(cinemaService.deleteCinema(cinema));
    }

    @Test
    public void listCinema() {
        List<Cinema> list = cinemaService.listCinema(1,3);
        for (Cinema cinema:list) {
            System.out.println(cinema.getPkCinemaid());
        }
    }
}
