package com.blockchaincomputing.tasktracker.repository;

import com.blockchaincomputing.tasktracker.model.LocalTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalTaskRepository extends MongoRepository<LocalTask, String> {

}
