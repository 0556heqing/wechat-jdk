package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.model.material.*;
import com.heqing.wechat.service.MaterialService;
import com.heqing.wechat.api.MaterialApi;
import com.heqing.wechat.constant.MediaType;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.util.HttpPostUtil;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.util.WechatFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;

/**
 * 素材管理 实现类
 * @author heqing
 * @date 2018/5/24
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Override
    public Result<Material> addTempMaterial(String accessToken, MediaType mediaType, File file) {
        String url = MaterialApi.MATERIAL_ADD_TEMP.replace("ACCESS_TOKEN", accessToken)
                .replace("TYPE", mediaType.getName());
        JSONObject jsonSendFile = WechatFileUtil.jsonSendFile(url, file, "", "");
        return new Result(jsonSendFile, Material.class);
    }

    @Override
    public Result<String> getTempMaterial(String accessToken, String mediaId, File file) {
        String url = MaterialApi.MATERIAL_GET_TEMP.replace("ACCESS_TOKEN", accessToken)
                .replace("MEDIA_ID", mediaId);
        JSONObject response = WechatFileUtil.getFile(url, file);
        return new Result(response);
    }

    @Override
    public Result getJsJdkVoice(String accessToken, String mediaId, File file) {
        String url = MaterialApi.MATERIAL_GET_JSJDK_VOICE.replace("ACCESS_TOKEN", accessToken)
                .replace("MEDIA_ID", mediaId);
        JSONObject response = WechatFileUtil.getFile(url, file);
        return new Result<String>(response);
    }

    @Override
    public Result<String> uploadImg(String accessToken, File file) {
        String url = MaterialApi.MATERIAL_UPLOAD_IMG.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = WechatFileUtil.jsonSendFile(url, file, "", "");
        String imageUrl = response.getString("url");
        response.put("data", imageUrl == null ? "" : imageUrl);
        response.remove("url");
        return new Result(response);
    }

    @Override
    public Result<Material> uploadNews(String accessToken, List<Article> articles) {
        String url = MaterialApi.MATERIAL_UPLOAD_NEWS.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("articles", articles);
        JSONObject response =  HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<String> addNews(String accessToken, News news) {
        String url = MaterialApi.MATERIAL_ADD_NEWS.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, JSON.toJSONString(news));
        String mediaId = response.getString("media_id");
        response.put("data",mediaId == null ? "" : mediaId);
        response.remove("media_id");
        return new Result(response);
    }

    @Override
    public Result<Material> addMaterial(String accessToken, MediaType mediaType, File file, String titile, String introduction) {
        String url = MaterialApi.MATERIAL_ADD.replace("ACCESS_TOKEN", accessToken)
                .replace("TYPE", mediaType.getName());
        // 文件的标题或描述是否为空
        boolean description = StringUtils.isEmpty(titile) || StringUtils.isEmpty(introduction);
        if(mediaType == MediaType.VIDEO && description) {
            return new Result(41005, "缺少多媒体文件数据");
        }
        JSONObject response =  WechatFileUtil.jsonSendFile(url, file, titile, introduction);
        return new Result(response, Material.class);
    }

    @Override
    public Result getMaterial(String accessToken, String mediaId, File file) {
        Result result ;
        String url = MaterialApi.MATERIAL_GET.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("media_id", mediaId);
        String response = HttpPostUtil.sendJsonRequest(url, params.toJSONString());
        try {
            JSONObject jsonObject = JSONObject.parseObject(response);
            JSONArray newsItemList = jsonObject.getJSONArray("news_item");
            String title = jsonObject.getString("title");
            if(newsItemList != null && newsItemList.size() > 0) {
                jsonObject.put("articles", newsItemList);
                jsonObject.remove("news_item");
                result = new Result(jsonObject, News.class);
            } else if(title != null) {
                String videoUrl = jsonObject.getString("down_url");
                WechatFileUtil.downLoadFromUrl(videoUrl, file);
                jsonObject.put("file_path", file.getAbsoluteFile());
                result = new Result(jsonObject, Video.class);
            } else {
                result = new Result(jsonObject);
            }
        } catch(Exception e) {
            WechatFileUtil.stringToFile(response, file);
            JSONObject resultJson = new JSONObject();
            resultJson.put("errcode", 0);
            resultJson.put("data", file.getAbsolutePath());
            result = new Result(resultJson);
        }
        return result;
    }

    @Override
    public Result delMaterial(String accessToken, String mediaId) {
        String url = MaterialApi.MATERIAL_DEL.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("media_id", mediaId);
        JSONObject response =  HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result updateNews(String accessToken, String mediaId, Integer index, Article articles) {
        String url = MaterialApi.MATERIAL_UPDATE_NEWS.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("media_id", mediaId);
        params.put("index", index);
        params.put("articles",  articles);
        JSONObject response =  HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<MaterialCount> getMaterialCount(String accessToken) {
        String url = MaterialApi.MATERIAL_GET_COUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject response =  HttpGetUtil.getResponse(url);
        return new Result(response, MaterialCount.class);
    }

    @Override
    public Result<ItemList> getMaterialList(String accessToken, MediaType mediaType, Integer offset, Integer count) {
        String url = MaterialApi.MATERIAL_GET_LIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = new JSONObject();
        if(mediaType != MediaType.IMAGE && mediaType != MediaType.VIDEO && mediaType != MediaType.VOICE && mediaType != MediaType.NEWS) {
            response.put("errcode", 10001);
            response.put("errmsg", "多媒体文件参数不正确");
            return new Result(response);
        }
        JSONObject json = new JSONObject();
        json.put("type", mediaType.getName());
        json.put("offset", offset);
        json.put("count", count);
        response = HttpPostUtil.getResponse(url, json.toJSONString());
        if(mediaType == MediaType.NEWS) {
            JSONArray itemlist = response.getJSONArray("item");
            for(int i=0; i<itemlist.size(); i++) {
                JSONObject item = itemlist.getJSONObject(i);
                JSONObject content = item.getJSONObject("content");
                JSONArray newslist = content.getJSONArray("news_item");
                item.put("content", newslist);
            }
        }
        return new Result(response, ItemList.class);
    }

    @Override
    public Result<Material> uploadVideo(String accessToken, String mediaId, String title, String description) {
        String url = MaterialApi.MATERIAL_UPLOAD_VIDEO.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("media_id", mediaId);
        params.put("title", title);
        params.put("description", description);
        JSONObject response =  HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }
}
