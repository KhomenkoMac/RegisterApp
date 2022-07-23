package com.example.register.Repositories;

import com.example.register.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<User, Integer> {
}
