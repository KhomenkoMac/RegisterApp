package com.example.register.Exceptions;

public class AuthenticationFailedException extends Exception{
    public AuthenticationFailedException() {
        super();
    }

    public AuthenticationFailedException(String message) {
        super(message);
    }
}
