package com.example.automation.data.service.implementation;

import com.example.automation.data.entity.Device;
import com.example.automation.data.repository.DeviceRepository;
import com.example.automation.data.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceImplementation implements DeviceService {
    private final DeviceRepository devicesRepository;

    public DeviceImplementation(DeviceRepository devicesRepository) {
        this.devicesRepository = devicesRepository;
    }

    public DeviceRepository getDevicesRepository() {
        return devicesRepository;
    }

    @Override
    public List<Device> getDeviceService() {
        return devicesRepository.findAll();
    }

    @Override
    public Device getDeviceService(int id) {
        return devicesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid device id: " + id));
    }

    @Override
    public Device createDevice(Device device) {
        return devicesRepository.save(device);
    }

    @Override
    public Device updateDevice(Device device, int id) {
        device.setDeviceId(id);
        return devicesRepository.save(device);
    }

    @Override
    public void deleteDeviceService(int id) {
        devicesRepository.deleteById(id);
    }

    public void processDBData(){

    }

}
