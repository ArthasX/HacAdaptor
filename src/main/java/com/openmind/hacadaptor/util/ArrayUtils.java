package com.openmind.hacadaptor.util;

import java.util.Arrays;

/**
 * Created by LiuBin on 2017/6/22.
 */
public class ArrayUtils {
    /**
     * append the next arrays to the first array
     *
     * @param first
     * @param next
     * @param <T>
     * @return
     */
    public static <T> T[] addAll(T[] first, T[]... next) {
        int length = first.length;
        for (T[] t : next) {
            length += t.length;
        }
        T[] result = Arrays.copyOf(first, length);
        int offset = first.length;
        for (T[] t : next) {
            System.arraycopy(t, 0, result, offset, t.length);
            offset += t.length;
        }
        return result;
    }

    public void test(String s) {
        System.out.println(s);
    }
}
