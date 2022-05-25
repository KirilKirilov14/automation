package com.example.automation.data.service;

import com.example.automation.data.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {

    List<User> getUserService();
    User getUserService(int id);
    User createUser(User user);
    User updateUser(User user, int id);
    void deleteUserService(int id);
}
