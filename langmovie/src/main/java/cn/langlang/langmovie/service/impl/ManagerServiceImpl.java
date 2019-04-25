package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.ManagerDao;
import cn.langlang.langmovie.entity.Manager;
import cn.langlang.langmovie.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public Long insertManager(Manager manager) {
        if(managerDao.insertManager(manager)>0) {
            return manager.getFkUser();
        }
        return -1L;
    }

    @Override
    public List<Manager> listManagerByUserid(long userid) {
        return managerDao.listManagerByUserid(userid);
    }

    @Override
    public List<Manager> listManagerByCinemaid(long cinemaid) {
        return managerDao.listManagerByCinemaid(cinemaid);
    }

    @Override
    public int deleteManagerByCinemaAndUser(Manager manager) {
        return managerDao.deleteManagerByCinemaAndUser(manager);
    }

}
