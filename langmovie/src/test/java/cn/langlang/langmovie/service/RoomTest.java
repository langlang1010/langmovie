package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomTest {
    /*
    @Autowired
    private RoomService roomService;

    @Test
    public void add() {
        Room room = new Room();
        room.setFkCinema(1L);
        room.setGmtCreate(new Date());
        room.setGmtModified(new Date());
        room.setRoomName("2");
        room.setRoomColumn((short)10);
        room.setRoomRow((short)10);
        System.out.println("roomid=="+roomService.insertRoom(room));
    }

    @Test
    public void search() {
        Room room = new Room();
        room.setPkRoomid(1L);
        Room room1 = roomService.getRoomById(room);
        System.out.println("room name == "+room1.getRoomName());
    }

    @Test
    public void update() {
        Room room = new Room();
        room.setPkRoomid(1L);
        room.setGmtCreate(new Date());
        System.out.println("update:" + roomService.updateRoom(room));
    }

    @Test
    public void delete() {
        Room room = new Room();
        room.setPkRoomid(1L);
        System.out.println("delete:"+roomService.deleteRoom(room));
    }

    @Test
    public void list() {
        List<Room> list = roomService.listRoom(1,3);
        for(Room room:list) {
            System.out.println(room.getPkRoomid());
        }
    }*/
}
