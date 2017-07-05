package com.openmind.hacadaptor.socket;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLBody;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLParser;
import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceBackXML;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXMLBody;
import com.openmind.hacadaptor.socket.xml.mode.session.Session;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLBack;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLSend;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteSentXML;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteSentXMLBody;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KJB-001064 on 2017/7/5.
 */
public class commtest {

    @Test
    public void test() {
        WorkNoteSessionXMLSend workNoteSessionXMLSend = new WorkNoteSessionXMLSend();
        workNoteSessionXMLSend.setWorkNoteNumber("123456789");
        WorkNoteSentXML workNoteSentXML = new WorkNoteSentXML();
        workNoteSentXML.setOperator("123");
        workNoteSentXML.setReason("rrrrrrrrrr");
        Session session = new Session();
        session.setAccount("12345");
        WorkNoteSessionXMLBack workNoteSessionXMLBack = new WorkNoteSessionXMLBack();
        workNoteSessionXMLBack.addSession(session);
        workNoteSessionXMLBack.addSession(session);
        XMLBody xmlBody = new WorkNoteSentXMLBody();
        xmlBody.setSentContext(workNoteSentXML);
//        XMLBody<WorkNoteSessionXMLBack> xmlBody2 = new XMLBody<WorkNoteSessionXMLBack>();
//        xmlBody2.setBackContext(workNoteSessionXMLBack);
        DeviceXMLBody deviceXMLBody = new DeviceXMLBody();
        Device device = new Device();
        device.setDeviceName("123");
        List<Device> list = new ArrayList<>();
        list.add(device);
        DeviceBackXML devicesXML = new DeviceBackXML();
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
        WorkNoteSessionXMLSend workNoteSessionXMLSend = new WorkNoteSessionXMLSend();
        workNoteSessionXMLSend.setWorkNoteNumber("123456789");
        WorkNoteSentXML workNoteSentXML = new WorkNoteSentXML();
        workNoteSentXML.setOperator("123");
        workNoteSentXML.setReason("rrrrrrrrrr");
        Session session = new Session();
        session.setAccount("12345");
        WorkNoteSessionXMLBack workNoteSessionXMLBack = new WorkNoteSessionXMLBack();
        workNoteSessionXMLBack.addSession(session);
        workNoteSessionXMLBack.addSession(session);
        XMLBody xmlBody = new WorkNoteSentXMLBody();
        xmlBody.setSentContext(workNoteSentXML);
        xmlBody.getBytes();
    }
}
