package com.beginner.wechat.model.template;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 模板
 * @author heqing
 * @date 2018/6/4.
 */
public class Template {

    /*
     * templateId 模板ID(必传)
     */
    @JSONField(name = "template_id")
    private String templateId;

    /*
    * title 模板标题(必传)
    */
    private String title;

    /*
     * primaryIndustry 模板所属行业的一级行业(必传)
    */
    @JSONField(name = "primary_industry")
    private String primaryIndustry;

    /*
     * deputyIndustry 模板所属行业的二级行业(必传)
    */
    @JSONField(name = "deputy_industry")
    private String deputyIndustry;

    /*
     * content 模板内容
    */
    private String content;

    /*
     * example 模板示例
    */
    private String example;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public String getDeputyIndustry() {
        return deputyIndustry;
    }

    public void setDeputyIndustry(String deputyIndustry) {
        this.deputyIndustry = deputyIndustry;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
