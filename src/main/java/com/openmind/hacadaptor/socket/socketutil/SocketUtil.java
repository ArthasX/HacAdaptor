package com.openmind.hacadaptor.socket.socketutil;

import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import org.apache.log4j.Logger;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ResourceBundle;

/**
 * Created by LiuBin on 2017/6/26.
 */
public class SocketUtil {

    static Logger logger = Logger.getLogger(SocketUtil.class);

    private static String ip = ResourceBundle.getBundle("setting").getString("ip");
    private static int port = Integer.parseInt(ResourceBundle.getBundle("setting").getString("port"));
    private static SocketAddress socketAddress = new InetSocketAddress(ip, port);
    private static int timeout = Integer.parseInt(ResourceBundle.getBundle("setting").getString("timeout"));


    private static SSLSocket getSSLSocket() throws Exception {
        X509TrustManager x =
                new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                };
        TrustManager[] tm = new TrustManager[]{x};
        SSLContext sslContext = SSLContext.getInstance("SSLv3");
        sslContext.init(null, tm, new SecureRandom());
        SSLEngine sslEngine = sslContext.createSSLEngine();
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        logger.info("init sslsocket--- " + ip + ":" + port);
        SSLSocket socket = (SSLSocket) ssf.createSocket(ip, port);
        socket.setKeepAlive(true);
        socket.setSoTimeout(timeout);
        return socket;
    }

    private static Socket getSocket() throws Exception {
        logger.info("init socket--- " + ip + ":" + port);
        Socket socket = new Socket();
        socket.setKeepAlive(true);
        socket.setSoTimeout(timeout);
        logger.info("connect to server...");
        socket.connect(socketAddress);
        logger.info("connected...");
        return socket;
    }

    public static byte[] request(byte[] b) {
        byte[] header = new byte[20];//去掉头部 20 byte长度
        int index = 0;
        int readLen = 0;
        int totalLen = 0;
        byte[] buffer = null;
//        SSLSocket socket = null;
        Socket socket = null;
        try {
             socket = getSocket();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static byte[] request(String data) {
        return request(data.getBytes());
    }


    public static XMLDTO request(XMLDTO xmldto) {
        byte[] data = xmldto.getXmlData().getBytes();
        System.out.println("发送的长度"+data.length);
        int headLen = 20;
        byte[] header = new byte[headLen];//去掉头部 20 byte长度
        byte[] body = null;
        int index = 0;
        int readDataLen, writeDataLen = data.length;
        InputStream is = null;
        OutputStream os = null;
        SSLSocket socket = null;
//        Socket socket = null;
//        int wIndex = 0, wOffset = 10 * 1024;
        try {
            socket = getSSLSocket();
//            socket = getSocket();
            socket.setSendBufferSize(32 * 1024);
            os = socket.getOutputStream();
//            StreamTool.writeStream(os,data,0,writeDataLen);
            //极端情况一次发送的数据大概有280K TCP只能承载64K一次的数据流 所以 分次发送 每次10K
//            while (wIndex < data.length) {
//
//                os.write(data,wIndex,wOffset);
//                os.flush();
//            }
            StreamTool.writeStream(os, data, 0, data.length);
            logger.info("data pushed to hac server...");
            is = socket.getInputStream();
            if (is != null) {
                //读取头20字节，获取结果
                logger.info("reading data from hac server...");
                is.read(header);
                xmldto.setXmlHeaderBytesBack(header);
                readDataLen = ByteUtil.byteArrayToInt(ByteUtil.getSubBytes(header, 16, 4));
                logger.info("data length:" + readDataLen);
                body = new byte[readDataLen];
                StreamTool.readStream(is, body, index);
            }

            logger.info("read finished...socket closed...");
        } catch (Exception e) {
            e.printStackTrace();
            xmldto.setErrorMessage(e.getMessage());
            xmldto.setErrorCode(1);

        } finally {
//            try {
//                if (is != null) is.close();
//                if (os != null) os.close();
//                if (socket != null) socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//                xmldto.setErrorMessage(e.getMessage());
//                xmldto.setErrorCode(1);
//            }
        }
        xmldto.setXmlBodyBytesBack(body);
        return xmldto;
    }

    public static void main(String[] args) {
        String ip = ResourceBundle.getBundle("setting").getString("ip");
        request("hello world");
        System.out.println(ip);
    }
}
