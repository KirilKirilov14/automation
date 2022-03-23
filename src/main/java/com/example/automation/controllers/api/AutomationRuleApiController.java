package com.example.automation.controllers.api;

import com.example.automation.data.entity.AutomationRule;
import com.example.automation.data.service.AutomationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/automationRule")
public class AutomationRuleApiController {
private final AutomationRuleService automationRuleService;

    public AutomationRuleApiController(AutomationRuleService automationRuleService) {
        this.automationRuleService = automationRuleService;
    }

    public AutomationRuleService getAutomationRuleService() {
            return automationRuleService;
        }

        @GetMapping
        public List<AutomationRule> getAutomationRule() {
            return automationRuleService.getAutomationRuleService();
        }

        @RequestMapping("/{id}")
        public AutomationRule getAutomationRule(@PathVariable("id") int id) {
            return automationRuleService.getAutomationRuleService(id);
        }

        @PostMapping
        public AutomationRule createAutomationRule(@RequestBody AutomationRule automationRule) {
            System.out.println(automationRule);
            return automationRuleService.createAutomationRule(automationRule);
        }


        @PutMapping(value = "/{id}")
        public AutomationRule updateAutomationRule(@RequestBody AutomationRule automationRule, @PathVariable("id") int id) {
            return automationRuleService.updateAutomationRule(automationRule, id);
        }

        @DeleteMapping(value = "/delete/{id}")
        public void deleteAutomationRule(@PathVariable("id") int id) {
            automationRuleService.deleteAutomationRuleService(id);
        }
    }


