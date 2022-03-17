package com.example.automation.data.entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "automation_rules")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "AutomationRule.findAll", query = "SELECT a FROM AutomationRule a"),
        @NamedQuery(name = "AutomationRule.findByAutomationRuleId", query = "SELECT a FROM AutomationRule a WHERE a.automationRuleId = :automationRuleId"),
        @NamedQuery(name = "AutomationRule.findBySensorMaxValueTrigger", query = "SELECT a FROM AutomationRule a WHERE a.sensorMaxValueTrigger = :sensorMaxValueTrigger"),
        @NamedQuery(name = "AutomationRule.findByMinTriggerEndpoint", query = "SELECT a FROM AutomationRule a WHERE a.minTriggerEndpoint = :minTriggerEndpoint"),
        @NamedQuery(name = "AutomationRule.findBySensorMinValueTrigger", query = "SELECT a FROM AutomationRule a WHERE a.sensorMinValueTrigger = :sensorMinValueTrigger"),
        @NamedQuery(name = "AutomationRule.findByMaxTriggerEndpoint", query = "SELECT a FROM AutomationRule a WHERE a.maxTriggerEndpoint = :maxTriggerEndpoint")})
public class AutomationRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "automation_rule_id")
    private Integer automationRuleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sensor_max_value_trigger")
    private String sensorMaxValueTrigger;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "min_trigger_endpoint")
    private String minTriggerEndpoint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sensor_min_value_trigger")
    private String sensorMinValueTrigger;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "max_trigger_endpoint")
    private String maxTriggerEndpoint;
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    @ManyToOne(optional = false)
    private Sensor sensorId;

    public AutomationRule() {
    }

    public AutomationRule(Integer automationRuleId) {
        this.automationRuleId = automationRuleId;
    }

    public AutomationRule(Integer automationRuleId, String sensorMaxValueTrigger, String minTriggerEndpoint, String sensorMinValueTrigger, String maxTriggerEndpoint) {
        this.automationRuleId = automationRuleId;
        this.sensorMaxValueTrigger = sensorMaxValueTrigger;
        this.minTriggerEndpoint = minTriggerEndpoint;
        this.sensorMinValueTrigger = sensorMinValueTrigger;
        this.maxTriggerEndpoint = maxTriggerEndpoint;
    }

    public Integer getAutomationRuleId() {
        return automationRuleId;
    }

    public void setAutomationRuleId(Integer automationRuleId) {
        this.automationRuleId = automationRuleId;
    }

    public String getSensorMaxValueTrigger() {
        return sensorMaxValueTrigger;
    }

    public void setSensorMaxValueTrigger(String sensorMaxValueTrigger) {
        this.sensorMaxValueTrigger = sensorMaxValueTrigger;
    }

    public String getMinTriggerEndpoint() {
        return minTriggerEndpoint;
    }

    public void setMinTriggerEndpoint(String minTriggerEndpoint) {
        this.minTriggerEndpoint = minTriggerEndpoint;
    }

    public String getSensorMinValueTrigger() {
        return sensorMinValueTrigger;
    }

    public void setSensorMinValueTrigger(String sensorMinValueTrigger) {
        this.sensorMinValueTrigger = sensorMinValueTrigger;
    }

    public String getMaxTriggerEndpoint() {
        return maxTriggerEndpoint;
    }

    public void setMaxTriggerEndpoint(String maxTriggerEndpoint) {
        this.maxTriggerEndpoint = maxTriggerEndpoint;
    }

    public Sensor getSensorId() {
        return sensorId;
    }

    public void setSensorId(Sensor sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (automationRuleId != null ? automationRuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutomationRule)) {
            return false;
        }
        AutomationRule other = (AutomationRule) object;
        if ((this.automationRuleId == null && other.automationRuleId != null) || (this.automationRuleId != null && !this.automationRuleId.equals(other.automationRuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.automation.data.AutomationRule[ automationRuleId=" + automationRuleId + " ]";
    }

}