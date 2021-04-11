package com.example.demo.service;

import com.example.demo.entities.UserEntity;
import com.example.demo.entities.Users;
import com.example.demo.models.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    String token="vmdoplw12klm564";

    @Autowired
    UserEntity userEntityService;

    @Autowired
    JdbcTemplate jdbctemplate;

    public ResponseEntity<Users> createNewUser(Users user) {
        try {
            Users createdUser = userEntityService.save(user);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(createdUser);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Authentication> login(Users user) {

        Authentication auth = new Authentication();
        auth.setAuthenticated(false);

        try {
            Users userLogin = jdbctemplate.queryForObject("select * from users where username=? and password=?",
                    new Object[] { user.getUsername(), user.getPassword() },
                    new BeanPropertyRowMapper<Users>(Users.class));
            if(userLogin != null){
                auth.setAuthenticated(true);
                auth.setToken(token);
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(auth);
            }
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(auth);
        }
        catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(auth);
        }
    }

    public ResponseEntity<List<Users>> listUsers() {
        try {
            List<Users> users = new ArrayList<Users>();
            userEntityService.findAll().forEach(user -> users.add(user));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(users);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
