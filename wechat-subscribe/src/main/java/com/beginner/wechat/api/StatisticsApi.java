package com.beginner.wechat.api;

/**
 * 分析统计
 * @author heqing
 * @date 2018/6/5.
 */
public class StatisticsApi extends BaseApi {

    protected final static String  WEIXIN = "https://api.weixin.qq.com/datacube";

    /**
     * GET_USER_SUMMARY 获取用户增减数据
     */
    public final static String GET_USER_SUMMARY = WEIXIN + "/getusersummary?access_token=ACCESS_TOKEN";

    /**
     * GET_USER_CUMULATE 获取累计用户数据
     */
    public final static String GET_USER_CUMULATE = WEIXIN + "/getusercumulate?access_token=ACCESS_TOKEN";

    /**
     * GET_ARTICLE_SUMMARY 获取图文群发每日数据
     */
    public final static String GET_ARTICLE_SUMMARY = WEIXIN + "/getarticlesummary?access_token=ACCESS_TOKEN";

    /**
     * GET_ARTICLE_TOTAL 获取图文群发总数据
     */
    public final static String GET_ARTICLE_TOTAL = WEIXIN + "/getarticletotal?access_token=ACCESS_TOKEN";

    /**
     * GET_USER_READ 获取图文统计数据
     */
    public final static String GET_USER_READ = WEIXIN + "/getuserread?access_token=ACCESS_TOKEN";

    /**
     * GET_USER_READ_HOUR 获取图文统计分时数据
     */
    public final static String GET_USER_READ_HOUR = WEIXIN + "/getuserreadhour?access_token=ACCESS_TOKEN";

    /**
     * GET_USER_SHARE 获取图文分享转发数据
     */
    public final static String GET_USER_SHARE = WEIXIN + "/getusershare?access_token=ACCESS_TOKEN";

    /**
     * GET_USER_SHARE_HOUR 获取图文分享转发分时数据
     */
    public final static String GET_USER_SHARE_HOUR = WEIXIN + "/getusersharehour?access_token=ACCESS_TOKEN";

    /**
     * GET_UPSTREAM_MSG 获取消息发送概况数据
     */
    public final static String GET_UPSTREAM_MSG = WEIXIN + "/getupstreammsg?access_token=ACCESS_TOKEN";

    /**
     * GET_UPSTREAM_MSG_HOUR 获取消息分送分时数据
     */
    public final static String GET_UPSTREAM_MSG_HOUR = WEIXIN + "/getupstreammsghour?access_token=ACCESS_TOKEN";

    /**
     * GET_UPSTREAM_MSG_WEEK 获取消息发送周数据
     */
    public final static String GET_UPSTREAM_MSG_WEEK = WEIXIN + "/getupstreammsgweek?access_token=ACCESS_TOKEN";

    /**
     * GET_UPSTREAM_MSG_MONTH 获取消息发送月数据
     */
    public final static String GET_UPSTREAM_MSG_MONTH = WEIXIN + "/getupstreammsgmonth?access_token=ACCESS_TOKEN";

    /**
     * GET_UPSTREAM_MSG_DIST 获取消息发送分布数据
     */
    public final static String GET_UPSTREAM_MSG_DIST = WEIXIN + "/getupstreammsgdist?access_token=ACCESS_TOKEN";

    /**
     * GET_UPSTREAM_MSG_DIST_WEEK 获取消息发送分布周数据
     */
    public final static String GET_UPSTREAM_MSG_DIST_WEEK = WEIXIN + "/getupstreammsgdistweek?access_token=ACCESS_TOKEN";

    /**
     * GET_UPSTREAM_MSG_DIST_MONTH 获取消息发送分布月数据
     */
    public final static String GET_UPSTREAM_MSG_DIST_MONTH = WEIXIN + "/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";

    /**
     * GET_INTERFACES_SUMMARY 获取接口分析数据
     */
    public final static String GET_INTERFACES_SUMMARY = WEIXIN + "/getinterfacesummary?access_token=ACCESS_TOKEN";

    /**
     * GET_INTERFACES_SUMMARY_HOUR 获取接口分析分时数据
     */
    public final static String GET_INTERFACES_SUMMARY_HOUR = WEIXIN + "/getinterfacesummaryhour?access_token=ACCESS_TOKEN";
}
