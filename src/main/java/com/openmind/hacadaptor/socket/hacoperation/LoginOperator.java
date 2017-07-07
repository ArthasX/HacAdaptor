package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.LoginXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.login.LoginDTO;

/**
 * 获取操作人员信息（HAC端接口名为Login，保持一致，这里也命名Login）
 * <p>
 * Created by LiuBin on 2017/7/6.
 */
public class LoginOperator extends BaseOperation {
    public LoginOperator() {
        xmldto = new LoginDTO();
        LoginXMLDataFactory loginXMLDataFactory = new LoginXMLDataFactory();
        xmldto.setXmlData(loginXMLDataFactory.getXMLData());
        xmldto = XMLTransmitter.trans(xmldto);
    }
    @Override
    public XMLDTO getXmldtoBack() {
        return xmldto;
    }
}
