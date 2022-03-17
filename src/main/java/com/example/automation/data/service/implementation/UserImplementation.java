package com.example.automation.data.service.implementation;

import com.example.automation.data.repository.UserRepository;
import com.example.automation.data.service.UserService;
import com.example.automation.data.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImplementation implements UserService {
    private final UserRepository usersRepository;

    public UserImplementation(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserRepository getSensorsTypeRepository() {
        return usersRepository;
    }

    @Override
    public List<User> getUserService() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserService(int id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
    }

    @Override
    public User createUser(User device) {
        return usersRepository.save(device);
    }

    @Override
    public User updateUser(User device, int id) {
        device.setUserId(id);

        return usersRepository.save(device);
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }
}
