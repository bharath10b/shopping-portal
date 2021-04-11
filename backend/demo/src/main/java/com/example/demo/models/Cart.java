package com.example.demo.models;

public class Cart {

    Integer id;

    Integer user_id;

    Boolean is_purchased;

    Order order;

    String created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Boolean getIs_purchased() {
        return is_purchased;
    }

    public void setIs_purchased(Boolean is_purchased) {
        this.is_purchased = is_purchased;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
