package com.heqing.wechat.model.material;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 素材信息
 * @author heqing
 * @date 2018/5/24
 */
public class Material {

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    private String type;

    /**
     * 媒体文件上传后，获取标识
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * 临时媒体文件上传后，获取标识
     */
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    /**
     * 媒体文件上传时间戳
     */
    @JSONField(name = "created_at")
    private String createdAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
