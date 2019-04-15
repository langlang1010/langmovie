package cn.langlang.langmovie.bean;

import java.util.List;

/**
 * @author Smileyan
 */
public class MovieShortInfo {
    private Long pkMovieid;
    private String movieName;
    private Float grade;
    private List<String> roles_name;
    private String post;

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

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public List<String> getRoles_name() {
        return roles_name;
    }

    public void setRoles_name(List<String> roles_name) {
        this.roles_name = roles_name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
