package com.example.automation.data.repository;

import com.example.automation.data.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorTypeRepository extends JpaRepository<SensorType, Integer> {
}
