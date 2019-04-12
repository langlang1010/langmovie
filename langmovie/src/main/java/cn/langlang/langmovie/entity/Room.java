package cn.langlang.langmovie.entity;

import java.util.Date;

/**
 * @author Smileyan
 */
public class Room {
    private Long pkRoomid;
    private Long fkCinema;
    private String roomName;
    private Short roomRow;
    private Short roomColumn;
    private Date gmtCreate;
    private Date gmtModified;

    public Short getRoomColumn() {
        return roomColumn;
    }

    public void setRoomColumn(Short roomColumn) {
        this.roomColumn = roomColumn;
    }

    public Long getPkRoomid() {
        return pkRoomid;
    }

    public void setPkRoomid(Long pkRoomid) {
        this.pkRoomid = pkRoomid;
    }

    public Long getFkCinema() {
        return fkCinema;
    }

    public void setFkCinema(Long fkCinema) {
        this.fkCinema = fkCinema;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Short getRoomRow() {
        return roomRow;
    }

    public void setRoomRow(Short roomRow) {
        this.roomRow = roomRow;
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
