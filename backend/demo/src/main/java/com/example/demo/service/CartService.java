package com.example.demo.service;

import com.example.demo.models.Cart;
import com.example.demo.models.Item;
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
public class CartService {

    @Autowired
    JdbcTemplate jdbctemplate;

    public ResponseEntity<String> addCart(Item item) {
        try {
            int itemcreated = jdbctemplate.update(
                    "INSERT INTO CARTS (name) VALUES (?)",
                    item.getName()
            );
            if(itemcreated != -1){
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("created");
            } else {
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("not created");
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> completeCart(Order order) {
        try {
            int itemcreated = jdbctemplate.update(
                    "UPDATE CARTS set is_purchases = true where user_id=?",
                    order.getUser_id()
            );
            if(itemcreated != -1){
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("completed");
            } else {
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("not completed");
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Cart>> listCart() {
        try {
            List<Cart> carts = jdbctemplate.query("select * from CARTS ",
                    new BeanPropertyRowMapper(Cart.class));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(carts);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
