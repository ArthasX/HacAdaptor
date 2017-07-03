package com.openmind.hacadaptor.socket.socketutil;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by KJB-001064 on 2017/6/27.
 */
public class StreamTool {
    public static byte[] readStrem(InputStream is)throws IOException {
        int count=0;
        while(count==0){
            count=is.available();
        }
        byte[] b = new byte[count];
        is.read(b);
        return b;
    }
}
