package com.example.automation.data.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author pc
 */
@Entity
@Table(name = "sensors_types")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "SensorType.findAll", query = "SELECT s FROM SensorType s"),
        @NamedQuery(name = "SensorType.findBySensorTypeId", query = "SELECT s FROM SensorType s WHERE s.sensorTypeId = :sensorTypeId"),
        @NamedQuery(name = "SensorType.findBySensorType", query = "SELECT s FROM SensorType s WHERE s.sensorType = :sensorType"),
        @NamedQuery(name = "SensorType.findBySensorDataType", query = "SELECT s FROM SensorType s WHERE s.sensorDataType = :sensorDataType")})
public class SensorType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sensor_type_id")
    private Integer sensorTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sensor_type")
    private String sensorType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sensor_data_type")
    private String sensorDataType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensorTypeId")
    @JsonIgnore
    private List<Sensor> sensorList;

    public SensorType() {
    }

    public SensorType(Integer sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public SensorType(Integer sensorTypeId, String sensorType, String sensorDataType) {
        this.sensorTypeId = sensorTypeId;
        this.sensorType = sensorType;
        this.sensorDataType = sensorDataType;
    }

    public Integer getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(Integer sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }


    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorDataType() {
        return sensorDataType;
    }

    public void setSensorDataType(String sensorDataType) {
        this.sensorDataType = sensorDataType;
    }
    //@XmlTransient
    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorTypeId != null ? sensorTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorType)) {
            return false;
        }
        SensorType other = (SensorType) object;
        if ((this.sensorTypeId == null && other.sensorTypeId != null) || (this.sensorTypeId != null && !this.sensorTypeId.equals(other.sensorTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.automation.data.SensorType[ sensorTypeId=" + sensorTypeId + " ]";
    }

}