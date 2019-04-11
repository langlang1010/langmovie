package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.RoomDao;
import cn.langlang.langmovie.entity.Room;
import cn.langlang.langmovie.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;
    @Override
    public Long insertRoom(Room room) {
        if(roomDao.insertRoom(room)>0){
            return room.getPkRoomid();
        }
        return -1L;
    }

    @Override
    public Room getRoomById(Room room) {
        return roomDao.getRoomById(room);
    }

    @Override
    public int updateRoom(Room room) {
        return roomDao.updateRoom(room);
    }

    @Override
    public int deleteRoom(Room room) {
        return roomDao.deleteRoom(room);
    }

    @Override
    public List<Room> listRoom(int page1, int num) {
        return roomDao.listRoom(page1-1,num);
    }
}
