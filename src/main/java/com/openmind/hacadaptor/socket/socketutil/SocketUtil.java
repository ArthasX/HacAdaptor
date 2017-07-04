package com.openmind.hacadaptor.socket.socketutil;

import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.ResourceBundle;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
public class SocketUtil {

    static Logger logger = Logger.getLogger(SocketUtil.class);
    private static Socket socket = new Socket();
    private static String ip = ResourceBundle.getBundle("setting").getString("ip");
    private static int port = Integer.parseInt(ResourceBundle.getBundle("setting").getString("port"));
    private static SocketAddress socketAddress = new InetSocketAddress(ip, port);
    private static int timeout = Integer.parseInt(ResourceBundle.getBundle("setting").getString("timeout"));


    public static void init() {

        try {
            socket.setKeepAlive(true);
            socket.setSoTimeout(timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static byte[] request(byte[] b) {
        byte[] header = new byte[20];//去掉头部 20 byte长度
        int index = 0;
        int readLen = 0;
        int totalLen = 0;
        byte[] buffer = null;
        try {
            logger.info("init socket--- " + ip + ":" + port);
            init();
            logger.info("connect to server...");
            socket.connect(socketAddress);
            logger.info("connected...");
            OutputStream os = socket.getOutputStream();
            os.write(b);
            os.flush();
            InputStream is = socket.getInputStream();
            if (is != null) {
                //读取头20字节，获取结果
                is.read(header);
                totalLen = ByteUtil.byteArrayToInt(ByteUtil.getSubBytes(header, 16, 4));
                buffer = new byte[totalLen];
                while (index < totalLen) {
                    readLen = is.read(buffer, index, totalLen - index);
                    if (readLen > 0)
                        index = index + readLen;
                    else
                        break;
                }
                is.close();
            }
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static byte[] request(String data) {
        return request(data.getBytes());
    }

    public static XMLDTO request(XMLDTO xmldto) {
        byte[] data = xmldto.getXmlData().getBytes();

        byte[] header = new byte[20];//去掉头部 20 byte长度
        byte[] body = null;

        int index = 0;
        int readLen;
        int totalLen;
        int resultType;
        try {
            logger.info("init socket--- " + ip + ":" + port);
            init();
            logger.info("connect to server...");
            socket.connect(socketAddress);
            logger.info("connected...");
            OutputStream os = socket.getOutputStream();

            os.write(data);
            os.flush();
            InputStream is = socket.getInputStream();
            if (is != null) {
                //读取头20字节，获取结果
                is.read(header);
                xmldto.setXmlHeaderBytesBack(header);
                //resultType = ByteUtil.byteArrayToInt(ByteUtil.getSubBytes(header, 12, 4));
                //xmldto.setResultType(resultType);
                totalLen = ByteUtil.byteArrayToInt(ByteUtil.getSubBytes(header, 16, 4));
                body = new byte[totalLen];
                while (index < totalLen) {
                    readLen = is.read(body, index, totalLen - index);
                    if (readLen > 0)
                        index = index + readLen;
                    else
                        break;
                }
                is.close();
            }
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        xmldto.setXmlBodyBytesBack(body);
        return xmldto;
    }

    public static void main(String[] args) {
        String ip = ResourceBundle.getBundle("setting").getString("ip");
        init();
        request("hello world");
        System.out.println(ip);
    }
}
