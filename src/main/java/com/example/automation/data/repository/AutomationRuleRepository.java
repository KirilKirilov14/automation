package com.example.automation.data.repository;
import com.example.automation.data.entity.AutomationRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomationRuleRepository extends JpaRepository<AutomationRule, Integer> {
}
