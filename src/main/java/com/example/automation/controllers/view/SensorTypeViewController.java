package com.example.automation.controllers.view;

import com.example.automation.data.entity.SensorType;
import com.example.automation.data.service.SensorTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sensorTypeView")
public class SensorTypeViewController {
    private final SensorTypeService sensorTypeService;

    public SensorTypeViewController(SensorTypeService sensorTypeService) {
        this.sensorTypeService = sensorTypeService;
    }

    @GetMapping
    public String getSensorType(Model model) {
        final List<SensorType> sensorTypes = sensorTypeService.getSensorTypeService();
        model.addAttribute("sensorTypes", sensorTypes);
        return "/sensorType/sensorType";
    }

    @GetMapping("/edit/{id}")
    public String showEditSensorType(Model model, @PathVariable Integer id) {
        model.addAttribute("sensorType", sensorTypeService.getSensorTypeService(id));
        return "/sensorType/edit-sensorType";
    }

    @PostMapping("/update/{id}")
    public String updateSensorType(Model model, @PathVariable Integer id, SensorType sensorType) {
        sensorTypeService.updateSensorType(sensorType, id);
        return "redirect:/sensorTypeView";
    }

    @GetMapping("/add")
    public String showCreateSensorTypeForm(Model model) {
        SensorType sensorType=new SensorType();
        model.addAttribute("sensorType",sensorType);
        return "/sensorType/create-sensorType";
    }

    @PostMapping("/create")
    public String createSensorType(Model model, SensorType sensorType) {
        sensorTypeService.createSensorType(sensorType);
        return "redirect:/sensorTypeView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        sensorTypeService.deleteSensorTypeService(id);
        return "redirect:/sensorTypeView";
    }

}