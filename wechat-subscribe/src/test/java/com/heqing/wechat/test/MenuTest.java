package com.heqing.wechat.test;

import com.heqing.wechat.model.TestMenu;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author heqing
 * @date 2018/5/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTest {

    private final static String TOKEN = "10_0-LI0h0CUYipW_CGd-v3hVF6qkKPcrQ-qGk4KSoF2levCC6p9tdLwi3ohFgoUqf0F6IRuw09Vs1icUZ7bZvS8idEJu2utcRLxPeRSnp0UEO9Yk2pqI1UqeaDxThK2TNVKbIr-dUP4AAkM0UsUFJjAAAQBF";

    @Autowired
    MenuService menuService;

    @Test
    public void testCreateMenu() {
        // 创建自定义菜单
        Result result = menuService.createMenu(TOKEN, TestMenu.getMenu());
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMenuInfo() {
        // 获取菜单信息
        Result result = menuService.getMenuInfo(TOKEN);
        System.out.println("--->"+result.getData());
    }

    @Test
    public void testDelMenu() {
        // 删除自定义菜单
        Result result = menuService.delMenu(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testAddConditional() {
        // 创建个性化菜单
        Result result = menuService.addConditional(TOKEN, TestMenu.getConditionalMenu());
        System.out.println("--->"+result);
    }

    @Test
    public void testDelConditional() {
        // 删除个性化菜单
        Result result = menuService.delConditional(TOKEN, "449945323");
        System.out.println("--->"+result);
    }

    @Test
    public void testTryMatch() {
        // 测试个性化菜单匹配结果
        Result result = menuService.tryMatch(TOKEN, "o0xVxt1HBqcN1zsXswCXFrpVfiWA");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMenuConfig() {
        // 获取自定义菜单配置信息
        Result result = menuService.getMenuConfigInfo(TOKEN);
        System.out.println("--->"+result.getData());
    }
}
