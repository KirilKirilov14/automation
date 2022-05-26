package com.example.automation.data.service.implementation;

import com.example.automation.data.entity.SensorData;
import com.example.automation.data.repository.SensorDataRepository;
import com.example.automation.data.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SensorDataImplementation implements SensorDataService {
    @Autowired
    SensorDataRepository sensorDataRepository;
    @Override
    public List<SensorData> getAll() {
        return sensorDataRepository.findAll();
    }
}
