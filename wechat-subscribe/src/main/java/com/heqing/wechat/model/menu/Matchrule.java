package com.heqing.wechat.model.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.heqing.wechat.constant.SexType;
import com.heqing.wechat.constant.SystemType;

/**
 * 匹配规则(可以通过以下条件来设置用户看到的菜单)
 * 1、用户标签（开发者的业务需求可以借助用户标签来完成）
 * 2、性别
 * 3、手机操作系统
 * 4、地区（用户在微信客户端设置的地区）
 * 5、语言（用户在微信客户端设置的语言）
 * @author heqing
 * @date 2018/5/22
 */
public class Matchrule {

    /**
     * 非必传
     * 用户标签的id，可通过用户标签管理接口获取
     */
    @JSONField(name = "tag_id")
    private String tagId;

    /**
     * 非必传
     * 性别：男（1）女（2），不填则不做匹配
     */
    private SexType sex;

    /**
     * 非必传
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     */
    @JSONField(name = "client_platform_type")
    private SystemType clientPlatformType;

    /**
     * 非必传
     * 国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String country;

    /**
     * 非必传
     * 省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String province;

    /**
     * 非必传
     * 城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String city;

    /**
     * 非必传
     * 语言信息，是用户在微信中设置的语言
     */
    private String language;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getSex() {
        if(sex == null) {
            return "";
        } else {
            return sex.getCode();
        }
    }

    public void setSex(SexType sexType) {
        this.sex = sexType;
    }

    public String getClientPlatformType() {
        if(clientPlatformType == null) {
            return "";
        } else {
            return clientPlatformType.getCode();
        }
    }

    public void setClientPlatformType(SystemType clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
