package com.captain.wds.myapplication.exception;

public class WdsHttpException extends WdsHatException {
    public WdsHttpException() {
    }

    public WdsHttpException(String message) {
        super(message);
    }

    public WdsHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public WdsHttpException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);

    }
}
