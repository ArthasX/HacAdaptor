
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
 *
 */
public class ComUtil {
    static Logger log = Logger.getLogger(ComUtil.class);

    /**
     * 发送请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方法 POST GET ...
     * @param output        提交的数据 jsonString
     * @return
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String output) {
       return httpRequest(requestUrl,requestMethod,"application/json",output);
    }


    public static JSONObject httpRequest(String requestUrl, String requestMethod,String contentType, String output) {
        JSONObject jsonObject = null;
        StringBuffer sb = new StringBuffer();
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
            con.setRequestProperty("accept", "application/json");
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

/**
public void testRequestPara() {
    WorkNote workNote = new WorkNote();
    workNote.setWorkNoteNumber("S20170701018");
    workNote.setOperator("001064,001000");
    workNote.setReason("fuck");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    workNote.setStartTime(sdf.format(new Date()));
    workNote.setEndTime(sdf.format(new Date()));
    List<String> groupNames = new ArrayList<>();
    groupNames.add("核心账务系统");
    JSONObject jjj = new JSONObject();
    jjj.put("groupname", groupNames);
    jjj.put("workNote", workNote);
    ComUtil.httpRequest("http://localhost:8080/hacadaptor/worknote/emergent"
            , "POST", jjj.toJSONString());

}

 public void testRequestParaGroup() {
        String url = "http://localhost:8080/hacadaptor/devices/group/";

        try {
            String ss=URLEncoder.encode("核心账务系统","UTF-8");
            String s= url+ss;
            System.out.println(s);
            ComUtil.httpRequest(s
                    , "GET", null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

**/