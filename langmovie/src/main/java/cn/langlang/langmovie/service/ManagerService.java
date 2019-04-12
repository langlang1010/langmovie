package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.Manager;

import java.util.List;

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
     * @param page1
     * @param num
     * @return
     */
    List<Manager> listManagerByUserid(long userid,int page1,int num);

    /**
     *
     * @param cinemaid
     * @param page1
     * @param num
     * @return
     */
    List<Manager> listManagerByCinemaid(long cinemaid,int page1,int num);

    /**
     *
     * @param manager
     * @return
     */
    int deleteManagerByCinemaAndUser(Manager manager);

}
