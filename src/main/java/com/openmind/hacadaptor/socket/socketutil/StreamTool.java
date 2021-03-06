package com.openmind.hacadaptor.socket.socketutil;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by LiuBin on 2017/6/27.
 */
public class StreamTool {
    public static byte[] readStream(InputStream is) throws IOException {
        int count = 0;
        while (count == 0) {
            count = is.available();
        }
        byte[] b = new byte[count];
        is.read(b);
        return b;
    }

    public static byte[] readStream(InputStream is, byte[] bytes, int index, int totalLen)
            throws IOException {
        int readLen;
        while (index < totalLen) {
            readLen = is.read(bytes, index, totalLen - index);
            if (readLen > 0)
                index = index + readLen;
            else
                break;
        }
        return bytes;
    }
}
