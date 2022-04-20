package com.example.automation.data.service.implementation;
import SpringHttpClient.RestClient;
import com.example.automation.data.entity.AutomationRule;
import com.example.automation.data.entity.Sensor;
import com.example.automation.data.entity.SensorDataPacket;
import com.example.automation.data.repository.AutomationRuleRepository;
import com.example.automation.data.service.AutomationRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AutomationRuleImplementation implements AutomationRuleService {
private final AutomationRuleRepository automationRuleRepository;


    private RestClient restClient;

    @PostConstruct
    public void init(){
        restClient = new RestClient();
    }


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
    public AutomationRule updateAutomationRule(AutomationRule automationRule, int id) {

     automationRule.setAutomationRuleId(id);
     return automationRuleRepository.save(automationRule);
    }

    @Override
    public void deleteAutomationRuleService(int id) {
            automationRuleRepository.deleteById(id);
    }

    @Override
    public void processAutomation(Sensor sensor, Object dataValue) {
        processAutomation(sensor, (Double) dataValue);
    }

    public void processAutomation(Sensor sensor, Double dataValue){
        List<AutomationRule> all = automationRuleRepository.findAll(); // TODO create query to find only the active one
        for(AutomationRule rule : all) {
            System.out.println("Automation Rule Active: " + rule.getAutomationRuleActive());
            if(rule.getAutomationRuleActive() && rule.getSensorId().getSensorId().equals(sensor.getSensorId())){
                System.out.println("Found the valid Automation Rule, start processing...");
                validateAndTrigger(rule, dataValue);
                break;
            }
        }
    }

    private void validateAndTrigger(AutomationRule rule, Double dataValue) {
        if(dataValue >= Double.valueOf(rule.getSensorMaxValueTrigger())){
            System.out.println("Max Trigger reached... calling target endpoint: "+ rule.getMaxTriggerEndpoint()); // http://192.168.0.50/TOOGLE:OFF
            String s = restClient.get(rule.getMaxTriggerEndpoint());
            System.out.println("Result from Max Triggered Endpoint: " + s);
        } else if (dataValue <= Double.valueOf(rule.getSensorMinValueTrigger())){
            System.out.println("Min Trigger reached... calling target endpoint: " +rule.getMinTriggerEndpoint() ); // http://192.168.0.50/TOOGLE:ON
            String s = restClient.get(rule.getMinTriggerEndpoint());
            System.out.println("Result from Min Triggered Endpoint: " + s);
        } else {
            System.out.println("No trigger reached, will not process any endpoint. " +
                    "Value in normal range: " + rule.getSensorMinValueTrigger()+ " <= " + dataValue + " <= " + rule.getSensorMaxValueTrigger());
        }

    }

}
