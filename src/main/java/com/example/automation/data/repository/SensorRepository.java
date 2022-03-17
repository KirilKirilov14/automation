package com.example.automation.data.repository;

import com.example.automation.data.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor,Integer> {
}
