package com.beginner.wechat.test;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    private final static String TOKEN = "10__fNw9LwtA3gOaMsLIw-vPVbwOG-njGrVVUVAJEOKPFXlc5Tc3Dr6JBxvAE7a5fl-SgHNi4OqcPZ6n4T8H_-RvPyOFX7hIUqtXk5OLb-RsQrzOYgx0-TRv4tNCGiq5TX26GtXnEx6ZCFHAEFdOFWbAFAKBS";

    @Autowired
    UserService userService;

    @Test
    public void testCreateTag() {
        // 创建标签
        Result result = userService.createTag(TOKEN, "男");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetTag() {
        //  获取公众号已创建的标签
        Result result = userService.getTag(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testUpdateTag() {
        // 编辑标签
        Result result = userService.updateTag(TOKEN, 104, "女性");
        System.out.println("--->"+result);
    }

    @Test
    public void testDeleteTag() {
        // 删除标签
        Result result = userService.deleteTag(TOKEN, 104);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetFans() {
        // 获取标签下粉丝列表
        Result result = userService.getFans(TOKEN, 103, "");
        System.out.println("--->"+result);
    }

    @Test
    public void testBatchTagging() {
        // 批量为用户打标签
        List<String> openidList = new ArrayList<>();
        openidList.add("oa3070VHNTZojJ-zdhZPIe21ETHs");
        Result result = userService.batchTagging(TOKEN, 103, openidList);
        System.out.println("--->"+result);
    }

    @Test
    public void testBatchUnTagging() {
        // 批量为用户取消标签
        List<String> openidList = new ArrayList<>();
        openidList.add("oa3070VHNTZojJ-zdhZPIe21ETHs");
        Result result = userService.batchUnTagging(TOKEN, 103, openidList);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetTagIdByOpenId() {
        // 获取用户身上的标签列表
        Result result = userService.getTagIdByOpenId(TOKEN, "oa3070VHNTZojJ-zdhZPIe21ETHs");
        System.out.println("--->"+result);
    }

}
