package com.example.automation.controllers.api;

import com.example.automation.data.entity.Device;
import com.example.automation.data.entity.Sensor;
import com.example.automation.data.entity.SensorDataPacket;
import com.example.automation.data.service.AutomationRuleService;
import com.example.automation.data.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/device")
public class DeviceApiController {



    private final DeviceService deviceService;

    @Autowired
    AutomationRuleService automationRuleService;

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

    // int httpCode = http.POST
    // ("{\"deviceKey\": \"device-kitchen\", sensorData: {\"temperature\": " + String(temp) + ",\"humidity\": " + String(hum) + "}, \"userid\": 1}");

    // 1. Structure
    // 2. deviceKey - unique element
    // 3. userid - unique element
    // 4. Type of Sensor - Humidity, Temperature, Soil, Water Leak, Motion... candidate for switch case / tip: const
    // 5. create a class


    @PostMapping(value = "/postSensorData")
    public void postSensorData(@RequestBody SensorDataPacket sensorDataPacket)  {
        System.out.println("POST SENSOR DATA INVOKED");
        System.out.println(sensorDataPacket);

        // SensorDataPacket{deviceKey='device-kitchen', userid=1, sensorValues={temperature=24.0, humidity=57.0}}
        Device device = this.deviceService.getDeviceService(sensorDataPacket.getUserid());
        List<Sensor> sensorList = device.getSensorList();
        System.out.println(sensorList);
        for (Sensor sensor : sensorList) {
            System.out.println("DB Sensor has Name: " + sensor.getSensorType().getSensorType());
            System.out.println("Packet Sensor has Name: " + Arrays.toString(sensorDataPacket.getSensorData().keySet().toArray(new Object[0])));
            if(sensorDataPacket.getSensorData().containsKey(sensor.getSensorType().getSensorType())){ // validation passed
                System.out.println("Validation passed");
                System.out.println("Checking for: " + sensor.getSensorType().getSensorDataType()); // float
                final String sensorDataType = sensor.getSensorType().getSensorDataType();
                if ("double".equals(sensorDataType)) {
                    System.out.println("Double found");
                    Double result = (Double) sensorDataPacket.getSensorData().get(sensor.getSensorType().getSensorType());
                    System.out.println("Result: " + result);
                    // getting automation rules
                    automationRuleService.processAutomation(sensor, result);
                }
            }
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteDevice(@PathVariable("id") int id) {
        deviceService.deleteDeviceService(id);
    }


}


