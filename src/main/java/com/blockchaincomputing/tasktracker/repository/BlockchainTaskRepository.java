package com.blockchaincomputing.tasktracker.repository;

import com.blockchaincomputing.tasktracker.model.BlockchainTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for storing tasks created due to interactions with deployed Smart-Contract
 */
@Repository
public interface BlockchainTaskRepository extends MongoRepository<BlockchainTask, String> {
}
