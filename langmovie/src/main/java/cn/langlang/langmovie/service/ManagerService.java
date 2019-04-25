package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Manager;

import java.util.List;

/**
 * @author Smileyan
 */
public interface ManagerService {
    /**
     *
     * @param manager
     * @return
     */
    Long insertManager(Manager manager);

    /**
     *
     * @param userid
     * @return
     */
    List<Manager> listManagerByUserid(long userid);

    /**
     *
     * @param cinemaid
     * @return
     */
    List<Manager> listManagerByCinemaid(long cinemaid);

    /**
     *
     * @param manager
     * @return
     */
    int deleteManagerByCinemaAndUser(Manager manager);

}
