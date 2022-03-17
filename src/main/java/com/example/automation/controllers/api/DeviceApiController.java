package com.example.automation.controllers.api;

import com.example.automation.data.entity.Device;
import com.example.automation.data.service.DeviceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceApiController {
    private final DeviceService deviceService;

    public DeviceApiController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public DeviceService getDeviceService() {
        return deviceService;
    }

    @GetMapping
    public List<Device> getDevice() {
        return deviceService.getDeviceService();
    }

    @RequestMapping("/{id}")
    public Device getDevice(@PathVariable("id") int id) {
        return deviceService.getDeviceService(id);
    }

    @PostMapping
    public Device createDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);

    }


    @PutMapping(value = "/{id}")
    public Device updateDevice(@RequestBody Device device, @PathVariable("id") int id) {
        return deviceService.updateDevice(device, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteDevice(@PathVariable("id") int id) {
        deviceService.deleteDeviceService(id);
    }
}
