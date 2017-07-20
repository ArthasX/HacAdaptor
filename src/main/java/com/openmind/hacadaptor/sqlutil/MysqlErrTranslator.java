package com.openmind.hacadaptor.sqlutil;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/***
 * 错误码对应信息在mysqlerr.properties中配置
 */
public class MysqlErrTranslator {
    public static class MyError {
        int errno;
        String szErrorDesc;

        public MyError(int errno, String errorDesc) {
            this.errno = errno;
            this.szErrorDesc = "错误码:" + errno + "错误信息：" + errorDesc;
        }

        public int getErrorNo() {
            return errno;
        }

        public String getErrorDesc() {
            return szErrorDesc;
        }
    }


    public static MyError getError(int errno) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("appconfig");
            String emsg = new String(rb.getString(Integer.toString(errno)).getBytes("ISO-8859-1"), "GBK");
            return new MyError(errno, emsg);
        } catch (MissingResourceException e) {
            return new MyError(errno, "数据库错误码未定义");
        } catch (UnsupportedEncodingException e) {
            return new MyError(99999, "系统资源转码错误");
        } catch (Exception e) {
            return new MyError(99998, "系统内部错误" + e.getMessage());
        }
    }


    public static int getErrno(Exception e) {
        int errno = -1;
        if (e instanceof SQLException) {
            SQLException sqle = (SQLException) e.getCause();
            errno = sqle.getErrorCode();
        }
        return errno;
    }

    public static String getErrorInfo(Exception e){
        return getError(e).getErrorDesc();
    }
    public static String getErrorInfo(int errno) {
        return getError(errno).getErrorDesc();
    }


    public static MyError getError(Exception e) {
        if (getErrno(e) < 0)
            return new MyError(99997, e.getClass() + e.getMessage());
        else
            return getError(getErrno(e));
    }

    public static JSON getJsonErrorInfo(int errno, Logger logger) {
        MyError err = getError(errno);
        JSON json = (JSON) JSON.toJSON(err);
        logger.error(json.toJSONString());
        return json;
    }

    public static JSON getJsonErrorInfo(Exception e, Logger logger) {
        return getJsonErrorInfo(getErrno(e), logger);
    }

//    public static JSON getJsonErrorMsg(Exception e, Logger logger) {
//        MyError err = getError(e);
//        Msg msg = new Msg(err);
//        return msg.toJSON();
//    }
}