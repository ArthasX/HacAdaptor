package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.xml.model.common.XMLBody;
import com.openmind.hacadaptor.socket.xml.model.common.XMLParser;
import com.openmind.hacadaptor.socket.xml.model.devices.SDevice;
import com.openmind.hacadaptor.socket.xml.model.devices.DeviceBackContext;
import com.openmind.hacadaptor.socket.xml.model.devices.DeviceXMLBody;
import com.openmind.hacadaptor.socket.xml.model.session.SSession;
import com.openmind.hacadaptor.socket.xml.model.session.SessionBackContext;
import com.openmind.hacadaptor.socket.xml.model.session.SessionSentContext;
import com.openmind.hacadaptor.socket.xml.model.worknote.WorkNoteSentContext;
import com.openmind.hacadaptor.socket.xml.model.worknote.WorkNoteSentXMLBody;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuBin on 2017/7/5.
 */
public class commtest {

    @Test
    public void test() {
        SessionSentContext sessionSentContext = new SessionSentContext();
        sessionSentContext.setWorkNoteNumber("123456789");
        WorkNoteSentContext workNoteSentContext = new WorkNoteSentContext();
        workNoteSentContext.setOperator("123");
        workNoteSentContext.setReason("rrrrrrrrrr");
        SSession session = new SSession();
        session.setAccount("12345");
        SessionBackContext workNoteSessionXMLBack = new SessionBackContext();
        workNoteSessionXMLBack.addSession(session);
        workNoteSessionXMLBack.addSession(session);
        XMLBody xmlBody = new WorkNoteSentXMLBody();
        xmlBody.setSentContext(workNoteSentContext);
//        XMLBody<SessionBackContext> xmlBody2 = new XMLBody<SessionBackContext>();
//        xmlBody2.setBackContext(workNoteSessionXMLBack);
        DeviceXMLBody deviceXMLBody = new DeviceXMLBody();
        SDevice SDevice = new SDevice();
        SDevice.setDeviceName("123");
        List<SDevice> list = new ArrayList<>();
        list.add(SDevice);
        DeviceBackContext devicesXML = new DeviceBackContext();
        devicesXML.setDevices(list);
        deviceXMLBody.setSentContext(devicesXML);
        try {
            System.out.println(XMLParser.Object2XML(deviceXMLBody));
            System.out.println(XMLParser.Object2XML(xmlBody));
//            System.out.println(XMLParser.Object2XML(xmlBody2));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------read from file----------------------------------------");
        try {
            File f = new File("c:/devicelist.xml");
            //FileInputStream fileInputStream = new FileInputStream(f);
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer sb = new StringBuffer();
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                sb.append(tmp);
            }
            System.out.println(sb.toString());
            DeviceXMLBody xmlBody3 = XMLParser.XML2Object(DeviceXMLBody.class, sb.toString());
            System.out.println(xmlBody3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBytes() {
        SessionSentContext sessionSentContext = new SessionSentContext();
        sessionSentContext.setWorkNoteNumber("123456789");
        WorkNoteSentContext workNoteSentContext = new WorkNoteSentContext();
        workNoteSentContext.setOperator("123");
        workNoteSentContext.setReason("rrrrrrrrrr");
        SSession session = new SSession();
        session.setAccount("12345");
        SessionBackContext workNoteSessionXMLBack = new SessionBackContext();
        workNoteSessionXMLBack.addSession(session);
        workNoteSessionXMLBack.addSession(session);
        XMLBody xmlBody = new WorkNoteSentXMLBody();
        xmlBody.setSentContext(workNoteSentContext);
        xmlBody.getBytes();
    }
}
