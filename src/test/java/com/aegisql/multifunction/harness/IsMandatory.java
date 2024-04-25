package com.aegisql.multifunction.harness;

public class IsMandatory extends Exception {
    public IsMandatory() {
    }

    public IsMandatory(String message) {
        super(message);
    }

    public IsMandatory(String message, Throwable cause) {
        super(message, cause);
    }

    public IsMandatory(Throwable cause) {
        super(cause);
    }

    public IsMandatory(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
