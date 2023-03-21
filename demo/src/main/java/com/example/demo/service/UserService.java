package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();

    List<User> searchUsers(String pattern);
    User updateUser(User user,long id);

    void deleteUser(long id);

    void createUserInBatch(List<User> users);

    void deleteUsersByIds(List<Long> ids);

    void updateUsersByIds(List<Long> ids, User user);
}
