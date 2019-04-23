package cn.langlang.langmovie.bean;

import cn.langlang.langmovie.entity.Cinema;
import cn.langlang.langmovie.entity.Screen;

import java.util.List;

public class CinemaAndScreen {
    private Cinema cinema;
    private List<Screen> screens;

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
