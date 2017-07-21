package com.openmind.hacadaptor.socket.hacoperation;

import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.model.common.XMLTransmitter;
import com.openmind.hacadaptor.socket.xml.model.datafactory.LoginXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.model.login.LoginDTO;

/**
 * 获取操作人员信息（HAC端接口名为Login，保持一致，这里也命名Login）
 * <p>
 * Created by LiuBin on 2017/7/6.
 */
public class LoginOperation extends BaseOperation {
    public LoginOperation() {
        xmldto = new LoginDTO();
        LoginXMLDataFactory loginXMLDataFactory = new LoginXMLDataFactory();
        xmldto.setXmlData(loginXMLDataFactory.getXMLData());

    }

    @Override
    public XMLDTO getXmldtoBack() {
        xmldto = XMLTransmitter.trans(xmldto);
        return xmldto;
    }
}
