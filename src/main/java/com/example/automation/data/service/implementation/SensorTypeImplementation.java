package com.example.automation.data.service.implementation;

import com.example.automation.data.repository.SensorTypeRepository;
import com.example.automation.data.service.SensorTypeService;
import com.example.automation.data.entity.SensorType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SensorTypeImplementation implements SensorTypeService {
    private final SensorTypeRepository sensorsTypeRepository;

    public SensorTypeImplementation(SensorTypeRepository sensorsTypeRepository) {
        this.sensorsTypeRepository = sensorsTypeRepository;
    }

    public SensorTypeRepository getSensorsTypeRepository() {
        return sensorsTypeRepository;
    }

    @Override
    public List<SensorType> getSensorTypeService() {
        return sensorsTypeRepository.findAll();
    }

    @Override
    public SensorType getSensorTypeService(int id) {
        return sensorsTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sensorType id: " + id));
    }

    @Override
    public SensorType createSensorType(SensorType device) {
        return sensorsTypeRepository.save(device);
    }

    @Override
    public SensorType updateSensorType(SensorType device, int id) {
        device.setSensorTypeId(id);

        return sensorsTypeRepository.save(device);
    }

    @Override
    public void deleteSensorType(int id) {
        sensorsTypeRepository.deleteById(id);
    }
}
