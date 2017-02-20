package com.toda.broker.util;

/**
 * Created by Zhao Haibin on 2016/2/22.
 */
public class Iconfig {

    //本地环境
    public static final String URL = "http://112.74.215.237:8080/api/";
    //项目存储图片根目录
    public static String WATCH_HOUSE_FILE = "/Broker";
    // 缓存图片
    public static final String IMAGE_CACHE = "/imagecache";

    //登录
    public static final String URL_LOGIN = URL + "operator/login.do";
    //获取用户信息
    public static final String URL_GET_USER_INFO = URL + "operator/queryOperatorInfoByToken.do";
    //二手房源
    public static final String URL_SECOND_HOUSE_LIST = URL + "secondHousePersonal/queryAllSecondHousePersonalPage.do";
    //二手房源初步资料
    public static final String URL_SECOND_HOUSE_PRELIMINARY_INFO = URL + "secondHousePersonal/querySecondHousePersonalInfo.do";
    //获取城市列表
    public static final String URL_GET_CITY_LIST = URL + "area/queryAreaList.do";
    //获取区域列表
    public static final String URL_GET_RETION_BY_CITY = URL + "area/queryAreaListByCityId.do";

}
