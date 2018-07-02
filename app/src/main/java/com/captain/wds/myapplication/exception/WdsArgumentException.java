package com.captain.wds.myapplication.exception;

public class WdsArgumentException extends WdsHatException {
    public WdsArgumentException() {
    }

    public WdsArgumentException(String message) {
        super(message);
    }

    public WdsArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public WdsArgumentException(Throwable cause) {
        super(cause);
    }
}
