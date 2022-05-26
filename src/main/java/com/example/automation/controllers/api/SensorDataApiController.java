package com.example.automation.controllers.api;


import com.example.automation.data.entity.SensorData;
import com.example.automation.data.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class SensorDataApiController {
    @Autowired
    SensorDataService sensorDataService;
    @GetMapping
    public String getAll(Model model) {
        final List<SensorData> sensorData = sensorDataService.getAll();
        model.addAttribute("sensorData", sensorData);
       /* return "/sensorData/sensor-data";*/
         return "/sensorData/sensorData";
    }


}
