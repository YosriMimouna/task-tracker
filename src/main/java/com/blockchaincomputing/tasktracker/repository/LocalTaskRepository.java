package com.blockchaincomputing.tasktracker.repository;

import com.blockchaincomputing.tasktracker.model.LocalTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository for storing tasks created locally
 */
@Repository
public interface LocalTaskRepository extends MongoRepository<LocalTask, String> {

}
