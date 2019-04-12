package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Room;

import java.util.List;

public interface RoomService {
    /**
     *
     * @param room
     * @return
     */
    Long insertRoom(Room room);

    /**
     *
     * @param room
     * @return
     */
    Room getRoomById(Room room);

    /**
     *
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     *
     * @param room
     * @return
     */
    int deleteRoom(Room room);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<Room> listRoom(int page1,int num);
}
