package com.yhnet.crm.facebook.admin.common.util;

public class Constant {

    //oss二维码路径
    public static final String OSS_QR_PATH = "/qrcode/%s/%s/";

    //二维码logo路径
    public static final String QR_LOGO_IMG_PATH = "qr_logo.png";

    public static final String QR_PARSE_URL = "/qrcode/";

    //已开通省份key
    public static final String CONFIG_OPENED_PROVINCE = "opened_province";

    public static final String QR_ENCORD_KEY = "TVWLjQQkAUyvJ+ykOrlVdQ==";

    //本地文件夹
    public static final String LOCAL_STORAGE = "storage/";

    public static final String WX_PAY_QR_PATH = "storage/wxpay/";

    public static final String BANNER_PATH = "storage/banner/";

    public static final String WX_QR_PATH = "storage/wxqr/";
    //微信支付查询时间间隔
    public static final Integer[] ORDER_QUERY_TIMES = new Integer[]{5,30,60,180,300,600,1800};
}
