package com.example.automation.data.service.implementation;

import com.example.automation.data.repository.SensorRepository;
import com.example.automation.data.service.SensorService;
import com.example.automation.data.entity.Sensor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SensorImplementation implements SensorService {
    private final SensorRepository sensorsRepository;

    public SensorImplementation(SensorRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public SensorRepository getSensorsRepository() {
        return sensorsRepository;
    }

    @Override
    public List<Sensor> getSensors() {
        return sensorsRepository.findAll();
    }

    @Override
    public Sensor getSensorService(int id) {
        return sensorsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sensor id: " + id));
    }

    @Override
    public Sensor createSensor(Sensor device) {
        return sensorsRepository.save(device);
    }

    @Override
    public Sensor updateSensor(Sensor device, int id) {
        device.setSensorId(id);

        return sensorsRepository.save(device);
    }

    @Override
    public void deleteSensor(int id) {
        sensorsRepository.deleteById(id);
    }
}
