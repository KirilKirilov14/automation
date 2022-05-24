package com.example.automation.controllers.api;

import com.example.automation.data.entity.Device;
import com.example.automation.data.entity.Sensor;
import com.example.automation.data.entity.SensorData;
import com.example.automation.data.model.SensorDataPacket;
import com.example.automation.data.repository.DeviceRepository;
import com.example.automation.data.repository.SensorDataRepository;
import com.example.automation.data.service.AutomationRuleService;
import com.example.automation.data.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/device")
public class DeviceApiController {

    private final DeviceService deviceService;

    @Autowired
    SensorDataRepository sensorDataRepository;

    @Autowired
    AutomationRuleService automationRuleService;

    @Autowired
    DeviceRepository deviceRepository;

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
    // ("{\"deviceName\": \"device-kitchen\", sensorData: {\"temperature\": " + String(temp) + ",\"humidity\": " + String(hum) + "}, \"userid\": 1}");

    // 1. Structure
    // 2. deviceName - unique element
    // 3. userid - unique element
    // 4. Type of Sensor - Humidity, Temperature, Soil, Water Leak, Motion... candidate for switch case / tip: const
    // 5. create a class


    @PostMapping(value = "/postSensorData")
    public void postSensorData(@RequestBody SensorDataPacket sensorDataPacket)  {
        System.out.println("////////////////"+ sensorDataPacket);
        storeSensorData(sensorDataPacket);
        //System.out.println("POST SENSOR DATA INVOKED");
        System.out.println(sensorDataPacket);

        // SensorDataPacket{deviceName='device-kitchen', userid=1, sensorValues={temperature=24.0, humidity=57.0}}
        Device device = this.deviceService.getDeviceService(sensorDataPacket.getUserid());
        List<Sensor> sensorList = device.getSensorList();
        System.out.println(sensorList);
        for (Sensor sensor : sensorList) {
            System.out.println("DB Sensor has Name: " + sensor.getSensorType().getSensorType());
           // System.out.println("Packet Sensor has Name: " + Arrays.toString(sensorDataPacket.getSensorData().keySet().toArray(new Object[0])));
            if(sensorDataPacket.getSensorData().containsKey(sensor.getSensorType().getSensorType())){ // validation passed
                //System.out.println("Validation passed");
               // System.out.println("Checking for: " + sensor.getSensorType().getSensorDataType()); // float
                final String sensorDataType = sensor.getSensorType().getSensorDataType();
                if ("double".equals(sensorDataType)) {
                  // System.out.println("Double found");
                    Double result = (Double) sensorDataPacket.getSensorData().get(sensor.getSensorType().getSensorType());
                    System.out.println("Result: " + result);
                    // getting automation rules
                    automationRuleService.processAutomation(sensor, result);
                }
            }
        }

    }

    private void storeSensorData(SensorDataPacket sensorDataPacket) {
    String deviceName = sensorDataPacket.getDeviceKey();
    System.out.println("*********************** " + deviceName);
    Device device = deviceRepository.findByDeviceName(deviceName);
    List<Sensor> sensorList = device.getSensorList();
    for(Sensor sensor:sensorList){
        if(sensorDataPacket.getSensorData().get(sensor.getSensorType().getSensorType())!=null){

            SensorData sensorData = new SensorData();
            sensorData.setSensorId(sensor);
            sensorData.setSensorValue(""+(sensorDataPacket.getSensorData().get(sensor.getSensorType().getSensorType())));
            sensorDataRepository.save(sensorData);
        }
    }
}
//TODO-if not working, needs to do in sensor repository to find all sensor by device id, to return a list of sensors, 102line
    //TODO raspberry postgress, java,
    //TODO in pgadmin to connect to raspberry
    //TODO to restore the DB
    //TODO to configure the ips in application.properties
    // in d1 mini ip needs to point to raspberry
    //to transfer the project
    //to download mvn , mvn clean install
    //start on raspberry


    @DeleteMapping(value = "/delete/{id}")
    public void deleteDevice(@PathVariable("id") int id) {
        deviceService.deleteDeviceService(id);
    }


}


