package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.api.UserExtApi;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.user.Fans;
import com.heqing.wechat.model.user.User;
import com.heqing.wechat.service.UserExtService;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基本信息/黑名单 实现类
 * @author heqing
 * @date 2018/5/29
 */
@Service
public class UserExtServiceImpl extends UserServiceImpl implements UserExtService {

    @Override
    public Result<List<User>> listUserInfo(String accessToken, List<String> openidList, String lang) {
        String url = UserExtApi.USER_LIST_INFO.replace("ACCESS_TOKEN", accessToken);
        if(StringUtils.isEmpty(lang)) {
            lang = "zh_CN";
        }
        List<Map<String, String>> userList = new ArrayList<>();
        for(String openid : openidList) {
            Map<String, String> user = new HashMap<>(16);
            user.put("openid", openid);
            user.put("lang", lang);
            userList.add(user);
        }
        JSONObject params = new JSONObject();
        params.put("user_list", userList);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        JSONArray userInfoListJson = response.getJSONArray("user_info_list");
        if(userInfoListJson != null) {
            List<User> userInfoList = new ArrayList<>();
            for (int i = 0; i < userInfoListJson.size(); i++) {
                User user = (User) userInfoListJson.get(i);
                userInfoList.add(user);
            }
            response.put("data", userInfoList);
        }
        return new Result(response);
    }

    @Override
    public Result<User> getUserInfo(String accessToken, String openid, String lang) {
        if(StringUtils.isEmpty(lang)) {
            lang = "zh_CN";
        }
        String url = UserExtApi.USER_GET_INFO.replace("ACCESS_TOKEN", accessToken)
                .replace("OPENID", openid).replace("zh_CN", lang);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response, User.class);
    }

    @Override
    public Result<Fans> getBlackFansList(String accessToken, String beginOpenid) {
        String url = UserExtApi.USER_GET_BLACK_FANS.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_openid", beginOpenid);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        Integer count = response.getInteger("count");
        if(count != null) {
            JSONObject data = response.getJSONObject("data");
            JSONArray openid = data.getJSONArray("openid");
            response.put("openid", openid);
            response.remove("data");
        }
        return new Result(response, Fans.class);
    }

    @Override
    public Result setBlackFansList(String accessToken, List<String> openidList) {
        String url = UserExtApi.USER_SET_BLACK_FANS.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("openid_list", openidList);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return  new Result(response);
    }

    @Override
    public Result setUnBlackFansList(String accessToken, List<String> openidList) {
        String url = UserExtApi.USER_SET_UN_BLACK_FANS.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("openid_list", openidList);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return  new Result(response);
    }
}
