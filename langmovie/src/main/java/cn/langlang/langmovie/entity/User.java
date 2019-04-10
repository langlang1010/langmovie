package cn.langlang.langmovie.entity;

import java.util.Date;


/**
 * @author Smileyan
 */
public class User {
    private Long pkUserid;
    private String username;
    private String password;
    private String ukPhone;
    private String role;
    private Float money;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getPkUserid() {
        return pkUserid;
    }

    public void setPkUserid(Long pkUserid) {
        this.pkUserid = pkUserid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUkPhone() {
        return ukPhone;
    }

    public void setUkPhone(String ukPhone) {
        this.ukPhone = ukPhone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
