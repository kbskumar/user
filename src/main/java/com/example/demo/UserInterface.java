package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInterface extends MongoRepository<User,String> {

}
