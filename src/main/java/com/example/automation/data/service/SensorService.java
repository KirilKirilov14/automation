package com.example.automation.data.service;

import com.example.automation.data.entity.Sensor;

import java.util.List;

public interface SensorService {
    List<Sensor> getSensors();
    Sensor getSensorService(int id);
    Sensor createSensor(Sensor sensor);
    Sensor updateSensor(Sensor sensor, int id);
    void deleteSensor(int id);

}
