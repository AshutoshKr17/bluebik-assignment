package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    //build create user rest api
    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    //build get all users rest api
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam("pattern") String pattern){
        return userService.searchUsers(pattern);
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity<User> updateUsers(@PathVariable("id") long id
                                    ,@RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted succesfully!", HttpStatus.OK);
    }

    //insert in batch
    @PostMapping("/batch")
    public List<User> createUserInBatch(@RequestBody List<User> users){
        userService.createUserInBatch(users);
        return userService.getAllUsers();
    }

    @PutMapping("/bulk/{ids}")
    public ResponseEntity<String> updateUserByIds(@PathVariable List<Long> ids, @RequestBody User user) {
        userService.updateUsersByIds(ids, user);
        return new ResponseEntity<String>("All User updated succesfully!", HttpStatus.OK);
    }

    @DeleteMapping("/bulk/{ids}")
    public ResponseEntity<String> deleteUserByIds(@PathVariable List<Long> ids) {
        userService.deleteUsersByIds(ids);
        return new ResponseEntity<String>("All User deleted succesfully!", HttpStatus.OK);
    }
}
