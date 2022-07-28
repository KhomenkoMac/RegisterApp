package com.example.register.Services.Interf;

import com.example.register.Exceptions.AuthenticationFailedException;
import com.example.register.Models.User;

import java.util.NoSuchElementException;

public interface AuthorizationService {
    User signIn(String email, String password) throws NoSuchElementException, AuthenticationFailedException;
    User getCurrentUser();
    boolean isAdmin();
    boolean isRegistrator();
    boolean isUnregistered();
    void signOut();
}
