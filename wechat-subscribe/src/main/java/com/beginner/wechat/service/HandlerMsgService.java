package com.beginner.wechat.service;

import com.beginner.wechat.model.message.event.*;
import com.beginner.wechat.model.message.msg.*;

/**
 * 处理接收到的消息
 * @author heqing
 * @date 2018/5/31.
 */
public interface HandlerMsgService {

    /**
     * 处理文本消息
     *
     * @param textMsg 文本消息
     * @return 返回消息
     */
    String handlerTextMsg(TextMsg textMsg);

    /**
     * 处理图片消息
     *
     * @param imageMsg 图片消息
     * @return
     */
    String handlerImageMsg(ImageMsg imageMsg);

    /**
     * 处理语音消息
     *
     * @param voiceMsg 语音消息
     * @return
     */
    String handlerVoiceMsg(VoiceMsg voiceMsg);

    /**
     * 处理视频消息
     *
     * @param videoMsg 视频消息
     * @return
     */
    String handlerVideoMsg(VideoMsg videoMsg);

    /**
     * 处理小视频消息
     *
     * @param videoMsg 视频消息
     * @return
     */
    String handlerShortVideoMsg(VideoMsg videoMsg);

    /**
     * 处理地理位置消息
     *
     * @param locationMsg 地理位置消息
     * @return
     */
    String handlerLocationMsg(LocationMsg locationMsg);

    /**
     * 处理链接消息
     *
     * @param linkMsg 链接消息
     * @return
     */
    String handlerLinkMsg(LinkMsg linkMsg);

    /**
     * 处理关注事件
     *
     * @param subscribeEvent 关注事件
     * @return
     */
    String handlerSubscribeEvent(SubscribeEvent subscribeEvent);

    /**
     * 处理取消关注事件
     *
     * @param unsubscribeEvent 取消关注事件
     * @return
     */
    String handlerUnSubscribeEvent(SubscribeEvent unsubscribeEvent);

    /**
     * 处理扫描带参数二维码事件
     *
     * @param scanEvent 扫描带参数二维码事件
     * @return
     */
    String handlerScanEvent(ScanEvent scanEvent);

    /**
     * 处理上报地理位置事件
     *
     * @param locationEvent 上报地理位置事件
     * @return
     */
    String handlerLocationEvent(LocationEvent locationEvent);

    /**
     * 处理点击菜单拉取消息时的事件
     *
     * @param clickEvent 点击菜单拉取消息时的事件
     * @return
     */
    String handlerClickEvent(MenuEvent clickEvent);

    /**
     * 处理点击菜单跳转链接时的事件
     *
     * @param viewEvent 点击菜单跳转链接时的事件
     * @return
     */
    String handlerViewEvent(MenuEvent viewEvent);

    /**
     * 处理扫码推事件的事件
     *
     * @param scanEvent 扫码推事件的事件
     * @return
     */
    String handlerScancodePushEvent(ScanEvent scanEvent);

    /**
     * 处理扫码推事件且弹出“消息接收中”提示框的事件
     *
     * @param scanEvent 扫码推事件且弹出“消息接收中”提示框的事件
     * @return
     */
    String handlerScancodeWaitmsgEvent(ScanEvent scanEvent);

    /**
     * 处理弹出系统拍照发图的事件
     *
     * @param picPhotoEvent 弹出系统拍照发图的事件
     * @return
     */
    String handlerPicSysphotoEvent(PicPhotoEvent picPhotoEvent);

    /**
     * 处理弹出拍照或者相册发图的事件
     *
     * @param picPhotoEvent 弹出拍照或者相册发图的事件
     * @return
     */
    String handlerPicPhotoOrAlbumEvent(PicPhotoEvent picPhotoEvent);

    /**
     * 处理弹出微信相册发图器的事件
     *
     * @param picPhotoEvent 弹出微信相册发图器的事件
     * @return
     */
    String handlerPicWeixinEvent(PicPhotoEvent picPhotoEvent);

    /**
     * 处理弹出地理位置选择器的事件
     *
     * @param locationEvent 弹出地理位置选择器的事件
     * @return
     */
    String handlerLocationSelectEvent(LocationEvent locationEvent);

    /**
     * 在模版消息发送任务完成后，成功通知
     *
     * @param templateEvent 模板事件
     * @return
     */
    String handlerSendTemplateSuccessEvent(TemplateEvent templateEvent);

    /**
     * 在模版消息发送任务完成后，用户拒绝通知
     *
     * @param templateEvent 模板事件
     * @return
     */
    String handlerSendTemplateRefuseEvent(TemplateEvent templateEvent);

    /**
     * 在模版消息发送任务完成后，未知原因失败通知
     *
     * @param templateEvent 模板事件
     * @return
     */
    String handlerSendTemplateFailedEvent(TemplateEvent templateEvent);

    /**
     * 资质认证成功通知
     *
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerQualificationSuccessEvent(AuthenticationEvent authenticationEvent);

    /**
     * 资质认证失败通知
     *
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerQualificationFailedEvent(AuthenticationEvent authenticationEvent);

    /**
     * 名称认证成功通知
     *
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerNamingSuccessEvent(AuthenticationEvent authenticationEvent);

    /**
     * 名称认证失败通知
     *
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerNamingFailedEvent(AuthenticationEvent authenticationEvent);

    /**
     * 年审通知
     *
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerAnnualRenewEvent(AuthenticationEvent authenticationEvent);
}
