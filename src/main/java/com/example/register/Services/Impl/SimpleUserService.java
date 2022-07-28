package com.example.register.Services.Impl;

import com.example.register.Models.User;
import com.example.register.Repositories.UsersRepo;
import com.example.register.Services.Interf.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SimpleUserService implements UsersService {

    private final UsersRepo usersRepo;

    @Override
    public User addUser(User model) {
        return usersRepo.save(model);
    }

    @Override
    public void updateUser(User model) {
        usersRepo.save(model);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public void removeUser(int userId) {
        usersRepo.deleteById(userId);
    }

    @Override
    public User getUser(int userId) throws NoSuchElementException {
        return usersRepo.findById(userId).orElseThrow(NoSuchElementException::new);
    }
}
