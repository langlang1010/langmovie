package cn.langlang.langmovie.bean;

import cn.langlang.langmovie.entity.Screen;

import java.util.Date;
import java.util.List;

public class ScreenVO {

    private String roomName;
    private Long pkScreenid;
    private Long fkRoom;
    private Long fkMovie;
    private Float price;
    private Date beginTime;
    private Date endTime;
    private Date gmtCreate;
    private Date gmtModified;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getPkScreenid() {
        return pkScreenid;
    }

    public void setPkScreenid(Long pkScreenid) {
        this.pkScreenid = pkScreenid;
    }

    public Long getFkRoom() {
        return fkRoom;
    }

    public void setFkRoom(Long fkRoom) {
        this.fkRoom = fkRoom;
    }

    public Long getFkMovie() {
        return fkMovie;
    }

    public void setFkMovie(Long fkMovie) {
        this.fkMovie = fkMovie;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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