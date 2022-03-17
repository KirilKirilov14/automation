package com.example.automation.data.service.implementation;

import com.example.automation.data.entity.Log;
import com.example.automation.data.repository.LogRepository;
import com.example.automation.data.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogImplementation implements LogService {
    private final LogRepository logsRepository;

    public LogImplementation(LogRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    public LogRepository getLogsRepository() {
        return logsRepository;
    }

    @Override
    public List<Log> getLogService() {
        return logsRepository.findAll();
    }

    @Override
    public Log getLogService(int id) {
        return logsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id: " + id));
    }

    @Override
    public Log createLog(Log device) {
        return logsRepository.save(device);
    }

    @Override
    public Log updateLog(Log device, int id) {
        device.setLogId(id);

        return logsRepository.save(device);
    }

    @Override
    public void deleteLog(int id) {
        logsRepository.deleteById(id);
    }
}
