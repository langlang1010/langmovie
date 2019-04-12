package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.MovieActor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieActorDao {
    /**
     *
     * @param movieActor
     * @return
     */
    int insertActor(MovieActor movieActor);

    /**
     *
     * @param movieActor
     * @return
     */
    MovieActor getMovieActorById(MovieActor movieActor);

    /**
     *
     * @param movieActor
     * @return
     */
    List<MovieActor> listMovieActorByMovie(MovieActor movieActor);

    /**
     * 根据电影id查询主要演员姓名
     * @return
     */
    List<String> listActorNameByMovie(@Param("movieid")Long movieid);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<MovieActor> listMovieAction(@Param("page1") int page1,
                                     @Param("num") int num);

    /**
     *
     * @param movieActor
     * @return
     */
    int updateMovieActor(MovieActor movieActor);

    /**
     *
     * @param movieActor
     * @return
     */
    int deleteActorById(MovieActor movieActor);

    /**
     *
     * @param movieActor
     * @return
     */
    int deleteActorByMovie(MovieActor movieActor);
}
