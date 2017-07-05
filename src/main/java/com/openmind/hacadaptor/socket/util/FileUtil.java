package com.openmind.hacadaptor.socket.util;

import java.io.*;

/**
 * this is for test
 * Created by KJB-001064 on 2017/7/3.
 */
public class FileUtil {
    public static void write(String data) {
        File f = new File("c:/out.txt");
        FileOutputStream fileOutputStream = null;
        try {
            FileWriter fileWriter = new FileWriter(f);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
