package cn.langlang.langmovie.util;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

public class WechatMenuUtil {
    public static final String appid = "wx46570aa2ed292f5d";
    public static final String appsecret = "4b5919c480cd22b1e78bff70ebd1df73";
    public static void test() {
        // 1.根据appid和appsecret和回调地址配置微信授权
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(appid);
        wxMpConfigStorage.setSecret(appsecret);
        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

        /**
         *  2. 设置按钮
         *  menu对象是总的按钮,button是具体的按钮
         */
        WxMenu menu = new WxMenu();
        WxMenuButton button1 = new WxMenuButton();
        button1.setType(WxConsts.MenuButtonType.VIEW);
        button1.setName("浪浪影院");
        button1.setUrl("https://withyan.cn/langmovie/wechat/welcome");


        // 3. 添加到menu
        menu.getButtons().add(button1);
        String result = menu.toJson().toString();
        System.out.println(result);

        // 根据运行结果返回相应的字符串
        try {
            wxMpService.getMenuService().menuCreate(result);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
