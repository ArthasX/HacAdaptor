package com.openmind.socketserver;

import com.openmind.socketutil.StreamTool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
public class ListenService implements Runnable {
    Socket socket;
    int bufferSize=1024;
    public ListenService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            StringBuffer sb= new StringBuffer();
            //byte[] buffer = new byte[bufferSize];
            InputStream is = socket.getInputStream();
            byte[] readbyte= StreamTool.readStrem(is);
            OutputStream os = socket.getOutputStream();
            String in=new String(readbyte);
            System.out.println(in);
            String out="收到:"+in;
            os.write(out.getBytes());
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
