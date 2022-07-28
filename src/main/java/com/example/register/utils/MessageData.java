package com.example.register.utils;

import java.util.Optional;

public class MessageData {
    private static String successMessage;
    private static String failedMessage;

    public static void setSuccessMessage(String successMessage){
        MessageData.successMessage = successMessage;
    }

    public static void setFailedMessage(String failedMessage){
        MessageData.failedMessage = failedMessage;
    }

    public static Optional<String> getSuccessMessage() {
        var buff = successMessage;
        successMessage = null;
        return Optional.ofNullable(buff);
    }

    public static Optional<String> getFailedMessage() {
        var buff = failedMessage;
        failedMessage = null;
        return Optional.ofNullable(buff);
    }
}
