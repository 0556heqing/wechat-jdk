package com.heqing.wechat.test;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 微信公共方法测试类
 *
 * @author heqing
 * @date 2018/5/14
 * @version 0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Autowired
    BaseService baseService;

    private final static String appid = "wx2081831e3e9f99fb";
    private final static String secret = "400977b6a6a1a79d74098ed36c0fad31";

    private final static String TOKEN = "10_HrMuD_zcqe34PhZ1VSgw4xlFm0JOOBYmcip9I4aOYG7NChWYW3nA7YYaTufAfX58IZbut2eWRrvixJbcYllzyXrSq-qR3YiPAkzJXQ0Fql_EMrcwtxlvsPNvB9E6Jy1YwV_ThV9P-abc4xTPPLGeAJAJFA";

    @Test
    public void testToken() {
        // 获取微信access_token
        Result result = baseService.getAccessToken(appid, secret);
        System.out.println("---->"+result);
    }
}
