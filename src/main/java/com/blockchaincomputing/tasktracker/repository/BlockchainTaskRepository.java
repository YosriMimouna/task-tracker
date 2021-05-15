package com.blockchaincomputing.tasktracker.repository;

import com.blockchaincomputing.tasktracker.model.BlockchainTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockchainTaskRepository extends MongoRepository<BlockchainTask, String> {
}
