package com.openmind.hacadaptor.socket.socketserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * this is for unit test
 * Created by LiuBin on 2017/6/26.
 */
public class SocketServer {
    public static boolean isRunning = true;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (isRunning) {
                Socket socket = ss.accept();
                new Thread(new ListenService(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
