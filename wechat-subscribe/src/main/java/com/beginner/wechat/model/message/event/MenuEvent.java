package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 自定义菜单事件
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class MenuEvent extends BaseMsg {

    /**
     * eventKey
     * CLICK : 事件KEY值，与自定义菜单接口中KEY值对应
     * VIEW : 事件KEY值，设置的跳转URL
     */
    @XmlElement(name = "EventKey")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
