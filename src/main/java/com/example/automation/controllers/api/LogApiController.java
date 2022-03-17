package com.example.automation.controllers.api;

import com.example.automation.data.entity.Log;

import com.example.automation.data.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/log")
public class LogApiController {
    private final LogService logService;


    public LogApiController(LogService logService) {
        this.logService = logService;
    }

    public LogService getLogService() {
        return logService;
    }

    @GetMapping
    public List<Log> getLog() {
        return logService.getLogService();
    }

    @RequestMapping("/{id}")
    public Log getLog(@PathVariable("id") int id) {
        return logService.getLogService(id);
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.createLog(log);
    }

    @PutMapping(value = "/{id}")
    public Log updateLog(@RequestBody Log log, @PathVariable("id") int id) {
        return logService.updateLog(log, id);
    }
  /*  /
**
    *
    *
    *
    *
    *
    /*/
    @DeleteMapping(value = "/delete/{id}")
    public void deleteLog(@PathVariable("id") int id) {
        logService.deleteLog(id);
    }
}
