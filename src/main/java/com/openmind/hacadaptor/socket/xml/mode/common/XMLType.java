package com.openmind.hacadaptor.socket.xml.mode.common;

/**
 * XML_WN_GET_RESOURCE  0x01 获取设备资源
 * <p>
 * XML_WN_CHANGE_DATA  0x02 提交变更工单
 * <p>
 * XML_WN_SET_END 0x03 设置工单状态
 * <p>
 * XML_WN_GET_SESSION 0x04 获取工单会话信息
 * <p>
 * XML_QX_GET_SESSION 0x05
 * <p>
 * XML_WN_GET_LOGIN 0x06 获取操作人员信息
 * <p>
 * XML_WN_GET_TOKEN 0x07 页面访问登录Token
 * <p>
 * XML_WN_REQUEST_OK  0x0a
 * <p>
 * XML_WN_REQUEST_ERROR 0x0b
 */
public class XMLType {
    public static final int XML_WN_GET_RESOURCE = 0x01;
    public static final int XML_WN_CHANGE_DATA = 0x02;
    public static final int XML_WN_SET_END = 0x03;
    public static final int XML_WN_GET_SESSION = 0x04;
    public static final int XML_QX_GET_SESSION = 0x05;
    public static final int XML_WN_GET_LOGIN = 0x06;
    public static final int XML_WN_GET_TOKEN = 0x07;
    public static final int XML_WN_REQUEST_OK = 0x0a;
    public static final int XML_WN_REQUEST_ERROR = 0x0b;
}
