package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.util.HttpGetUtil;
import com.beginner.wechat.util.HttpPostUtil;
import com.beginner.wechat.api.MenuApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.menu.AllMenu;
import com.beginner.wechat.model.menu.ConditionalMenu;
import com.beginner.wechat.model.menu.Menu;
import com.beginner.wechat.model.menu.MenuConfig;
import com.beginner.wechat.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * 自定义菜单实现类
 * @author heqing
 * @date 2018/5/21
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public Result createMenu(String accessToken, Menu menu) {
        String url = MenuApi.CREATE_MENU.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, menu);
        return new Result(response);
    }

    @Override
    public Result<AllMenu> getMenuInfo(String accessToken) {
        String url = MenuApi.GET_MENU.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response, AllMenu.class);
    }

    @Override
    public Result delMenu(String accessToken) {
        String url = MenuApi.DEL_MENU.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response);
    }

    @Override
    public Result<String> addConditional(String accessToken, ConditionalMenu conditionalMenu) {
        String url = MenuApi.ADD_CONDITIONAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, conditionalMenu);
        String menuId = response.getString("menuid");
        response.put("data", menuId == null ? "" : menuId);
        return new Result(response);
    }

    @Override
    public Result delConditional(String accessToken, String menuId) {
        String url = MenuApi.DEL_CONDITIONAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("menuid", menuId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<ConditionalMenu> tryMatch(String accessToken, String userId) {
        String url = MenuApi.TRY_MATCH.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("user_id", userId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response, "menu", ConditionalMenu.class);
    }

    @Override
    public Result<MenuConfig> getMenuConfigInfo(String accessToken) {
        String url = MenuApi.GET_MENU_CONFIG.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        Result result = new Result();
        result.setErrcode(response.getInteger("errcode"));
        if(result.getErrcode() == null || result.getErrcode()== 0){
            JSONObject selfmenuInfo = response.getJSONObject("selfmenu_info");
            JSONArray buttonList = selfmenuInfo.getJSONArray("button");
            for(int i=0; i<buttonList.size(); i++) {
                JSONObject button = buttonList.getJSONObject(i);
                JSONObject subButton = button.getJSONObject("sub_button");
                JSONArray subButtonList = subButton.getJSONArray("list");
                for(int j=0; j<subButtonList.size(); j++) {
                    JSONObject news = subButtonList.getJSONObject(j);
                    JSONObject newsInfo = news.getJSONObject("news_info");
                    if(newsInfo != null) {
                        JSONArray newsList = newsInfo.getJSONArray("list");
                        news.put("news_info", newsList);
                    }
                }
                button.put("sub_button", subButtonList);
            }
            result.setData(JSON.parseObject(response.toJSONString(), MenuConfig.class));
        } else {
            result.setErrmsg(response.getString("errmsg"));
        }
        return result;
    }
}
