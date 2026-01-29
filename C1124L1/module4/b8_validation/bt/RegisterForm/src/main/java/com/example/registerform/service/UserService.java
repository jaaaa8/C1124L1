package com.example.registerform.service;

import com.example.registerform.entity.User;
import com.example.registerform.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addNewUser(User user) {
        if (user == null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.deleteById(id);
            return true;
        }
        System.err.println("NOT FOUND USER ID: " + id);
        return false;
    }

    @Override
    public boolean updateUser(Long id, String firstName, String lastName, String phoneNumber, int age, String email) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            System.err.println("NOT FOUND USER ID: " + id);
            return false;
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setAge(age);
        user.setEmail(email);
        userRepository.save(user);
        return true;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
