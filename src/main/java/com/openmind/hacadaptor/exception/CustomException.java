package com.openmind.hacadaptor.exception;

/**
 * @author LiuBin
 * @version Created on 2017/7/14
 */
public class CustomException extends RuntimeException {
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
