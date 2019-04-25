package cn.langlang.langmovie.dao;

import cn.langlang.langmovie.bean.FormVO;
import cn.langlang.langmovie.bean.RoomSeat;
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

    /**
     * 根据场次号查询已经占用的座位
     * @param screenid
     * @return
     */
    List<RoomSeat> listSeatOrdered(@Param("screenid") long screenid);

    /**
     *
     * @param x
     * @param y
     * @return
     */
    Form getFormidBySeat(@Param("screenid") long screenid,
                         @Param("x") short x,
                         @Param("y") short y);

    /**
     * 根据 userid 查询订单
     * @param userid
     * @return
     */
    List<Form> listFormByUserid(@Param("userid") Long userid,
                                @Param("page1") int page1,
                                @Param("num")int num);

    /**
     * 根据用户id返回code
     * @param userid
     * @return
     */
    List<String> listCodeByUserid(@Param("userid") Long userid);

    /**
     * 根据code查询订单
     * @param code
     * @return
     */
    FormVO getFormVOByCode(@Param("code") String code);

    /**
     *
     * @param code
     * @return
     */
    List<RoomSeat> listRoomSeatByCode(@Param("code") String code);
}
