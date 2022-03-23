package com.example.automation.data.service;

import com.example.automation.data.entity.AutomationRule;


import java.util.List;

public interface AutomationRuleService {

    List<AutomationRule> getAutomationRuleService();
    AutomationRule getAutomationRuleService(int id);
    AutomationRule createAutomationRule(AutomationRule automationRule);
    AutomationRule updateAutomationRule(AutomationRule automationRule, int id);
    void deleteAutomationRuleService(int id);
}
