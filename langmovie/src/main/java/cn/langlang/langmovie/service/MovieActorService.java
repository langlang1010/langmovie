package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.MovieActor;

import java.util.List;

public interface MovieActorService {
    /**
     *
     * @param movieActor
     * @return
     */
    Long insertActor(MovieActor movieActor);

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
     *
     * @param page1
     * @param num
     * @return
     */
    List<MovieActor> listMovieAction(int page1,int num);

    /**
     *
     * @param movieActor
     * @return
     */
    int updateMovieAction(MovieActor movieActor);

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

    /**
     *
     * @param movieid
     * @return
     */
    List<String> listActorNameByMovie(Long movieid);
}
