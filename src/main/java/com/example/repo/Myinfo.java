package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.CamelModel.Generalingo;

public interface Myinfo extends MongoRepository<Generalingo,String>{

}
