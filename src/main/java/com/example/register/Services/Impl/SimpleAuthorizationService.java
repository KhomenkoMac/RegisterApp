package com.example.register.Services.Impl;

import com.example.register.Exceptions.AuthenticationFailedException;
import com.example.register.Models.User;
import com.example.register.Repositories.UsersRepo;
import com.example.register.Services.Interf.AuthorizationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class SimpleAuthorizationService implements AuthorizationService {
    private User currentUser;

    private final UsersRepo usersRepo;

    public SimpleAuthorizationService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public User signIn(String email, String password) throws NoSuchElementException, AuthenticationFailedException {
        var foundUser = usersRepo.findAll().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        if (foundUser.getPassword().equals(password)) {
            currentUser = foundUser;
            return this.getCurrentUser();
        }
        else{
            throw new AuthenticationFailedException();
        }
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void signOut() {
        currentUser = null;
    }

    @Override
    public boolean isAdmin() {
        return getCurrentUser().getRole().getId() == 1;
    }

    @Override
    public boolean isRegistrator() {
        return getCurrentUser().getRole().getId() == 2;
    }

    @Override
    public boolean isUnregistered() {
        return getCurrentUser() == null;
    }
}



