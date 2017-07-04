package com.openmind.hacadaptor.socket.xml.mode.common;

import com.openmind.hacadaptor.socket.xml.mode.devices.Device;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceXMLBody;
import com.openmind.hacadaptor.socket.xml.mode.devices.DeviceBackXML;
import com.openmind.hacadaptor.socket.xml.mode.session.Session;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLBack;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLSend;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteSentXMLBody;
import com.openmind.hacadaptor.socket.xml.mode.worknote.WorkNoteSentXML;

import javax.xml.bind.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * XML to JavaBean
 * JavaBean to XML
 */
public class XMLParser {

    /**
     * get xml from Object
     *
     * @param t   Object
     * @param <T> Object's class
     * @return xmlString
     * @throws JAXBException
     */
    public static <T> String Object2XML(T t,Class<?> ...tClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(t, writer);
        return writer.toString();
    }
    public static <T> String Object2XML(T t) throws JAXBException {
        return Object2XML(t,XMLBody.class,t.getClass());
    }
    /**
     * get object from xml
     *
     * @param tClass  Object's class
     * @param content xml content
     * @param <T>     Object's class
     * @return Object
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T XML2Object(Class<T> tClass, String content) throws JAXBException {
        return XML2Object(content, XMLBody.class, tClass);
    }

    public static <T> T XML2Object(String content, Class<?>... tClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(content));
    }

    public static <T> T XML2Object(Class<T> tClass, byte[] bytes) throws JAXBException {
//        FileUtil.write(new String(bytes));
        return XML2Object(tClass, new String(bytes));
    }


    private static void test() {
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

    public static void main(String[] args) {
//        DeviceXMLDataFactory deviceXMLDataFactory = new DeviceXMLDataFactory();
//        try {
//            System.out.println(XMLParser.Object2XML(deviceXMLDataFactory.getXMLData()));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        test();

    }
}
