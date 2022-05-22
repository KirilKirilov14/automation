package com.example.automation.controllers.api;
import com.example.automation.data.entity.User;
import com.example.automation.data.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUserService();
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUserService(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/{id}") //@DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserService(id);
    }
}