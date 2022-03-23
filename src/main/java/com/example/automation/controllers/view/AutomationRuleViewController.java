package com.example.automation.controllers.view;

import com.example.automation.data.entity.AutomationRule;
import com.example.automation.data.entity.Sensor;
import com.example.automation.data.service.AutomationRuleService;
import com.example.automation.data.service.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/automationRuleView")
public class AutomationRuleViewController {
    private final AutomationRuleService automationRuleService;
    private final SensorService sensorService;


    public AutomationRuleViewController(AutomationRuleService automationRuleService, SensorService sensorService) {
        this.automationRuleService = automationRuleService;
        this.sensorService = sensorService;
    }

    @GetMapping
    public String getAutomationRule(Model model) {
        final List<AutomationRule> automationRules = automationRuleService.getAutomationRuleService();
        model.addAttribute("automationRules", automationRules);
        return "/automationRule/automationRule";
    }

    @GetMapping("/edit/{id}")
    public String showEditAutomationRule(Model model, @PathVariable Integer id) {
        model.addAttribute("automationRule", automationRuleService.getAutomationRuleService(id));
        return "/automationRule/edit-automationRule";
    }

    @PostMapping("/update/{id}")
    public String updateAutomationRule(Model model, @PathVariable Integer id, AutomationRule automationRule) {
        automationRuleService.updateAutomationRule(automationRule, id);
        return "redirect:/automationRuleView";
    }
    @GetMapping("/add")
    public String showCreateAutomationRuleForm(Model model) {
        AutomationRule automationRule=new AutomationRule();
        model.addAttribute("automationRule",automationRule);
        model.addAttribute("sensors",sensorService.getSensors());
        return "/automationRule/create-automationRule";
    }

    @PostMapping("/create")
    public String createAutomationRule(Model model, AutomationRule automationRule) {
        System.out.println("Creating automation rule" + " " +automationRule);
        automationRuleService.createAutomationRule(automationRule);
        return "redirect:/automationRuleView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        automationRuleService.deleteAutomationRuleService(id);
        return "redirect:/automationRuleView";
    }
}