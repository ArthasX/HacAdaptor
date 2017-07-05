package com.openmind.hacadaptor.socket.socketserver;

import com.openmind.hacadaptor.socket.socketutil.StreamTool;
import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLHeader;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * this is for test
 * Created by KJB-001064 on 2017/6/26.
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
            int xmlTypeOut = XMLType.XML_WN_GET_RESOURCE;
            int xmlSizeOut = body.length;
            ByteBuffer byteBuffer = ByteBuffer.allocate(20+xmlSizeOut);
            byteBuffer.put(token.getBytes()).put(ByteUtil.intToByteArray(xmlTypeOut))
                    .put(ByteUtil.intToByteArray(xmlSizeOut)).put(body);
//            byte[] headerOut = byteBuffer.array();
//            os.write(headerOut);
//            os.write(body);
            os.write(byteBuffer.array());
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String filePath(int xmlType) {
        switch (xmlType) {
            case XMLType.XML_WN_GET_RESOURCE:
                return f("devicelist.xml");
            case XMLType.XML_WN_CHANGE_DATA:
                return f("worknoteback.xml");
            case XMLType.XML_WN_SET_END:
                return f("empty.xml");
            case XMLType.XML_WN_GET_SESSION:
                return f("");
            case XMLType.XML_QX_GET_SESSION:
                return f("");
            case XMLType.XML_WN_GET_LOGIN:
                return f("");
            case XMLType.XML_WN_GET_TOKEN:
                return f("");
            default:
                return "";
        }
    }

    private String f(String name) {
        return ListenService.class.getClassLoader().getResource(name).getPath();
    }
}
