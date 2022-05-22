package com.example.automation.controllers.view;

import com.example.automation.data.entity.Sensor;
import com.example.automation.data.entity.User;
import com.example.automation.data.service.SensorService;
import com.example.automation.data.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sensorView")
public class SensorViewController {
    private final SensorService sensorService;

    public SensorViewController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public String getSensor(Model model) {
        final List<Sensor> sensors = sensorService.getSensorService();
        model.addAttribute("sensors", sensors);
        return "/sensor/sensor";
    }

    @GetMapping("/edit/{id}")
    public String showEditSensor(Model model, @PathVariable Integer id) {
        model.addAttribute("sensor", sensorService.getSensorService(id));
        return "/sensor/edit-sensor";
    }

    @PostMapping("/update/{id}")
    public String updateSensor(Model model, @PathVariable Integer id, Sensor sensor) {
        sensorService.updateSensor(sensor, id);
        return "redirect:/sensorView";
    }

    @GetMapping("/add")
    public String showCreateSensorForm(Model model) {
        Sensor sensor=new Sensor();
        model.addAttribute("sensor",sensor);
        return "/sensor/create-sensor";
    }

    @PostMapping("/create")
    public String createSensor(Model model, Sensor sensor) {
        sensorService.createSensor(sensor);
        return "redirect:/sensorView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        sensorService.deleteSensorService(id);
        return "redirect:/sensorView";
    }

}