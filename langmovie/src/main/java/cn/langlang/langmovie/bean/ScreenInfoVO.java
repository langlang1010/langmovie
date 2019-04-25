package cn.langlang.langmovie.bean;

import java.util.Date;

public class ScreenInfoVO {
    private Long screenid;
    private String cinemaName;
    private String roomName;
    private String movieName;
    private Float price;
    private Date startTime;

    public Long getScreenid() {
        return screenid;
    }

    public void setScreenid(Long screenid) {
        this.screenid = screenid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
