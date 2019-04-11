package cn.langlang.langmovie.entity;

import java.util.Date;

public class MovieActor {
    private Long pkActorid;
    private Long fkMovieid;
    private String actorUrl;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getPkActorid() {
        return pkActorid;
    }

    public void setPkActorid(Long pkActorid) {
        this.pkActorid = pkActorid;
    }

    public Long getFkMovieid() {
        return fkMovieid;
    }

    public void setFkMovieid(Long fkMovieid) {
        this.fkMovieid = fkMovieid;
    }

    public String getActorUrl() {
        return actorUrl;
    }

    public void setActorUrl(String actorUrl) {
        this.actorUrl = actorUrl;
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
