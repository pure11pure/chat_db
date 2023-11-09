package com.example.chat_db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoRepository extends MongoRepository<Info, String> {
    Info findByInfoId(String nameId);
}