package cn.langlang.langmovie.service;

import cn.langlang.langmovie.entity.MoviePost;

import java.util.List;

public interface MoviePostService {
    /**
     *
     * @param moviePost
     * @return
     */
    Long insertPost(MoviePost moviePost);

    /**
     *
     * @param moviePost
     * @return
     */
    MoviePost getPostById(MoviePost moviePost);

    /**
     *
     * @param moviePost
     * @return
     */
    List<MoviePost> getPostByMovie(MoviePost moviePost);

    /**
     *
     * @param moviePost
     * @return
     */
    int deleteById(MoviePost moviePost);

    /**
     *
     * @param moviePost
     * @return
     */
    int deleteByMovie(MoviePost moviePost);

    /**
     *
     * @param moviePost
     * @return
     */
    int updatePost(MoviePost moviePost);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<MoviePost> listMoviePost(int page1,int num);
}
