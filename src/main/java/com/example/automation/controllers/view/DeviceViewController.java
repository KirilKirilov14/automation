package com.example.automation.controllers.view;

import com.example.automation.data.entity.Device;
import com.example.automation.data.entity.User;
import com.example.automation.data.service.DeviceService;
import com.example.automation.data.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deviceView")
public class DeviceViewController {
    private final DeviceService deviceService;
    private final UserService userService;

    public DeviceViewController(DeviceService deviceService, UserService userService) {
        this.deviceService = deviceService;
        this.userService = userService;
    }

    @GetMapping
    public String getDevice(Model model) {
        final List<Device> devices = deviceService.getDeviceService();
        model.addAttribute("devices", devices);
        return "/device/device";
    }

    @GetMapping("/edit/{id}")
    public String showEditDevice(Model model, @PathVariable Integer id) {
        model.addAttribute("device", deviceService.getDeviceService(id));
        return "/device/edit-device";
    }

    @PostMapping("/update/{id}")
    public String updateDevice(Model model, @PathVariable Integer id, Device device) {
        deviceService.updateDevice(device, id);
        return "redirect:/deviceView";
    }
    @GetMapping("/add")
    public String showCreateDeviceForm(Model model) {
         Device device=new Device();
        model.addAttribute("device",device);
        return "/device/create-device";
    }

    @PostMapping("/create")
    public String createDevice(Model model, Device device) {
        User userId=userService.getUserService(1);
        device.setUserId(userId);
        deviceService.createDevice(device);
        return "redirect:/deviceView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        deviceService.deleteDeviceService(id);
        return "redirect:/deviceView";
    }

}