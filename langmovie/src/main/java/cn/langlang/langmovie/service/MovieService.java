package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.MovieShortInfo;
import cn.langlang.langmovie.entity.Movie;

import java.util.List;

public interface MovieService {
    /**
     * @param movie
     * @return
     */
    Long insertMovie(Movie movie);

    /**
     *
     * @param movie
     * @return
     */
    Movie getMovieById(Movie movie);

    /**
     *
     * @param movie
     * @return
     */
    int updateMovie(Movie movie);

    /**
     *
     * @param movie
     * @return
     */
    int deleteMovie(Movie movie);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<Movie> listMovie(int page1,int num);

    /**
     *
     * @param movieid
     * @return
     */
    MovieShortInfo getMovieShortInfoById(Long movieid);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<MovieShortInfo> listShortInfo(int page1,int num);
}
