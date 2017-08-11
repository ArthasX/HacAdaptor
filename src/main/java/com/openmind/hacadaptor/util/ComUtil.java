package com.openmind.hacadaptor.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by KJB-001064 on 2017/4/24.
 */
public class ComUtil {
    static Logger log = Logger.getLogger(ComUtil.class);

    /**
     * 发送HTTP请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方法 POST GET ...
     * @param output        提交的数据
     * @return
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String output) {
       return httpRequest(requestUrl,requestMethod,"application/json",output);
    }


    public static JSONObject httpRequest(String requestUrl, String requestMethod,String contentType, String output) {
        JSONObject jsonObject = null;
        StringBuilder sb = new StringBuilder();
        OutputStream ops = null;
        InputStream ips = null;
        InputStreamReader ipr = null;
        BufferedReader br = null;
        HttpURLConnection con = null;
        try {
            log.info("start to connect");
            URL url = new URL(requestUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("content-type", contentType);
            con.setRequestProperty("accept","application/json");
            //
            if (output != null) {
                ops = con.getOutputStream();
                ops.write(output.getBytes("UTF-8"));
            }
            //
            ips = con.getInputStream();
            ipr = new InputStreamReader(ips, "UTF-8");
            br = new BufferedReader(ipr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            jsonObject = JSON.parseObject(sb.toString());
        } catch (Exception e) {
            log.error("conncet failed--" + e);
        } finally {
            try {
                if (ops != null)
                    ops.close();
                if (ips != null)
                    ips.close();
                if (br != null)
                    br.close();
                if (ipr != null)
                    ipr.close();
                ips = null;
                con.disconnect();
                log.info("connection closed!");
            } catch (Exception e) {
                log.error("close failed" + e.getCause());
            }
        }
        log.info(jsonObject);
        return jsonObject;
    }
}

//oWcZSW92eTQBtEVgV9y5efpBkOO-5QnIY7KxLzlo6vgdeW0gna2K4ZqtvRG6KCJI
//oWcZSW92eTQBtEVgV9y5efpBkOO-5QnIY7KxLzlo6vgdeW0gna2K4ZqtvRG6KCJI
//CvQQ8xnR80rY0qE6LPsW5QDX2ytqYTT6mm7nuwKLAm32M4IRJQ1XW6Gv0QxsWfok
//dfSCcW5u9JIlahsyibFl3St4JQk542NL9bob2BpUv3cXHIRYTrRdYn9seB6iMPI8
//dfSCcW5u9JIlahsyibFl3St4JQk542NL9bob2BpUv3cXHIRYTrRdYn9seB6iMPI8