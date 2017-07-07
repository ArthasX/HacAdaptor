package com.openmind.hacadaptor.socket.xml.mode.common;

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



}
