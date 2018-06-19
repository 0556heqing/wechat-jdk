package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.util.HttpGetUtil;
import com.beginner.wechat.api.BaseApi;
import com.beginner.wechat.model.AccessToken;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公共方法实现类
 *
 * @author heqing
 * @date 2018/5/14
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public Result<AccessToken> getAccessToken(String appid, String secret) {
        String url = BaseApi.GET_TOKEN.replace("APPID", appid).replace("APPSECRET", secret);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response, AccessToken.class);
    }

    @Override
    public Result<List<String>> listCallBackIP(String accessToken) {
        String url = BaseApi.GET_CALLBACK_IP.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        JSONArray ipList = response.getJSONArray("ip_list");
        if(ipList != null) {
            response.put("data", ipList);
        }
        return new Result(response);
    }
}
