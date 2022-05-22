package com.example.automation.controllers.view;

import com.example.automation.data.entity.Log;
import com.example.automation.data.entity.User;
import com.example.automation.data.service.LogService;
import com.example.automation.data.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/logView")
public class LogViewController {
    private final LogService logService;
    private final UserService userService;

    public LogViewController(LogService logService, UserService userService) {
        this.logService = logService;
        this.userService = userService;
    }

    @GetMapping
    public String getLog(Model model) {
        final List<Log> logs = logService.getLogService();
        model.addAttribute("logs", logs);
        return "/log/log";
    }

    @GetMapping("/edit/{id}")
    public String showEditLog(Model model, @PathVariable Integer id) {
        model.addAttribute("log", logService.getLogService(id));
        return "/log/edit-log";
    }

    @PostMapping("/update/{id}")
    public String updateLog(Model model, @PathVariable Integer id, Log log) {
        logService.updateLog(log, id);
        return "redirect:/logView";
    }

    @GetMapping("/add")
    public String showCreateLogForm(Model model) {
        Log log = new Log();
        model.addAttribute("log", log);
        return "/log/create-log";
    }
       /* @GetMapping("/add")
        public String showCreateAutomationRuleForm(Model model) {
            Log log=new Log();
            model.addAttribute("log",log);

            return "/log/create-log";
        }*/

    @PostMapping("/create")
    public String createLog(Model model, Log log) {
        User userId = userService.getUserService(1);
        log.setUserId(userId);
        logService.createLog(log);
        return "redirect:/logView";
    }

    //    @PostMapping("/create")
    //    public String createAutomationRule(Model model, AutomationRule automationRule) {
    //        System.out.println("Creating automation rule" + " " +automationRule);
    //        automationRuleService.createAutomationRule(automationRule);
    //        return "redirect:/automationRuleView";
    //    }//

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        logService.deleteLogService(id);
        return "redirect:/logView";
    }

}