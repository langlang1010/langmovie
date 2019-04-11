package cn.langlang.langmovie.entity;

import java.util.Date;

/**
 * @author Smileyan
 */
public class Cinema {
    private Long pkCinemaid;
    private String cinemaName;
    private String city;
    private String province;
    private String country;
    private String location;
    private Float money;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getPkCinemaid() {
        return pkCinemaid;
    }

    public void setPkCinemaid(Long pkCinemaid) {
        this.pkCinemaid = pkCinemaid;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
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
