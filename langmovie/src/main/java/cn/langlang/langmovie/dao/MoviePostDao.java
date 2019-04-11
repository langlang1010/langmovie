package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.MoviePost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoviePostDao {
    /**
     *
     * @param moviePost
     * @return
     */
    int insertPost(MoviePost moviePost);

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
    int deletePostById(MoviePost moviePost);

    /**
     *
     * @param moviePost
     * @return
     */
    int deletePostByMovie(MoviePost moviePost);

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
    List<MoviePost> listMoviePost(@Param("page1") int page1,
                                  @Param("num") int num);
}
