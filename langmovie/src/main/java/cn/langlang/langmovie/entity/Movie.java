package cn.langlang.langmovie.entity;

import java.util.Date;

public class Movie {
    private Long pkMovieid;
    private String movieName;
    private Date movieRelease;
    private String introduction;
    private String movieType;
    private Float grade;
    private String post;
    private Date gmtCreate;
    private Date gmtModified;

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getPkMovieid() {
        return pkMovieid;
    }

    public void setPkMovieid(Long pkMovieid) {
        this.pkMovieid = pkMovieid;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(Date movieRelease) {
        this.movieRelease = movieRelease;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
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
