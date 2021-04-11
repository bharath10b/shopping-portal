package com.example.demo.service;

import com.example.demo.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    JdbcTemplate jdbctemplate;

    public ResponseEntity<String> createItem(Item item) {
        try {
            int itemcreated = jdbctemplate.update(
                    "INSERT INTO items (name) VALUES (?)",
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

    public ResponseEntity<List<Item>> listItems() {
        try {
            List<Item> items = jdbctemplate.query("select * from items ",
                    new BeanPropertyRowMapper(Item.class));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(items);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
