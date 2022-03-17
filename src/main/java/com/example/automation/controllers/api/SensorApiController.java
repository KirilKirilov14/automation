package com.example.automation.controllers.api;

import com.example.automation.data.entity.Sensor;
import com.example.automation.data.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/sensor")
public class SensorApiController {
    private final SensorService sensorService;

    public SensorApiController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    public SensorService getSensorService() {
        return sensorService;
    }

    @GetMapping
    public List<Sensor> getSensor() {
        return sensorService.getSensorService();
    }

    @RequestMapping("/{id}")
    public Sensor getSensor(@PathVariable("id") int id) {
        return sensorService.getSensorService(id);
    }

    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorService.createSensor(sensor);
    }

    @PutMapping(value = "/{id}")
    public Sensor updateSensor(@RequestBody Sensor sensor, @PathVariable("id") int id) {
        return sensorService.updateSensor(sensor, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteSensor(@PathVariable("id") int id) {
        sensorService.deleteSensor(id);
    }
}
