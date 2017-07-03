package com.openmind.hacadaptor.socket.util;

import java.nio.ByteBuffer;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class ByteUtil {
    private static ByteBuffer buffer = ByteBuffer.allocate(8);
    //byte 与 int 的相互转换
    public static byte intToByte(int x) {
        return (byte) x;
    }

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }

    //byte 数组与 int 的相互转换
    public static int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    //byte 数组与 long 的相互转换
    public static byte[] longToBytes(long x) {
        buffer.putLong(0, x);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();//need flip
        return buffer.getLong();
    }

    public static byte[] getSubBytes(byte[] bytes, int start, int length) {
        if (start < 0 || start > bytes.length)
            try {
            } catch (Exception e) {
                new Exception("the start position is out of  bytes index");
            }
        int len1 = bytes.length - start;
        int len2 = length;
        int len = len1 < len2 ? len1 : len2;
        byte[] b = new byte[len];
        for (int i = start; i < len + start; i++) {
            b[i - start] = bytes[i];
        }
        return b;
    }

    public static byte[] getSubBytes(byte[] bytes, int start){
        return  getSubBytes(bytes,start,bytes.length-start);
    }
}
