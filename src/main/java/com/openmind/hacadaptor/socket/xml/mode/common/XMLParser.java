package com.openmind.xml.mode.common;

import com.openmind.xml.mode.datafactory.DeviceXMLDataFactory;
import com.openmind.xml.mode.session.Session;
import com.openmind.xml.mode.session.WorkNoteSessionXMLBack;
import com.openmind.xml.mode.session.WorkNoteSessionXMLSend;

import javax.xml.bind.*;
import java.io.*;

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
    public static <T> String Object2XML(T t) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(t, writer);
        return writer.toString();
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
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(content));
    }

    private void test(){
        WorkNoteSessionXMLSend workNoteSessionXMLSend = new WorkNoteSessionXMLSend();
        workNoteSessionXMLSend.setWorkNoteNumber("123456789");
        Session session = new Session();
        session.setAccount("12345");
        WorkNoteSessionXMLBack workNoteSessionXMLBack = new WorkNoteSessionXMLBack();
        workNoteSessionXMLBack.addSession(session);
        workNoteSessionXMLBack.addSession(session);
        XMLBody<WorkNoteSessionXMLSend> xmlBody = new XMLBody<WorkNoteSessionXMLSend>();
        xmlBody.setContext(workNoteSessionXMLSend);
        XMLBody<WorkNoteSessionXMLBack> xmlBody2 = new XMLBody<WorkNoteSessionXMLBack>();
        xmlBody2.setContext(workNoteSessionXMLBack);
        try {
            System.out.println(XMLParser.Object2XML(xmlBody));
            // System.out.println(XMLParser.Object2XML(xmlBody1));
            System.out.println(XMLParser.Object2XML(xmlBody2));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------read from file----------------------------------------");
        try {
            File f = new File("d:/test.xml");
            //FileInputStream fileInputStream = new FileInputStream(f);
            FileReader fileReader=new FileReader(f);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            StringBuffer sb= new StringBuffer();
            String tmp;
            while((tmp=bufferedReader.readLine())!=null){
                sb.append(tmp);
            }
            System.out.println(sb.toString());
            XMLBody xmlBody3=XMLParser.XML2Object(XMLBody.class,sb.toString());
            System.out.println(xmlBody3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DeviceXMLDataFactory deviceXMLDataFactory = new DeviceXMLDataFactory();
        try {
            System.out.println(XMLParser.Object2XML(deviceXMLDataFactory.getXMLData()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
