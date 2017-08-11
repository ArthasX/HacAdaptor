package com.openmind.hacadaptor.socket.socketserver;

import com.openmind.hacadaptor.socket.socketutil.StreamTool;
import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.xml.model.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.model.common.XMLType;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * this is for unit test
 * Created by LiuBin on 2017/6/26.
 */
public class ListenService implements Runnable {
    Socket socket;

    public ListenService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        byte[] header = new byte[20];
        byte[] bodyIn;
        int xmlTypeIn;
        int xmlSizeIn;
        try {
            System.out.println(System.getProperty("user.dir"));
            InputStream is = socket.getInputStream();
            is.read(header);
            XMLHeader xmlHeader = XMLHeader.HeaderBytes2Object(header);
            xmlTypeIn = xmlHeader.getiXmlType();
            xmlSizeIn = xmlHeader.getiXmlSize();
            bodyIn=new byte[xmlSizeIn];
            StreamTool.readStream(is,bodyIn,0,xmlSizeIn);
//            String path = ListenService.class.getClassLoader().getResource("devicelist.xml").getPath();
////            File f = new File("classpath://devicelist.xml");
//            System.out.println(path);
//            String filePath=filePath(xmlTypeIn);
//            System.out.println(filePath);
//            File f = new File(filePath);
            File f = new File(filePath(xmlTypeIn));
            FileReader fileReader = new FileReader(f);
            BufferedReader br = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String tmp;
            OutputStream os = socket.getOutputStream();
            while ((tmp = br.readLine()) != null) {
                System.out.println(tmp);
                sb.append(tmp);
            }
            byte[] body = sb.toString().getBytes();
            String token = "1234567890ab";
            int xmlTypeOut = resutType(xmlTypeIn);
            int xmlSizeOut = body.length;
            ByteBuffer byteBuffer = ByteBuffer.allocate(20+xmlSizeOut);
            byteBuffer.put(token.getBytes()).put(ByteUtil.intToByteArray(xmlTypeOut))
                    .put(ByteUtil.intToByteArray(xmlSizeOut)).put(body);
//            byte[] headerOut = byteBuffer.array();
//            os.write(headerOut);
//            os.write(body);
            os.write(byteBuffer.array());
            os.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String filePath(int xmlType) {
        switch (xmlType) {
            case XMLType.XML_WN_GET_RESOURCE:
                return f("xml/devicelist.xml");
            case XMLType.XML_WN_CHANGE_DATA:
                return f("xml/worknoteback.xml");
            case XMLType.XML_WN_SET_END:
                return f("xml/empty.xml");
            case XMLType.XML_WN_GET_SESSION:
                return f("");
            case XMLType.XML_QX_GET_SESSION:
                return f("xml/session.xml");
            case XMLType.XML_WN_GET_LOGIN:
                return f("xml/user.xml");
            case XMLType.XML_WN_GET_TOKEN:
                return f("");
            default:
                return "";
        }
    }

    private int resutType(int xmlType) {
        switch (xmlType) {
            case XMLType.XML_WN_GET_RESOURCE:
                return XMLType.XML_WN_GET_RESOURCE;
            case XMLType.XML_WN_GET_SESSION:
                return XMLType.XML_WN_GET_RESOURCE;
//            case XMLType.XML_WN_GET_SESSION:
//                return XMLType.XML_WN_GET_SESSION;
            case XMLType.XML_WN_GET_LOGIN:
                return XMLType.XML_WN_GET_LOGIN;
            case XMLType.XML_WN_GET_TOKEN:
                return XMLType.XML_WN_GET_TOKEN;
            default:
                return XMLType.XML_WN_REQUEST_OK;
        }
    }
    private String f(String name) {
        return ListenService.class.getClassLoader().getResource(name).getPath();
    }
}
