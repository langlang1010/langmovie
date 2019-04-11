package cn.langlang.langmovie.util;

import org.junit.Test;

import java.util.Date;

public class RestControllerTest {
    @Test
    public void test() {
        RestControllerHelper helper = new RestControllerHelper(RestControllerHelper.SUCCESS,new Date());
    }
}
