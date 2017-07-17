package com.openmind.hacadaptor.socket.socketutil;

import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;
import jdk.nashorn.internal.runtime.ECMAException;
import org.apache.log4j.Logger;

import javax.net.ssl.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
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

    private static Socket getSocket() throws Exception{
        logger.info("init socket--- " + ip + ":" + port);
        Socket socket = new Socket();
        socket.setKeepAlive(true);
        socket.setSoTimeout(timeout);
        return socket;
    }

    public static byte[] request(byte[] b) {
        byte[] header = new byte[20];//去掉头部 20 byte长度
        int index = 0;
        int readLen = 0;
        int totalLen = 0;
        byte[] buffer = null;
        try {
            SSLSocket socket = getSSLSocket();
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

        byte[] header = new byte[20];//去掉头部 20 byte长度
        byte[] body = null;
        int index = 0;
        int readLen;
        int totalLen;
        int resultType;
        try {
//            SSLSocket socket = getSSLSocket();
            Socket socket=getSocket();
            logger.info("connect to server...");
            socket.connect(socketAddress);
            logger.info("connected...");
            OutputStream os = socket.getOutputStream();
            os.write(data);
            os.flush();
            logger.info("data pushed to hac server...");
            InputStream is = socket.getInputStream();
            if (is != null) {
                //读取头20字节，获取结果
                logger.info("reading data from hac server...");
                is.read(header);
                xmldto.setXmlHeaderBytesBack(header);
                totalLen = ByteUtil.byteArrayToInt(ByteUtil.getSubBytes(header, 16, 4));
                body = new byte[totalLen];
                StreamTool.readStream(is, body, index, totalLen);
                is.close();
            }
            os.close();
            socket.close();
            logger.info("read finished...Socket closed...");
        } catch (Exception e) {
            e.printStackTrace();
            xmldto.setErrorMessage(e.getMessage());
            xmldto.setErrorCode(1);
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
