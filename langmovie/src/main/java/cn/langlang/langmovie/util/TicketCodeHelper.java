package cn.langlang.langmovie.util;

import java.util.UUID;

public class TicketCodeHelper {
    public static String getTicketCode() {
        String s = UUID.randomUUID().toString();
        String s2 = UUID.randomUUID().toString();
        return s.replace("-","")+s2.replace("-","");
    }
}
