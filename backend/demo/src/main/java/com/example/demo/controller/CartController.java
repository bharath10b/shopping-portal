package com.example.demo.controller;

import com.example.demo.models.Cart;
import com.example.demo.models.Item;
import com.example.demo.models.Order;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<String> addCart(@RequestBody Item item){
        return cartService.addCart(item);
    }

    @PostMapping(value = "/{cart_id}/complete", produces = "application/json")
    public ResponseEntity<String> completeCart(@RequestBody Order order){
        return cartService.completeCart(order);
    }

    @PostMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<Cart>> listCart(){
        return cartService.listCart();
    }
}
