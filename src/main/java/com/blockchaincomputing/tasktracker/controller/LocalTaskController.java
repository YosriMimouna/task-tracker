package com.blockchaincomputing.tasktracker.controller;


import com.blockchaincomputing.tasktracker.model.LocalTask;
import com.blockchaincomputing.tasktracker.repository.LocalTaskRepository;
import com.blockchaincomputing.tasktracker.service.LocalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller responsible for interacting with tasks stored on MongoDB Atlas
 */
@RestController
@RequestMapping(value = "/local/tasks")
public class LocalTaskController {

    @Autowired
    private LocalTaskService localTaskService;

    /**
     * Endpoint for creating and storing LocalTaskobject on MongoDB
     * @return created task object
     */
    @PostMapping(value = "/")
    public ResponseEntity<LocalTask> createTask() {
        return ResponseEntity.ok(this.localTaskService.createTask());
    }

    /**
     * Endpoint to retrieve the number of stored tasks
     * @return task count in database
     */
    @GetMapping(value = "/count")
    public ResponseEntity<Long> getTaskCount() {
        return ResponseEntity.ok(this.localTaskService.getTaskCount());
    }
}
