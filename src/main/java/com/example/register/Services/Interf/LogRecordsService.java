package com.example.register.Services.Interf;

import com.example.register.Models.LogRecord;

import java.util.Set;

public interface LogRecordsService {
    void makeLogRecord(LogRecord model);
    Set<LogRecord> getAllRecords();
}
