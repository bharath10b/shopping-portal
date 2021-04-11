package com.example.demo.controller;

import com.example.demo.entities.Users;
import com.example.demo.models.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/create", produces = "application/json")
    public ResponseEntity<String>  createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Item>> listItems(){
        return itemService.listItems();
    }
}
