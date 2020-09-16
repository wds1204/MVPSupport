package com.captain.wds.myapplication.exception;

/**
 * Copyright (C), 2016-2020, 未来酒店
 * File: WdsHatException.java
 * Author: wds_sun
 * Date: 2020/9/16 5:43 PM
 * Description:
 */
class WdsHatException extends RuntimeException {

    public WdsHatException() {}

    public WdsHatException(String detailMessage) {
        super(detailMessage);
    }

    public WdsHatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WdsHatException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
}
