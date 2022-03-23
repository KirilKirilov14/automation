package com.example.automation.data.service.implementation;
import com.example.automation.data.entity.AutomationRule;
import com.example.automation.data.repository.AutomationRuleRepository;
import com.example.automation.data.service.AutomationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutomationRuleImplementation implements AutomationRuleService {
private final AutomationRuleRepository automationRuleRepository;

    public AutomationRuleImplementation(AutomationRuleRepository automationRuleRepository) {
        this.automationRuleRepository = automationRuleRepository;
    }

    @Override
    public List<AutomationRule> getAutomationRuleService() {
        return automationRuleRepository.findAll();
    }

    @Override
    public AutomationRule getAutomationRuleService(int id) {
        return automationRuleRepository.findById(id)
                        .orElseThrow(()->new IllegalArgumentException("Invalid automationRule id " + id));
    }

    @Override
    public AutomationRule createAutomationRule(AutomationRule automationRule) {
        return automationRuleRepository.save(automationRule);
    }

    @Override
    public AutomationRule updateAutomationRule(AutomationRule automationRules, int id) {
        return null;
    }

    @Override
    public void deleteAutomationRuleService(int id) {

    }


}