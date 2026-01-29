package com.example.registerform.service;

import com.example.registerform.entity.User;

import java.util.List;

public interface IUserService {
    boolean addNewUser(User user);
    List<User> findAll();
    boolean deleteUserById(Long id);
    boolean updateUser(Long id, String firstName, String lastName, String phoneNumber, int age, String email);
    User findUserById(Long id);
}
