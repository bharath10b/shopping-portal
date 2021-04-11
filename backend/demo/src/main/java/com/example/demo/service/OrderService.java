package com.example.demo.service;

import com.example.demo.models.Cart;
import com.example.demo.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    JdbcTemplate jdbctemplate;

    public ResponseEntity<List<Order>> listOrders() {
        try {
            List<Order> orders = jdbctemplate.query("select * from ORDER ",
                    new BeanPropertyRowMapper(Order.class));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orders);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
