package com.example.register.Services.Interf;

import com.example.register.Models.User;

public interface AuthorizationService {
    User signIn(String email, String password);
    User signUp(User user);
}
