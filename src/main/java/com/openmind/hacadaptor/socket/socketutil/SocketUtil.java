package com.openmind.socketutil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ResourceBundle;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
public class SocketUtil {

    private static Socket socket = new Socket();
    private static String ip = ResourceBundle.getBundle("setting").getString("ip");
    private static int port = Integer.parseInt(ResourceBundle.getBundle("setting").getString("port"));
    private static SocketAddress socketAddress = new InetSocketAddress(ip, port);
    private static int timeout = Integer.parseInt(ResourceBundle.getBundle("setting").getString("timeout"));

    private static byte[] in = new byte[1024];
    private static byte[] out = new byte[1024];


    public static void init() {
        System.out.println("init");
        try {
            socket.setKeepAlive(true);
            socket.setSoTimeout(timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String request(byte[] b) {
        try {
            init();
            socket.connect(socketAddress);
            StringBuffer sb = new StringBuffer();
            OutputStream os = socket.getOutputStream();
            os.write(b);
            os.flush();
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[0];
            if (is != null) {
                bytes = StreamTool.readStrem(is);
            }
            is.close();
            os.close();
            socket.close();
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String request(String data) {
        return request(data.getBytes());
    }

    public static void main(String[] args) {
        String ip = ResourceBundle.getBundle("setting").getString("ip");
        init();
        request("hello world");
        System.out.println(ip);
    }
}
