package cn.langlang.langmovie.entity;

import java.util.Date;

public class MoviePost {
    private Long pkPostid;
    private Long fkMovieid;
    private String postUrl;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getPkPostid() {
        return pkPostid;
    }

    public void setPkPostid(Long pkPostid) {
        this.pkPostid = pkPostid;
    }

    public Long getFkMovieid() {
        return fkMovieid;
    }

    public void setFkMovieid(Long fkMovieid) {
        this.fkMovieid = fkMovieid;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
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
