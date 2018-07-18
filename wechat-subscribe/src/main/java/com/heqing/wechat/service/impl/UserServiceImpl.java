package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.api.UserApi;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.user.Fans;
import com.heqing.wechat.model.user.Tag;
import com.heqing.wechat.service.UserService;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户标签 实现类
 * @author heqing
 * @date 2018/5/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Result<Tag> createTag(String accessToken, String name) {
        String url = UserApi.USER_CREATE_TAG.replace("ACCESS_TOKEN", accessToken);
        Tag tag = new Tag();
        tag.setName(name);
        JSONObject params = new JSONObject();
        params.put("tag", tag);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response, "tag", Tag.class);
    }

    @Override
    public Result<List<Tag>> getTag(String accessToken) {
        String url = UserApi.USER_GET_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        JSONArray tags = response.getJSONArray("tags");
        if(tags != null) {
            List<Tag> tagList = new ArrayList<>();
            for (int i = 0; i < tags.size(); i++) {
                Tag tag = tags.getObject(i, Tag.class);
                tagList.add(tag);
            }
            response.put("data", tagList);
        }
        return new Result(response);
    }

    @Override
    public Result updateTag(String accessToken, Integer tagId, String name) {
        String url = UserApi.USER_UPDATE_TAG.replace("ACCESS_TOKEN", accessToken);
        Tag tag = new Tag();
        tag.setId(tagId);
        tag.setName(name);
        JSONObject params = new JSONObject();
        params.put("tag", tag);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result deleteTag(String accessToken, Integer tagId) {
        String url = UserApi.USER_DELETE_TAG.replace("ACCESS_TOKEN", accessToken);
        Tag tag = new Tag();
        tag.setId(tagId);
        JSONObject params = new JSONObject();
        params.put("tag", tag);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<Fans> getFansListByTag(String accessToken, Integer tagId, String nextOpenid) {
        String url = UserApi.USER_GET_FANS_BY_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("tagid", tagId);
        params.put("next_openid", nextOpenid);
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
    public Result batchTagging(String accessToken, Integer tagId, List<String> openidList) {
        String url = UserApi.USER_BATCH_TAGGING.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("tagid", tagId);
        params.put("openid_list", openidList.toString());
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        System.out.println("--->"+response.toJSONString());
        return new Result(response);
    }

    @Override
    public Result batchUnTagging(String accessToken, Integer tagId, List<String> openidList) {
        String url = UserApi.USER_BATCH_UN_TAGGING.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("tagid", tagId);
        params.put("openid_list", openidList.toString());
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        System.out.println("--->"+response.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<List<Tag>> getTagIdByOpenId(String accessToken, String openId) {
        String url = UserApi.USER_GET_ID_LIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("openid", openId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        JSONArray tagList = response.getJSONArray("tagid_list");
        if(tagList != null) {
            response.put("data", tagList);
        }
        return new Result(response);
    }

    @Override
    public Result updateRemark(String accessToken, String openId, String remark) {
        String url = UserApi.USER_UPDATE_REMARK.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("openid", openId);
        params.put("remark", remark);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<Fans> getFansList(String accessToken, String nextOpenid) {
        String url = UserApi.USER_GET_FANS.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", nextOpenid);
        JSONObject response = HttpGetUtil.getResponse(url);
        Integer count = response.getInteger("count");
        if(count != null) {
            JSONObject data = response.getJSONObject("data");
            JSONArray openid = data.getJSONArray("openid");
            response.put("openid", openid);
            response.remove("data");
        }
        return new Result(response, Fans.class);
    }

}
