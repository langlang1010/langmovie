package cn.langlang.langmovie.service;

import cn.langlang.langmovie.bean.RoomSeat;
import cn.langlang.langmovie.entity.Form;

import java.util.List;

public interface FormService {
    short NOT_ENOUGH_MONEY = -1;
    short SEAT_ORDERED = -2;
    /**
     *
     * @param form
     * @return
     */
    Long insertForm(Form form);

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
    List<Form> listForm(int page1,int num);

    /**
     * @param screenid
     * @return
     */
    List<RoomSeat> listRoomSeatsOrdered(long screenid);

    /**
     *
     * @param userid
     * @param screenid
     * @param seats
     * @return
     */
    int insertForms(long userid,long screenid,List<RoomSeat> seats);

    /**
     *
     * @param x
     * @param y
     * @return
     */
    boolean existFormidBySeat(long screenid,short x,short y);

    /**
     *
     * @param userid
     * @return
     */
    List<Form> listFormByUserid(Long userid,int page1,int num);

    /**
     *
     * @param userid
     * @return
     */
    List<String> listCodesByUserid(Long userid);

    /**
     *
     * @param code
     * @return
     */
    List<Form> listFormByCode(String code);

}
