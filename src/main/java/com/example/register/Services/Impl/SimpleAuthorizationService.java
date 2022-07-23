package com.example.register.Services.Impl;

import com.example.register.Models.User;
import com.example.register.Repositories.UsersRepo;
import com.example.register.Services.Interf.AuthorizationService;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthorizationService implements AuthorizationService {
    private final UsersRepo usersRepo;

    public SimpleAuthorizationService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public User signIn(String email, String password) {
        return null;
    }

    @Override
    public User signUp(User user) {
        return null;
    }
}
