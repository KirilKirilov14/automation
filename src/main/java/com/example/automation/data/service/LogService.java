package com.example.automation.data.service;

import com.example.automation.data.entity.Log;

import java.util.List;

public interface LogService {

        List<Log> getLogService();
        Log getLogService(int id);
        Log createLog(Log log);
        Log updateLog(Log log, int id);
        void deleteLog(int id);

}
