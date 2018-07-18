package com.heqing.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 模板推送后的事件
 * @author heqing
 * @date 2018/6/4
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class TemplateEvent extends BaseMsg {

    /**
     * 事件，事件类型，参见 com.heqing.wechat.constant.EventType
     */
    @XmlElement(name = "Status")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
