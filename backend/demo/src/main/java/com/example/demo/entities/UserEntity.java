package com.example.demo.entities;

import org.springframework.data.repository.CrudRepository;

public interface UserEntity extends CrudRepository<Users, Integer> {
}
