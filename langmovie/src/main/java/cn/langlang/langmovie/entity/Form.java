package cn.langlang.langmovie.entity;

import java.util.Date;

public class Form {
    private Long pkFormid;
    private Long fkScreen;
    private Long fkUser;
    private Short seatX;
    private Short seatY;
    private String code;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getPkFormid() {
        return pkFormid;
    }

    public void setPkFormid(Long pkFormid) {
        this.pkFormid = pkFormid;
    }

    public Long getFkScreen() {
        return fkScreen;
    }

    public void setFkScreen(Long fkScreen) {
        this.fkScreen = fkScreen;
    }

    public Long getFkUser() {
        return fkUser;
    }

    public void setFkUser(Long fkUser) {
        this.fkUser = fkUser;
    }

    public Short getSeatX() {
        return seatX;
    }

    public void setSeatX(Short seatX) {
        this.seatX = seatX;
    }

    public Short getSeatY() {
        return seatY;
    }

    public void setSeatY(Short seatY) {
        this.seatY = seatY;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
