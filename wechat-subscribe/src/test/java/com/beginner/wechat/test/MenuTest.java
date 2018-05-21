package com.beginner.wechat.test;

import com.alibaba.fastjson.JSON;
import com.beginner.wechat.test.BaseTest;
import com.beginner.wechat.constant.ButtonType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.menu.Button;
import com.beginner.wechat.model.menu.Menu;
import com.beginner.wechat.model.menu.SubButton;
import com.beginner.wechat.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2018/5/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTest extends BaseTest {

    @Autowired
    MenuService menuService;

    @Test
    public void testMenuJson() {
        System.out.println("--->"+JSON.toJSONString(getMenu()));
    }

    @Test
    public void testCreateMenu() {
        // 创建自定义菜单
        Result result = menuService.createMenu(getToken(), getMenu());
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMenuInfo() {
        // 获取自定义菜单信息
        Result result = menuService.getMenuInfo(getToken());
        System.out.println("--->"+result.getData());
    }

    public Menu getMenu() {
        // 第一个一级菜单
        SubButton subButton1_1 = new SubButton();
        subButton1_1.setType(ButtonType.VIEW);
        subButton1_1.setName("链接");
        subButton1_1.setUrl("http://www.baidu.com/");

        SubButton subButton1_2 = new SubButton();
        subButton1_2.setType(ButtonType.CLICK);
        subButton1_2.setName("点击");
        subButton1_2.setKey("MENU_1_2");

        SubButton subButton1_3 = new SubButton();
        subButton1_3.setType(ButtonType.LOCATION_SELECT);
        subButton1_3.setName("发送位置");
        subButton1_3.setKey("MENU_1_3");

        List<SubButton> subButtonList1 = new ArrayList<>();
        subButtonList1.add(subButton1_1);
        subButtonList1.add(subButton1_2);
        subButtonList1.add(subButton1_3);
        Button button1 = new Button();
        button1.setName("普通");
        button1.setSubButton(subButtonList1);

        // 第二个一级菜单
        SubButton subButton2_1 = new SubButton();
        subButton2_1.setType(ButtonType.SCANCODE_PUSH);
        subButton2_1.setKey("MENU_2_1");
        subButton2_1.setName("扫码推事件");

        SubButton subButton2_2 = new SubButton();
        subButton2_2.setType(ButtonType.SACBCODE_WAITMSG);
        subButton2_2.setKey("MENU_2_2");
        subButton2_2.setName("扫码带提示");

        SubButton subButton2_3 = new SubButton();
        subButton2_3.setType(ButtonType.PIC_SYSPHOTO);
        subButton2_3.setKey("MENU_2_3");
        subButton2_3.setName("系统拍照发图");

        SubButton subButton2_4 = new SubButton();
        subButton2_4.setType(ButtonType.PIC_PHOTO_OR_ALBUM);
        subButton2_4.setKey("MENU_2_4");
        subButton2_4.setName("拍照或者相册发图");

        SubButton subButton2_5 = new SubButton();
        subButton2_5.setType(ButtonType.PIC_WEIXIN);
        subButton2_5.setKey("MENU_2_5");
        subButton2_5.setName("微信相册发图");

        List<SubButton> subButtonList = new ArrayList<>();
        subButtonList.add(subButton2_1);
        subButtonList.add(subButton2_2);
        subButtonList.add(subButton2_3);
        subButtonList.add(subButton2_4);
        subButtonList.add(subButton2_5);
        Button button2 = new Button();
        button2.setName("系统");
        button2.setSubButton(subButtonList);

        // 第三个一级菜单
        SubButton subButton3_1 = new SubButton();
        subButton3_1.setType(ButtonType.MEDIA_ID);
        subButton3_1.setName("图片");
        subButton3_1.setMediaId("MEDIA_ID1");

        SubButton subButton3_2 = new SubButton();
        subButton3_2.setType(ButtonType.VIEW_LIMITED);
        subButton3_2.setName("图文消息");
        subButton3_2.setMediaId("MEDIA_ID2");

        List<SubButton> subButtonList3 = new ArrayList<>();
        subButtonList3.add(subButton3_1);
        subButtonList3.add(subButton3_2);
        Button button3 = new Button();
        button3.setName("素材");
        button3.setSubButton(subButtonList3);

        // 自定义菜单
        Menu menu = new Menu();
        List<Button> buttonList = new ArrayList<>();
        buttonList.add(button1);
        buttonList.add(button2);
//        buttonList.add(button3);
        menu.setButton(buttonList);

        return menu;
    }
}
