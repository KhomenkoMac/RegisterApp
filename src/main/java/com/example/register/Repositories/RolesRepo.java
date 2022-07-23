package com.example.register.Repositories;

import com.example.register.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo extends JpaRepository<Role, Integer> {
}
