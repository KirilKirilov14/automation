package com.example.automation.controllers.view;


import com.example.automation.data.entity.SensorData;
import com.example.automation.data.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/sensorDataView")
public class SensorDataViewController {
    @Autowired
    SensorDataService sensorDataService;
    @GetMapping
    public String getAll(Model model) {
        final List<SensorData> sensorData = sensorDataService.getAll();
        model.addAttribute("sensorData", sensorData);
//        return "/sensorData/sensor-data";
        return "/sensorData/sensorData";
    }


}
