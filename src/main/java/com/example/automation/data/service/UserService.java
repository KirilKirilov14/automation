package com.example.automation.data.service;

import com.example.automation.data.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserService();
    User getUserService(int id);
    User createUser(User user);
    User updateUser(User user, int id);
    void deleteUser(int id);
}
