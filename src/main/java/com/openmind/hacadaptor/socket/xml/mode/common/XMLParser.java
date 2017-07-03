package com.openmind.hacadaptor.socket.xml.mode.common;

import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.util.FileUtil;
import com.openmind.hacadaptor.socket.xml.mode.datafactory.DeviceXMLDataFactory;
import com.openmind.hacadaptor.socket.xml.mode.session.Session;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLBack;
import com.openmind.hacadaptor.socket.xml.mode.session.WorkNoteSessionXMLSend;

import javax.xml.bind.*;
import java.io.*;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.openmind.hacadaptor.socket.util.ByteUtil.getSubBytes;

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

    public static <T> T XML2Object(Class<T> tClass, byte[] bytes) throws JAXBException {
//        FileUtil.write(new String(bytes));
        return XML2Object(tClass, new String(bytes));
    }

    public static <T extends Context> T XML2Object(XMLBody<T> xmlBody,byte[] bytes) throws JAXBException{
        Type genType=xmlBody.getContext().getClass().getGenericSuperclass();
        Type[] params=((ParameterizedType)genType).getActualTypeArguments();
        Class entityClass =(Class)params[0];
        return (T)XML2Object(entityClass,bytes);
    }

    public static XMLHeader HeaderBytes2Object(byte[] bytes) {
        String token = new String(getSubBytes(bytes, 0, 12));
        int xmlType = ByteUtil.byteArrayToInt(getSubBytes(bytes, 12, 4));
        int xmlSize = ByteUtil.byteArrayToInt(getSubBytes(bytes, 16, 4));
        return new XMLHeader(token, xmlType, xmlSize);
    }



    private static void test() {
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
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer sb = new StringBuffer();
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                sb.append(tmp);
            }
            System.out.println(sb.toString());
            XMLBody xmlBody3 = XMLParser.XML2Object(XMLBody.class, sb.toString());
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
