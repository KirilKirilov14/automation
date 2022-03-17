package com.example.automation.controllers.api;

import com.example.automation.data.entity.SensorType;
import com.example.automation.data.service.SensorTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/sensor-type")
public class SensorTypeApiController {
    private final SensorTypeService sensorTypeService;

    public SensorTypeApiController(SensorTypeService sensorTypeService) {
        this.sensorTypeService = sensorTypeService;
    }

    public SensorTypeService getSensorTypeService() {
        return sensorTypeService;
    }

    @GetMapping
    public List<SensorType> getSensorType() {
        return sensorTypeService.getSensorTypeService();
    }

    @RequestMapping("/{id}")
    public SensorType getSensorType(@PathVariable("id") int id) {
        return sensorTypeService.getSensorTypeService(id);
    }

    @PostMapping
    public SensorType createSensorType(@RequestBody SensorType sensorType) {
        return sensorTypeService.createSensorType(sensorType);
    }

    @PutMapping(value = "/{id}")
    public SensorType updateSensorType(@RequestBody SensorType sensorType, @PathVariable("id") int id) {
        return sensorTypeService.updateSensorType(sensorType, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteSensorType(@PathVariable("id") int id) {
        sensorTypeService.deleteSensorType(id);
    }
}
