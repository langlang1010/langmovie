package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.bean.MovieShortInfo;
import cn.langlang.langmovie.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieDao {
    /**
     *
     * @param movie
     * @return
     */
    int insertMovie(Movie movie);

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
    List<Movie> listMovie(@Param("page1")int page1, @Param("num") int num);

    /**
     *
     * @param movieid
     * @return
     */
    MovieShortInfo getMovieShortInfoById(@Param("movieid")Long movieid);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<MovieShortInfo> listShortInfo(@Param("page1")int page1,@Param("num") int num);

    /**
     * 根据电影名查找电影
     * @param name
     * @return
     */
    List<MovieShortInfo> listMovieByName(@Param("name") String name);
}
