package com.example.automation.data.service;

import com.example.automation.data.entity.AutomationRule;


import java.util.List;

public interface AutomationRuleService {
    List<AutomationRule> getAutomationRulesService();
    AutomationRule getAutomationRulesService(int id);

    List<AutomationRule> getAutomationRuleService();

    AutomationRule getAutomationRuleService(int id);

    AutomationRule createAutomationRules(AutomationRule automationRules);

    AutomationRule createAutomationRule(AutomationRule automationRules);

    AutomationRule updateAutomationRules(AutomationRule automationRules, int id);

    AutomationRule updateAutomationRule(AutomationRule automationRules, int id);

    void deleteAutomationRules(int id);

    void deleteAutomationRule(int id);
}
