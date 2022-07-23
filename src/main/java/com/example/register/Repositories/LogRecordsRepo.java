package com.example.register.Repositories;

import com.example.register.Models.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRecordsRepo extends JpaRepository<LogRecord, Integer> {
}
