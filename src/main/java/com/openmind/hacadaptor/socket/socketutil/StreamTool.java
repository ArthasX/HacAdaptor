package com.openmind.hacadaptor.socket.socketutil;

import com.openmind.hacadaptor.socket.util.ByteUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by LiuBin on 2017/6/27.
 */
public class StreamTool {

    public static int writeStream(OutputStream os, byte[] bytes, int index, int dataSize) throws IOException, InterruptedException {
        int writeSize = 1024;
        int totalWriteLen = 0;
        int remainSize = dataSize;
        while (remainSize > 0) {
            if (remainSize > writeSize) {
                os.write(bytes, index, writeSize);
                index += writeSize;
                totalWriteLen += writeSize;
                remainSize -= writeSize;
            }
            else {
                os.write(bytes, index, remainSize);
                totalWriteLen+=remainSize;
                remainSize-=remainSize;
            }
        }
        os.flush();
        return totalWriteLen;
    }

    public static int readStream(InputStream is, byte[] bytes, int index, int dataSize)
            throws IOException, InterruptedException {
        int readSize = 0;
        int totalReadLen = 0;
        int remainSize = dataSize;
        while (remainSize > 0) {
            readSize = is.read(bytes, index, dataSize);
            Thread.sleep(1);
            if (readSize > 0) {
                index += readSize;
                totalReadLen += readSize;
                remainSize -= readSize;
            }
//            else
//                break;
        }
        return totalReadLen;
    }

    public static byte[] readStream(InputStream is, byte[] bytes, int index)
            throws IOException, InterruptedException {
        byte[] len = new byte[4];
        int length = 0;
        int readLen = 0;
        while (true) {
            is.read(len, 0, 4);
            //获取数据长度
            length = ByteUtil.byteArrayToIntLH(len);
            if (length > 0) {
                readLen = readStream(is, bytes, index, length);
                if (readLen == length)
                    index = index + readLen;
                else
                    throw new RuntimeException("读取字节数据出错 index:" + index + "length:" + length);
            } else
                break;
        }

        return bytes;
    }
}
