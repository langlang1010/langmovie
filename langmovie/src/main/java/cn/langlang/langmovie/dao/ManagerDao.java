package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerDao {
    /**
     *
     * @param manager
     * @return
     */
    int insertManager(Manager manager);

    /**
     *
     * @param userid
     * @return
     */
    List<Manager> listManagerByUserid(@Param("userid") long userid,
                                      @Param("page1") int page1,@Param("num") int num);

    /**
     *
     * @param cinemaid
     * @param page1
     * @param num
     * @return
     */
    List<Manager> listManagerByCinemaid(@Param("cinemaid") long cinemaid,
                                        @Param("page1") int page1,@Param("num") int num);

    /**
     *
     * @param manager
     * @return
     */
    int deleteManagerByCinemaAndUser(Manager manager);

}
