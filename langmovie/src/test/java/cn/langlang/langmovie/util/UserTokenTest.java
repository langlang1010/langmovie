package cn.langlang.langmovie.util;

import java.util.UUID;

public class UserTokenTest {
    public static void main(String[] args) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace.length());
    }
}
