package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.entity.Form;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormDao {
    /**
     * @param form
     * @return
     */
    int insertForm(Form form);

    /**
     *
     * @param form
     * @return
     */
    Form getFormById(Form form);

    /**
     *
     * @param form
     * @return
     */
    int updateForm(Form form);

    /**
     *
     * @param form
     * @return
     */
    int deleteForm(Form form);

    /**
     *
     * @param page1
     * @param num
     * @return
     */
    List<Form> listForm(@Param("page1") int page1, @Param("num") int num);
}
