package com.example.demo.service.Impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> searchUsers(String pattern) {
        return userRepository.findByfirstNameStartingWith(pattern);
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","Id", id)
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setGender(user.getGender());
        existingUser.setCreation_date(user.getCreation_date());
        existingUser.setMobNumber(user.getMobNumber());

        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","id",id));
        userRepository.deleteById(id);
    }

    @Override
    public void createUserInBatch(List<User> users) {
        List<User> newUsers = new ArrayList<>();
        for(User user: users){
            User temp = new User();
            temp.setFirstName(user.getFirstName());
            temp.setLastName(user.getLastName());
            temp.setEmail(user.getEmail());
            temp.setGender(user.getGender());
            temp.setCreation_date(user.getCreation_date());
            temp.setMobNumber(user.getMobNumber());

            newUsers.add(temp);
        }
        userRepository.saveAll(newUsers);
    }

    @Override
    public void deleteUsersByIds(List<Long> ids) {
        for(Long id : ids){
            Optional<User> user = userRepository.findById(id);
            if(user.isPresent()) {
                continue;
            } else {
                throw new ResourceNotFoundException("User","id",id);
            }
        }
        userRepository.deleteAllById(ids);
    }

    @Override
    public void updateUsersByIds(List<Long> ids, User user) {
        for(Long id : ids){
            userRepository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException("User","id",id));
        }
        List<User> users = userRepository.findAllById(ids);
        for (User u : users) {
            u.setFirstName(user.getFirstName());
            u.setEmail(user.getEmail());
        }
        userRepository.saveAll(users);
    }
}
