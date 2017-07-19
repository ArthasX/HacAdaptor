package com.openmind.hacadaptor.socket.socketserver;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuBin
 * @version Created on 2017/7/17
 */
public class SSLSocketServer {
    public static boolean isRunning = true;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory
                    .getDefault();
            SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(9999);
            while (isRunning) {
                Socket socket=server.accept();
                new Thread(new ListenService(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

