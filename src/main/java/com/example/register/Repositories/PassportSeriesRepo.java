package com.example.register.Repositories;

import com.example.register.Models.PassportSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportSeriesRepo extends JpaRepository<PassportSeries, Integer> {
}
