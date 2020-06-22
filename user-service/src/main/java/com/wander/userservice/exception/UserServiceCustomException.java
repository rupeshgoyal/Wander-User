package com.wander.userservice.exception;

public class UserServiceCustomException extends RuntimeException {
    public UserServiceCustomException() {
        super();
    }

    public UserServiceCustomException(String message) {
        super(message);
    }

    public UserServiceCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserServiceCustomException(Throwable cause) {
        super(cause);
    }

    protected UserServiceCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
