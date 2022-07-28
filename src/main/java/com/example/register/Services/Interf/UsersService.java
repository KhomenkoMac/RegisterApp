package com.example.register.Services.Interf;

import com.example.register.Models.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public interface UsersService {
    User addUser(User model);
    void updateUser(User model);
    List<User> getAllUsers();
    void removeUser(int userId);
    User getUser(int userId) throws NoSuchElementException;
}
