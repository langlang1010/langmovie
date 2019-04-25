package cn.langlang.langmovie.bean;

import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.entity.Movie;

import java.util.List;

public class CinemaScreenVO {
    private Cinema cinema;
    private Movie movie;
    private List<ScreenVO> screens;

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<ScreenVO> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenVO> screens) {
        this.screens = screens;
    }
}
