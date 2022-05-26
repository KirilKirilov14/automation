package com.example.automation.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "sensor_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sensor_data_id")
    private Integer sensorDataId;

    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sensor_value")
    private String sensorValue;

    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Sensor sensorId;

    public SensorData(){

    }

    public SensorData(Integer sensorDataId, String sensorValue, Sensor sensorId) {
        this.sensorDataId = sensorDataId;
        this.sensorValue = sensorValue;
        this.sensorId = sensorId;
    }

    public Integer getSensorDataId() {
        return sensorDataId;
    }

    public void setSensorDataId(Integer sensorDataId) {
        this.sensorDataId = sensorDataId;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Sensor getSensorId() {
        return sensorId;
    }

    public void setSensorId(Sensor sensorId) {
        this.sensorId = sensorId;
    }
}
