package com.example.register.Repositories;

import com.example.register.Models.OwnershipType;
import com.example.register.Models.PassportData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportDatasRepo extends JpaRepository<PassportData, Integer> {
}
