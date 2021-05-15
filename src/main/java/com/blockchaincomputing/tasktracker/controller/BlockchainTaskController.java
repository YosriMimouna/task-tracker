package com.blockchaincomputing.tasktracker.controller;

import com.blockchaincomputing.tasktracker.service.BlockchainTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.generated.Uint256;

import java.io.IOException;
import java.math.BigInteger;
/**
 * Controller responsible for intercations with the deployed Smart-Contract
 * **/
@RestController
@RequestMapping(value = "/blockchain/tasks")
public class BlockchainTaskController {

    @Autowired
    private BlockchainTaskService blockchainTaskService;

    /**
     * Endpoint that calls method taskCount() on deployed Smart-Contract
     * @Returns number of tasks
     * **/
    @GetMapping(value = "/count")
    public ResponseEntity<?> getSmartContractTaskCount() {
        try {
            return ResponseEntity.ok(this.blockchainTaskService.getSmartContractTaskCount());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Endpoint that triggers newTask() method on deployed Smart-Contract
     * **/
    @PostMapping
    public ResponseEntity<?> test() {
        try {
            return ResponseEntity.ok(this.blockchainTaskService.addBlockChainTask());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
