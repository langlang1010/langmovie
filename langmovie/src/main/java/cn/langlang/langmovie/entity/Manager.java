package cn.langlang.langmovie.entity;

import java.util.Date;

public class Manager {
    private Long fkUser;
    private Long fkCinema;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getFkUser() {
        return fkUser;
    }

    public void setFkUser(Long fkUser) {
        this.fkUser = fkUser;
    }

    public Long getFkCinema() {
        return fkCinema;
    }

    public void setFkCinema(Long fkCinema) {
        this.fkCinema = fkCinema;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
