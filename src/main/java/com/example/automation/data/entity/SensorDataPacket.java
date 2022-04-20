package com.example.automation.data.entity;

import java.util.Map;

public class SensorDataPacket {

    private String deviceKey;
    private Integer userid;
    private Map<String, Object> sensorData;

    public SensorDataPacket(String deviceKey, Integer userid, Map<String, Object> sensorData) {
        this.deviceKey = deviceKey;
        this.userid = userid;
        this.sensorData = sensorData;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Map<String, Object> getSensorData() {
        return sensorData;
    }

    public void setSensorData(Map<String, Object> sensorData) {
        this.sensorData = sensorData;
    }

    @Override
    public String toString() {
        return "SensorDataPacket{" +
                "deviceKey='" + deviceKey + '\'' +
                ", userid=" + userid +
                ", sensorValues=" + sensorData +
                '}';
    }
}

