package cn.langlang.langmovie.entity;

import java.util.Date;

public class MovieActor {
    private Long pkActorid;
    private Long fkMovieid;
    private String actorUrl;
    private String actorName;
    private String roleName;
    private Date gmtCreate;
    private Date gmtModified;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getActorName() {

        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

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
