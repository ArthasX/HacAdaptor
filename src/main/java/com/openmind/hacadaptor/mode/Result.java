package com.openmind.hacadaptor.mode;

/**
 * controller的返回值
 * @author LiuBin
 * @version Created on 2017/7/11
 */
public class Result {
    IBaseMode data;
    int errorCode;
    String errorMessage;
    boolean success;//用于 ajax

    public IBaseMode getData() {
        return data;
    }

    public void setData(IBaseMode data) {
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
}
