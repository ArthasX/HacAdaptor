package com.openmind.hacadaptor.socket.socketserver;

import com.openmind.hacadaptor.socket.socketutil.StreamTool;
import com.openmind.hacadaptor.socket.util.ByteUtil;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLType;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by KJB-001064 on 2017/6/26.
 */
public class ListenService implements Runnable {
    Socket socket;
    int bufferSize = 1024;

    public ListenService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println(System.getProperty("user.dir"));
            InputStream is = socket.getInputStream();
            byte[] readbyte = StreamTool.readStrem(is);
            OutputStream os = socket.getOutputStream();
            String path= ListenService.class.getClassLoader().getResource("devicelist.xml").getPath();
//            File f = new File("classpath://devicelist.xml");
            System.out.println(path);
            File f=new File(path);
            FileReader fileReader = new FileReader(f);
            BufferedReader br = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String tmp;
            while ((tmp = br.readLine()) != null) {
                System.out.println(tmp);
                sb.append(tmp);
            }
            byte[] body = sb.toString().getBytes();
            String token = "1234567890ab";
            int xmlType = XMLType.XML_WN_GET_RESOURCE;
            int xmlSize = body.length;
            ByteBuffer byteBuffer = ByteBuffer.allocate(20);
            byteBuffer.put(token.getBytes()).put(ByteUtil.intToByteArray(xmlType))
                    .put(ByteUtil.intToByteArray(xmlSize));
            byte[] header = byteBuffer.array();
            os.write(header);
            os.write(body);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
