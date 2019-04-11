package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomDao {
    /**
     *
     * @param room
     * @return
     */
    int insertRoom(Room room);

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
    List<Room> listRoom(@Param("page1") int page1, @Param("num") int num);
}
