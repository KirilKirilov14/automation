package com.example.automation.data.service;

import com.example.automation.data.entity.Device;

import java.util.List;

public interface DeviceService {
    List<Device> getDeviceService();
    Device getDeviceService(int id);
    Device createDevice(Device device);
    Device updateDevice(Device device, int id);
    void deleteDeviceService(int id);
}
