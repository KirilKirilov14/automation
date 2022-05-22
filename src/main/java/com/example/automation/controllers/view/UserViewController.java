package com.example.automation.controllers.view;

import com.example.automation.data.entity.User;
import com.example.automation.data.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userView")
public class UserViewController {
    private final UserService userService;

    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(Model model) {
        final List<User> users = userService.getUserService();
        model.addAttribute("users", users);
        return "/user/user";
    }

    @GetMapping("/edit/{id}")
    public String showEditUser(Model model, @PathVariable Integer id) {
        model.addAttribute("user", userService.getUserService(id));
        return "/user/edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable Integer id, User user) {
        userService.updateUser(user, id);
        return "redirect:/userView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        userService.deleteUserService(id);
        return "redirect:/userView";
    }

}