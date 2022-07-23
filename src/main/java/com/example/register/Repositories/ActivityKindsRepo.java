package com.example.register.Repositories;

import com.example.register.Models.ActivityKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityKindsRepo extends JpaRepository<ActivityKind, Integer> {
}
