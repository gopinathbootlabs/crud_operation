package com.example.crud.repository;

import com.example.crud.model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Repository
public interface DataRepo extends MongoRepository<Model,Integer> {

}
