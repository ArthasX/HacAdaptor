package com.openmind.hacadaptor.mode;

import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;

/**
 * controller的返回值
 *
 * @author LiuBin
 * @version Created on 2017/7/11
 */
public class Result {
    Object data;
    int errorCode;
    String errorMessage;
    String message;
    boolean success;//用于 ajax

    public Result() {
        this.success = true;
    }

    //    public IBaseMode getData() {
//        return data;
//    }
//
//    public void setData(IBaseMode data) {
//        this.data = data;
//    }
    public static Result getResult(XMLDTO xmldto) {
        Result result = new Result();
        result.setErrorCode(result.getErrorCode());
        if (xmldto.getErrorCode() != 0) {
            result.setSuccess(false);
            result.setErrorMessage(xmldto.getErrorMessage());
        }else
            result.setData(xmldto.getResult().getBackContext().getContextDetail());
        return result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
