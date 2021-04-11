package com.example.demo.controller;

import com.example.demo.entities.Users;
import com.example.demo.models.Authentication;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        return userService.createNewUser(user);
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<Authentication>  loginUser(@RequestBody Users user){
        return userService.login(user);
    }

    @RequestMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<Users>> listUser(){
        return userService.listUsers();
    }
}
