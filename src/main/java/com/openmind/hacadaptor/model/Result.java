package com.openmind.hacadaptor.model;

import com.alibaba.fastjson.JSON;
import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.sqlutil.MysqlErrTranslator;

/**
 * The return value of controller. Work as DTO.
 *
 * @author LiuBin
 * @version Created on 2017/7/11
 *
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

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public static Result getResult(XMLDTO xmldto) {
        Result result = new Result();
        result.setErrorCode(xmldto.getErrorCode());
        if (xmldto.getErrorCode() != 0) {
            result.setSuccess(false);
            result.setErrorMessage(xmldto.getErrorMessage());
        } else {
            if (xmldto.getXmlDataBack().getXmlHeader().getiXmlSize() > 0)
                result.setData(xmldto.getResult().getBackContext().getContextDetail());
        }
        return result;
    }

    public static Result getErrResult(Exception e) {
        Result result = new Result();
        result.setErrorCode(1);
        result.setErrorMessage(MysqlErrTranslator.getErrorInfo(e));
        result.setSuccess(false);
        return result;
    }

    public static Result getErrResult(Throwable t) {
        Result result = new Result();
        result.setErrorCode(1);
        result.setErrorMessage(t.getClass().toString());
        result.setSuccess(false);
        return result;
    }

    public static Result getFailureResult(String msg) {
        Result result = new Result();
        result.setErrorCode(1);
        result.setErrorMessage(msg);
        result.setSuccess(false);
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
