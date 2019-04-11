package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerTest {
    @Autowired
    private ManagerService managerService;
    @Test
    public void insertManager() {
        Manager manager = new Manager();
        manager.setFkCinema(1L);
        manager.setFkUser(1L);
        manager.setGmtCreate(new Date());
        manager.setGmtModified(new Date());
        System.out.println(managerService.insertManager(manager));
    }

    @Test
    public void search() {
        List<Manager> list = managerService.listManagerByUserid(1L,1,5);
        for(Manager manager:list) {
            System.out.println(manager.getFkCinema());
        }
    }

    @Test
    public void list() {
        List<Manager> list = managerService.listManagerByCinemaid(1L,1,3);
        for(Manager manager:list) {
            System.out.println(manager.getFkUser());
        }
    }

    @Test
    public void delete() {
        Manager manager = new Manager();
        manager.setFkUser(1L);
        manager.setFkCinema(1L);
        managerService.deleteManagerByCinemaAndUser(manager);

    }
}
