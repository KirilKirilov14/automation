package com.example.automation.data.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pc
 */
@Entity
@Table(name = "sensors")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s"),
        @NamedQuery(name = "Sensor.findBySensorId", query = "SELECT s FROM Sensor s WHERE s.sensorId = :sensorId")})


public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sensor_id")
    private Integer sensorId;

    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    @JsonIgnoreProperties("")
    @ManyToOne
    private Device deviceId;

    @JoinColumn(name = "sensor_type_id", referencedColumnName = "sensor_type_id")
    @JsonIgnoreProperties("")
    @ManyToOne(optional = false)
    private SensorType sensorTypeId;

    public Sensor() {
    }

    public Sensor(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Sensor(Integer sensorId, Device deviceId, SensorType sensorTypeId) {
        this.sensorId = sensorId;
        this.deviceId = deviceId;
        this.sensorTypeId = sensorTypeId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public SensorType getSensorType() {
        return sensorTypeId;
    }

    public void setSensorTypeId(SensorType sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorId != null ? sensorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.sensorId == null && other.sensorId != null) || (this.sensorId != null && !this.sensorId.equals(other.sensorId))) {
            return false;
        }
        return true;
    }


}
