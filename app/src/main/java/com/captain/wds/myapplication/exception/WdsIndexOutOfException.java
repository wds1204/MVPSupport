package com.captain.wds.myapplication.exception;

public class WdsIndexOutOfException extends WdsHatException {
    public WdsIndexOutOfException() {
    }

    public WdsIndexOutOfException(String message) {
        super(message);
    }

    public WdsIndexOutOfException(String message, Throwable cause) {
        super(message, cause);
    }

    public WdsIndexOutOfException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
}
